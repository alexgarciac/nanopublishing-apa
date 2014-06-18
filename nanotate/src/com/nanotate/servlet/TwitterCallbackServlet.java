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

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.nanotate.dao.model.User;
import com.nanotate.dao.model.UserExample;
import com.nanotate.dao.model.UserMapper;
import com.nanotate.dao.util.MyBatis;

import facebook4j.PictureSize;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class TwitterCallbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1657390011452788111L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");
        RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
        String verifier = request.getParameter("oauth_verifier");
        String oauthCode = request.getParameter("code");
        String redirect = "";
        try {
        	System.out.println(verifier+" "+requestToken);
            twitter.getOAuthAccessToken(requestToken, verifier);
            HttpSession session = request.getSession();
            twitter4j.User user = (twitter4j.User) twitter.showUser(twitter.getId());
            String username = twitter.getScreenName();
            String email="";
            String name= user.getName();
            String img=user.getProfileImageURL();
			SqlSession sqlSession = MyBatis.getSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			UserExample userex = new UserExample();
			userex.createCriteria().andTwitter_usernameEqualTo(username);
			List<User> users = mapper.selectByExample(userex);
			if(users.size()<=0){
				System.out.println("Holaaaaaaaaaaaaaaaa");
				redirect="/register.html?"+"username="+username+"&email="+email+"&name="+URLEncoder.encode(name,"UTF-8")+"&img="+img+"&authcode="+oauthCode;
				}
			else{
				redirect="/index.html";
	    		session.setAttribute("user", username);
//	    		session.setAttribute("imgurl", user.getPicture().getURL());
	    		//setting session to expiry in 30 mins
	    		session.setMaxInactiveInterval(30*60);
	    		Cookie userName = new Cookie("user", username);
	    		userName.setMaxAge(30*60);
	    		response.addCookie(userName);
			}
			
        } catch (Exception e) {
            throw new ServletException(e);
        }
        response.sendRedirect(request.getContextPath() + redirect);
    }
}
