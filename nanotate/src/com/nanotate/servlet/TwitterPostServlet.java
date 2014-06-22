/*
Copyright (c) 2007-2009, Yusuke Yamamoto
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of the Yusuke Yamamoto nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY Yusuke Yamamoto ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL Yusuke Yamamoto BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package com.nanotate.servlet;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;
import utils.JsonEncoder;
import utils.SocialBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import com.nanotate.dao.model.FacebookPost;
import com.nanotate.dao.model.FacebookPostMapper;
import com.nanotate.dao.model.TwitterPost;
import com.nanotate.dao.model.TwitterPostMapper;
import com.nanotate.dao.model.User;
import com.nanotate.dao.model.UserExample;
import com.nanotate.dao.model.UserMapper;
import com.nanotate.dao.util.MyBatis;
import com.nanotate.message.JsonResponse;











import java.io.IOException;

public class TwitterPostServlet extends HttpServlet {
    private static final long serialVersionUID = 2132731135996613711L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User us=null;
        Status data = null;
        boolean credentials = true;
        if(request.getSession().getAttribute("twitter")==null)
        {
        	Twitter twitter = SocialBuilder.getTwitter();
            request.getSession().setAttribute("twitter", twitter);
        }
        Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");

        try{
        	 twitter.getOAuthAccessToken();
        }
        catch (Exception e){
        	SqlSession session = null;
        	try {
				session = MyBatis.getSession();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserMapper usMapper = session.getMapper(UserMapper.class);
			UserExample usExample = new UserExample();
			usExample.createCriteria().andUsernameEqualTo((String) request.getSession().getAttribute("user"));
			us =  usMapper.selectByExample(usExample).get(0);
			if(StringUtils.isEmpty(us.getTwitter_token())||StringUtils.isEmpty(us.getTwitter_token_secret()))
			{
				
				credentials=false;
			}
			else
				twitter.setOAuthAccessToken(new AccessToken(us.getTwitter_token(),us.getTwitter_token_secret()));
        	
			session.close();
        }
        	
    	
        	request.setCharacterEncoding("UTF-8");
        	 String message = request.getParameter("message");
        	 String id = request.getParameter("id");
        	 System.out.println("Hi mothherfucker!");
        	 System.out.println("Message: " +message);
        	 String username = (String) request.getSession().getAttribute("user");
             JsonResponse r = new JsonResponse();
           if(credentials) 
           {
        	   try {
                   data = twitter.updateStatus(message);
                  
                   
                   if(!data.equals(""))
                   {
                   	SqlSession session = null;
   					try {
   						session = MyBatis.getSession();
   					} catch (Exception e) {
   						// TODO Auto-generated catch block
   						e.printStackTrace();
   					}
                   	TwitterPostMapper mapper=(TwitterPostMapper) session.getMapper(TwitterPostMapper.class);
                   	TwitterPost record = new TwitterPost();
                   	record.setUsername(username);
                   	record.setIdannotation(Integer.parseInt(id));
                   	record.setTweet_url("www.twitter.com/"+twitter.getScreenName()+"/"+data.getId());
                   	mapper.insert(record);
                   	session.commit();
                   	session.close();
                   }
                   r.setData(data);
                   
                } catch (TwitterException e) {
               	 e.printStackTrace();
               	 r.setData(e.getErrorMessage());
//                    throw new ServletException(e);
                }
           }
           else
        	   r.setData(credentials);
            
             
        
             JsonEncoder.encode(response, r);
       
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
 }
