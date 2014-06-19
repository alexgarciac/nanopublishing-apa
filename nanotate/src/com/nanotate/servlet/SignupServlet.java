package com.nanotate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import twitter4j.Twitter;

import com.nanotate.dao.model.User;
import com.nanotate.dao.model.UserExample;
import com.nanotate.dao.model.UserMapper;
import com.nanotate.dao.util.MyBatis;

import facebook4j.Facebook;
import facebook4j.auth.AccessToken;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// get request parameters for userID and password
		String username = request.getParameter("user");
		System.out.println(username);
		
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		System.out.println(name);
		String email = request.getParameter("email");
		String imgurl=request.getParameter("img");
		String authCode=request.getParameter("authcode");
		System.out.println(imgurl);
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatis.getSession();
			session.setAttribute("user", username);
			UserMapper um=sqlSession.getMapper(UserMapper.class);
			User record = new User();
			record.setUsername(username);
			if(name.indexOf(" ")!=-1){
				
				record.setFirstname(name.substring(0, name.indexOf(" ")));
				record.setLastname(name.substring(name.indexOf(" "),name.length() ));
				
			}
			else
			{
				record.setFirstname(name);
			}
			
			record.setPassword(pwd);
			
			record.setProfile_pic_url(imgurl);
			record.setEmail(email);
			if(request.getSession().getAttribute("facebook")!=null)
			{
			Facebook facebook= (Facebook)request.getSession().getAttribute("facebook");
			record.setFacebook_token(facebook.getOAuthAccessToken().getToken());
			record.setFacebook_token_expires(facebook.getOAuthAccessToken().getExpires());
			 facebook4j.User user = (facebook4j.User) facebook.getUser(facebook.getId());
			if(StringUtils.isEmpty(user.getUsername()))
			 record.setFacebook_username(user.getId());
			else
				record.setFacebook_username(user.getUsername());
			}
			else{
				Twitter twitter= (Twitter)request.getSession().getAttribute("twitter");
				record.setTwitter_token(twitter.getOAuthAccessToken().getToken());
				record.setTwitter_username(username);
				record.setTwitter_token_secret(twitter.getOAuthAccessToken().getTokenSecret());
			}
			um.insert(record);
			sqlSession.commit();
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", username);
			userName.setMaxAge(30*60);
			sqlSession.close();
			response.addCookie(userName);
			response.sendRedirect("/nanotate/index.html");
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Database troubles</font>");
			rd.include(request, response);
		}


	}

}
