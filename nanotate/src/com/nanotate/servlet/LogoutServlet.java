package com.nanotate.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import facebook4j.Facebook;
import twitter4j.Twitter;
import utils.SocialBuilder;

/**
 * Servlet implementation class LogoutServlet
 */
//@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("JSESSIONID")){
    			System.out.println("JSESSIONID="+cookie.getValue());
    		}
    		if(cookie.getName().equals("user")){
    			System.out.println("JSESSIONID="+cookie.getValue());
    			cookie.setMaxAge(0);
    			System.out.println("*********************user="+cookie.getValue());
    			response.addCookie(cookie);
    		}
    	}
    	}
    	//invalidate the session if exists
    	HttpSession session = request.getSession(false);
    	System.out.println("User="+session.getAttribute("user"));
    	Twitter twitter = SocialBuilder.getTwitter();
    	Facebook facebook = SocialBuilder.getFacebook();
    	if(session != null){
    		session.invalidate();
    		twitter.setOAuthAccessToken(null);
    		facebook.setOAuthAccessToken(null);
    	}
    
    	response.sendRedirect("login.html");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

}
