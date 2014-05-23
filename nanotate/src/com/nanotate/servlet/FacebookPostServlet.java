package com.nanotate.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nanotate.message.JsonResponse;

import utils.JsonEncoder;
import facebook4j.Facebook;
import facebook4j.FacebookException;

public class FacebookPostServlet extends HttpServlet {
    private static final long serialVersionUID = 4179545353414298791L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("facebook")!=null){
        	request.setCharacterEncoding("UTF-8");
        	 String message = request.getParameter("message");
        	 System.out.println("Message: " +message);
             JsonResponse r = new JsonResponse();
             Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
             try {
                r.setData( facebook.postStatusMessage(message));
                
             } catch (FacebookException e) {
                 throw new ServletException(e);
             }
             JsonEncoder.encode(response, r);
        }
        else{
        	ServletContext context = this.getServletContext();
        	RequestDispatcher dispatcher = context.getRequestDispatcher("/facebooksignin");

        	// change your request and response accordingly

        	dispatcher.forward(request, response);
        }
       
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
    
}
