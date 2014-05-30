package com.nanotate.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.nanotate.Settings;
import com.nanotate.dao.model.Annotation;
import com.nanotate.dao.model.AnnotationExample;
import com.nanotate.dao.model.AnnotationMapper;
import com.nanotate.dao.model.AnnotationWithBLOBs;
import com.nanotate.dao.util.MyBatis;
import com.nanotate.message.JsonResponse;
import com.nanotate.thread.FacebookWriter;
import com.nanotate.thread.NanotweetWriter;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import utils.JsonEncoder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

public class SearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7254461811912924374L;

	static Logger log;	
	static Properties config;
	
	static {
		// Debug file 
		DOMConfigurator.configure( Thread.currentThread().getContextClassLoader().getResource("log4j.xml"));
		log = Logger.getLogger(SearchServlet.class);
	}
	
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
    	
    	String limit = req.getParameter("limit");
    	String uuid = req.getParameter("uri");
    	
    	System.out.println(limit+" "+uuid);
    	resp.setCharacterEncoding("UTF-8");
    	resp.setContentType("application/json");
    	resp.getWriter().write("{ \"total\":1,"
    			+ "\"rows\": [{\"id\":\"sadsada12123\", \"text\":\"\",\"ranges\":[{\"start\":\"/div/div/div[2]/div[5]/span/span\",\"startOffset\":0,\"end\":\"/div/div/div[2]/div[5]/span[2]/span\",\"endOffset\":36}],\"quote\":\"Rumination is a well-established risk factor for the onset of major depression and anxiety symptomatol-ogy in both adolescents and adults.\",\"uri\":\"4d702da3-e8c5-4402-9db6-c5cff6120f1d\"}]}");	
    	
    }
	

}
