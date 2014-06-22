package com.nanotate.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import com.nanotate.dao.model.Annotation;
import com.nanotate.dao.model.AnnotationExample;
import com.nanotate.dao.model.AnnotationMapper;
import com.nanotate.dao.model.AnnotationWithBLOBs;
import com.nanotate.dao.model.DocumentExample;
import com.nanotate.dao.model.DocumentMapper;
import com.nanotate.dao.model.FacebookPost;
import com.nanotate.dao.model.FacebookPostMapper;
import com.nanotate.dao.model.User;
import com.nanotate.dao.model.UserExample;
import com.nanotate.dao.model.UserMapper;
import com.nanotate.dao.util.MyBatis;
import com.nanotate.message.JsonResponse;







import utils.JsonEncoder;
import utils.SocialBuilder;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;

public class FacebookPostServlet extends HttpServlet {
    private static final long serialVersionUID = 4179545353414298791L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String data=null;
    	boolean credentials = true;
        if(request.getSession().getAttribute("facebook")==null)
        {
        	Facebook facebook = SocialBuilder.getFacebook();
            request.getSession().setAttribute("facebook", facebook);
        }
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");

        try{
        	 facebook.getOAuthAccessToken();
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
			User us =  usMapper.selectByExample(usExample).get(0);
			session.close();
			if(StringUtils.isEmpty(us.getFacebook_token()))
			{
				
				credentials=false;
			}
			else
				facebook.setOAuthAccessToken(new AccessToken(us.getFacebook_token(), us.getFacebook_token_expires()));
			
			
			
        }
       
    	
        	request.setCharacterEncoding("UTF-8");
        	 String message = request.getParameter("original_text");
        	 String id = request.getParameter("id");
        	 String comment = request.getParameter("comment");
        	 String doi = request.getParameter("doi");
        	 System.out.println("Hi mothherfucker!");
        	 System.out.println("Message: " +message);
        	 String username = (String) request.getSession().getAttribute("user");
             JsonResponse r = new JsonResponse();
            if(credentials) 
            {
            	try {
                    data = facebook.postStatusMessage(message+"\n from: "+doi);
                    Post post = facebook.getPost(data.split("_")[1]);
                    if(!StringUtils.isEmpty(comment))
                    facebook.commentPost(post.getId(), comment);
                    
                    if(!data.equals(""))
                    {
                    	SqlSession session = null;
    					try {
    						session = MyBatis.getSession();
    					} catch (Exception e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
                    	FacebookPostMapper mapper=(FacebookPostMapper) session.getMapper(FacebookPostMapper.class);
                    	FacebookPost record = new FacebookPost();
                    	record.setUsername(username);
                    	record.setIdannotation(Integer.parseInt(id));
                    	record.setUrl_post("https://www.facebook.com/"+facebook.getUser(facebook.getId()).getUsername()+"/posts/"+post.getId());
                    	mapper.insert(record);
                    	session.commit();
                    	session.close();
                    }
                    r.setData(post);
                 } catch (FacebookException e) {
                	 e.printStackTrace();
                	 r.setData(e.getErrorMessage());
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
