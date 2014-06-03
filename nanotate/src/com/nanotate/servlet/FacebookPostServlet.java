package com.nanotate.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
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
        if(request.getSession().getAttribute("facebook")==null)
        {
        	ConfigurationBuilder cb = new ConfigurationBuilder();
        	cb.setDebugEnabled(true)
        	  .setOAuthAppId("236285369909239")
        	  .setOAuthAppSecret("df356774233762558c63281d90d21368")
        	  .setOAuthPermissions("basic_info,email,publish_stream");
//        	.setOAuthAppId("1427521897511957")
//    	  .setOAuthAppSecret("9a447eb931f93131af68176c006a1a39")
//    	  .setOAuthPermissions("public_profile,user_friends,email,publish_stream,publish_actions");
        	Facebook facebook = new FacebookFactory(cb.build()).getInstance();
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
        	facebook.setOAuthAccessToken(new AccessToken(us.getFacebook_token(), us.getFacebook_token_expires()));
			session.close();
        }
       
    	
        	request.setCharacterEncoding("UTF-8");
        	 String message = request.getParameter("message");
        	 String id = request.getParameter("id");
        	 System.out.println("Hi mothherfucker!");
        	 System.out.println("Message: " +message);
        	 String username = (String) request.getSession().getAttribute("user");
             JsonResponse r = new JsonResponse();
             
             try {
                String data = facebook.postStatusMessage(message.replace(",", " ,"));
                Post post = facebook.getPost(data.split("_")[1]);
                
                if(!data.equals(""))
                {
                	SqlSession session = MyBatis.getSession();
                	FacebookPostMapper mapper=(FacebookPostMapper) session.getMapper(FacebookPostMapper.class);
                	FacebookPost record = new FacebookPost();
                	record.setUsername(username);
                	record.setIdannotation(Integer.parseInt(id));
                	record.setUrl_post("https://wwww.facebook.com/"+facebook.getUser(facebook.getId()).getUsername()+"/posts/"+post.getId());
                	mapper.insert(record);
                	session.commit();
                	session.close();
                }
                
             } catch (Exception e) {
                 throw new ServletException(e);
             }
             JsonEncoder.encode(response, r);
        
       
       
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
    
}
