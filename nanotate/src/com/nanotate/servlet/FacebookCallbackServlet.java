package com.nanotate.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import utils.JsonEncoder;

import com.nanotate.dao.model.DocumentMapper;
import com.nanotate.dao.model.User;
import com.nanotate.dao.model.UserExample;
import com.nanotate.dao.model.UserMapper;
import com.nanotate.dao.util.MyBatis;
import com.nanotate.message.JsonResponse;
import com.nanotate.thread.NanotweetWriter;

import facebook4j.Account;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.PictureSize;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;


public class FacebookCallbackServlet extends HttpServlet {
	Logger log = Logger.getLogger(FacebookCallbackServlet.class);
    private static final long serialVersionUID = 6305643034487441839L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        String oauthCode = request.getParameter("code");
        String redirect = "";
        JsonResponse r = new JsonResponse();
        if(StringUtils.isEmpty((CharSequence) request.getSession().getAttribute("newuser")))
        {
        try {
            facebook.getOAuthAccessToken(oauthCode);
            ResponseList<Account> accounts = facebook.getAccounts();
            log.info("Here I am "+accounts.size());
            if(accounts.size()>0){
            	for(Account account : accounts){
            		log.info(account.getName()+": "+account.getAccessToken());
            		
            	}
            	
            }
           
            HttpSession session = request.getSession();
            facebook4j.User user = (facebook4j.User) facebook.getUser(facebook.getId());
            String username = user.getUsername();
            String email=user.getEmail();
            String name= user.getFirstName()+" "+user.getLastName();
            String img=facebook.getPictureURL(facebook.getId(), PictureSize.large).toString();
			SqlSession sqlSession = MyBatis.getSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			UserExample userex = new UserExample();
			userex.createCriteria().andFacebook_usernameEqualTo(username);
			List<User> users = mapper.selectByExample(userex);
			if(users.size()<=0){
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
       
        }
        else
        {
       
			try {
				SqlSession sqlSession = MyBatis.getSession();
				UserMapper mapper = sqlSession.getMapper(UserMapper.class);
				User record = mapper.selectByPrimaryKey((String) request.getSession().getAttribute("user"));
				AccessToken token =  facebook.getOAuthAccessToken(oauthCode);
				record.setFacebook_token(token.getToken());
				record.setFacebook_token_expires(token.getExpires());
				 facebook4j.User user = (facebook4j.User) facebook.getUser(facebook.getId());
				if(StringUtils.isEmpty(user.getUsername()))
					 record.setFacebook_username(user.getId());
					else
						record.setFacebook_username(user.getUsername());
				mapper.updateByPrimaryKey(record);
				sqlSession.commit();
				sqlSession.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
        }
        response.sendRedirect(request.getContextPath() + redirect);
    }
}
