package com.nanotate.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import facebook4j.Facebook;
import facebook4j.FacebookException;

public class CallbackServlet extends HttpServlet {
    private static final long serialVersionUID = 6305643034487441839L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        String oauthCode = request.getParameter("code");
        try {
            facebook.getOAuthAccessToken(oauthCode);
            HttpSession session = request.getSession();
    		session.setAttribute("user", facebook.getId());
    		//setting session to expiry in 30 mins
    		session.setMaxInactiveInterval(30*60);
    		Cookie userName = new Cookie("user", facebook.getId());
    		userName.setMaxAge(30*60);
    		response.addCookie(userName);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }
     
        response.sendRedirect(request.getContextPath() + "/index.html");
    }
}
