package com.nanotate.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import utils.JsonEncoder;

import com.nanotate.Settings;
import com.nanotate.dao.model.Annotation;
import com.nanotate.dao.model.AnnotationExample;
import com.nanotate.dao.model.AnnotationMapper;
import com.nanotate.dao.model.User;
import com.nanotate.dao.model.UserExample;
import com.nanotate.dao.model.UserMapper;
import com.nanotate.dao.util.MyBatis;
import com.nanotate.message.JsonResponse;
import com.nanotate.thread.NanotweetWriter;

public class LoginServlet extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2832970249563860455L;

	
	static Logger log;	
	static Properties config;
	
	static {
		// Debug file 
		DOMConfigurator.configure( Thread.currentThread().getContextClassLoader().getResource("log4j.xml"));
		log = Logger.getLogger(AnnotationServlet.class);
	}
	
	
	  protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
			doGet(req,resp);
	    }
	  
	  protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
	        
	    	String action = req.getParameter("action");
	    	log.info("LoginServlet request action= "+action);

	    	if ( Settings.SERVICE_LOGIN.equalsIgnoreCase(action) ) {
	    		log.info("Login request");
	    		executeLoginService( req, resp );
	    		
	    	} else {
	    	
	    		executeLogoutService( req, resp );
	    	} 

	    	
	    }


		private void executeLoginService(HttpServletRequest servletRequest, HttpServletResponse servletResponse ) {
			
			JsonResponse r = new JsonResponse();
			String username = servletRequest.getParameter( Settings.PARAM_USERNAME);
			String password = servletRequest.getParameter( Settings.PARAM_PASSWORD );

			try {
				SqlSession session = MyBatis.getSession();
				UserMapper mapper = session.getMapper(UserMapper.class);
				
				UserExample example = new UserExample();
				log.info("User example created");
				
				if ( !StringUtils.isEmpty(username) && !StringUtils.isEmpty(password) ) {
					example.createCriteria().andUsernameEqualTo(username);
					example.createCriteria().andUsernameEqualTo(password);
					log.info("This way");
				} 
				
				example.setOrderByClause("creation DESC");
				
				List<User> users = mapper.selectByExample( example );
				
				r.setData( users );
				r.setCode( Settings.RESPONSE_CODE_OK );
				r.setMessage( Settings.RESPONSE_MSG_OK );
				
			} catch (Exception e) {
				r.setCode( Settings.RESPONSE_CODE_TECHNICAL_ERROR );
				r.setMessage( "Sorry, we're having a technical issue with our database" );
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JsonEncoder.encode(servletResponse, r);
			
		}


		private void executeLogoutService(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
			
			JsonResponse r = new JsonResponse();
			log.info("executeAnnotateService request");
			String text = servletRequest.getParameter( Settings.PARAM_TEXT );
			String uuid = servletRequest.getParameter( Settings.PARAM_UUID );
	        String comment = servletRequest.getParameter( Settings.PARAM_COMMENT );
			
			if ( StringUtils.isEmpty(text) ) {
				r.setCode( Settings.RESPONSE_CODE_PARAM_NOT_VALID );
				r.setMessage( "Text parameter is missing" );
				
			} else if ( StringUtils.isEmpty(uuid) ) {
				r.setCode( Settings.RESPONSE_CODE_PARAM_NOT_VALID );
				r.setMessage( "Document uuid parameter is missing" );
				
			} else {
				NanotweetWriter nanotweetWriter = new NanotweetWriter( text, uuid );
	            //FacebookWriter facebookWriter = new FacebookWriter( text, uuid, comment );

				( new Thread( nanotweetWriter ) ).start();
	            //( new Thread( facebookWriter ) ).start();


				r.setCode(Settings.RESPONSE_CODE_OK);
				r.setMessage(Settings.RESPONSE_MSG_OK );
			}
			
			JsonEncoder.encode(servletResponse, r);
		}


	  
		
		/**
		 * @param args
		 * @throws Exception 
		 */
		public static void main(String[] args) throws Exception {






	    }

	

}
