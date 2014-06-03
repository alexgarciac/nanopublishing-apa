package com.nanotate.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.nanotate.Settings;
import com.nanotate.dao.model.Annotation;
import com.nanotate.dao.model.AnnotationExample;
import com.nanotate.dao.model.AnnotationMapper;
import com.nanotate.dao.model.AnnotationWithBLOBs;
import com.nanotate.dao.model.DocumentExample;
import com.nanotate.dao.model.DocumentMapper;
import com.nanotate.dao.model.User;
import com.nanotate.dao.model.UserExample;
import com.nanotate.dao.model.UserMapper;
import com.nanotate.dao.util.MyBatis;
import com.nanotate.message.JsonResponse;
import com.nanotate.thread.FacebookWriter;
import com.nanotate.thread.NanotweetWriter;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import utils.JsonEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7254461811912924374L;

	static Logger log;	
	static Properties config;
	
	static {
		// Debug file 
		DOMConfigurator.configure( Thread.currentThread().getContextClassLoader().getResource("log4j.xml"));
		log = Logger.getLogger(UserServlet.class);
	}
	
	private class UserResp extends User{
		
		private int numberan;
		private int numberdoc;
		
	
		public int getNumberan() {
			return numberan;
		}
		public void setNumberan(int numberan) {
			this.numberan = numberan;
		}
		public int getNumberdoc() {
			return numberdoc;
		}
		public void setNumberdoc(int numberdoc) {
			this.numberdoc = numberdoc;
		}
		
		
		
		
	}
	
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
    	
    	JsonResponse r = new JsonResponse();
    	String username =(String) req.getSession().getAttribute("user");
    	SqlSession session;
		try {
			session = MyBatis.getSession();
			AnnotationMapper anMapper = session.getMapper(AnnotationMapper.class);
			DocumentMapper docMapper = session.getMapper(DocumentMapper.class);
			UserMapper usMapper = session.getMapper(UserMapper.class);
			AnnotationExample anExample = new AnnotationExample();
			DocumentExample docExample = new DocumentExample();
			UserExample usExample = new UserExample();
			anExample.createCriteria().andUser_nameEqualTo(username);
			usExample.createCriteria().andUsernameEqualTo(username);
			docExample.createCriteria().andUploaded_byEqualTo(username);
			int docs=docMapper.countByExample(docExample);
			int ans = anMapper.countByExample(anExample);
			User us =  usMapper.selectByExample(usExample).get(0);
			UserResp user = new UserResp();
			user.setFirstname(us.getFirstname());
			user.setLastname(us.getLastname());
			user.setProfile_pic_url(us.getProfile_pic_url());
			user.setNumberdoc(docs);
			user.setNumberan(ans);
			session.close();
			r.setData( user );
			r.setCode( Settings.RESPONSE_CODE_OK );
			r.setMessage( Settings.RESPONSE_MSG_OK );
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonEncoder.encode(resp, r);
    }


	
}


