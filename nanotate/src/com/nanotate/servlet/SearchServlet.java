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
    			+ "\"rows\": [{\"id\":\"sadsada12123\", \"text\":\"\",\"ranges\":[{\"start\":\"/div[3]/div/div/div[2]/div/div[2]/div[2]/span[2]/span\",\"startOffset\":0,\"end\":\"/div[3]/div/div/div[2]/div/div[2]/div[2]/span[25]/span\",\"endOffset\":59}],\"quote\":\"The link between alcohol abuse and poorer relationship out-comes is well established (e.g., Dawson et al., 2007; Leonard & Eiden, 2007; Leonard & Rothbard, 1999; Marshal, 2003). How-ever, it is currently unclear whether the effects of alcohol misuse on relationship functioning are the same for men and women. Much research has focused on relationships in which the husband drinks problematically, partly because of the difference in preva-lence of alcohol use disorders (AUDs) in men and women (e.g., the number of males presenting with an AUD is more than twice the number of females in the population of married and cohabiting adults; Dawson et al., 2007; McCrady & Epstein, 1995; Nolen-Hoeksema & Hilt, 2006; Roberts & Linney, 2000). This research focus may also be because of the extent to which AUDs have historically been theorized as a “male” problem (Haber & Jacob, 1997). In fact, relationship functioning is reported to be the poorest in relationships with discordant alcohol consumption, such that husbands are heavy drinkers and wives are not (Roberts & Leon-ard, 1998). Such couples report higher rates of negative interac-tions and hostile behavior (Jacob, Leonard, & Haber, 2001). Also, in one study, wives’ reports of husbands’ drinking predicted wives’ distrust of and perceived lack of support from husbands up to 5 years later (Wilsnack, & Wilsnack, 1991). In general, heavy and frequent drinking by the husband was predictive of lower relationship quality for the wife (Roberts & Linney, 2000).\",\"uri\":\"c3d69e1d-5133-47d4-b779-f6899b7c176f\"}]}");	
    	
    }
	

}
