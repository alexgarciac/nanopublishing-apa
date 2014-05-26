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
import com.nanotate.dao.util.MyBatis;
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
                String data = facebook.postStatusMessage(message);
                
                if(!data.equals(""))
                {
                	SqlSession session = MyBatis.getSession();
                	
                	
                	AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
                	AnnotationExample example = new AnnotationExample();
                	example.createCriteria().andDoiEqualTo(request.getParameter("doi"));
                	example.setDistinct(true);
                	String facebook_post =  (String) mapper.selectByExample(example).get(0).getFacebook_posts();
                	if(facebook_post!=null)
                		facebook_post = facebook_post.concat(","+data);
                	else
                		facebook_post=data;
                	Annotation annotation = new Annotation();
                	annotation.setFacebook_posts(facebook_post);
                	mapper.updateByExampleSelective(annotation, example);
                
                	session.commit();
                	session.close();
                }
                
             } catch (Exception e) {
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
