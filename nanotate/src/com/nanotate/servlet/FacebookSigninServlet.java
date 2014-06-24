package com.nanotate.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import utils.SocialBuilder;
import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.conf.ConfigurationBuilder;

public class FacebookSigninServlet extends HttpServlet {
    private static final long serialVersionUID = -7453606094644144082L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  if(request.getSession().getAttribute("facebook")==null)
          {
          	
              request.getSession().setAttribute("facebook", new SocialBuilder().getFacebook());
          }
    	  Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        request.getSession().setAttribute("facebook", facebook);
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        if(!StringUtils.isEmpty(request.getParameter("newuser")))
       	 request.getSession().setAttribute("newuser", "false");
        
        callbackURL.replace(index, callbackURL.length(), "").append("/facebookcallback");
       
        response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
    }
}
