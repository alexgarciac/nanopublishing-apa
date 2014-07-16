package org.nanotate.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.nanotate.model.User;
import org.nanotate.model.UserExample;
import org.nanotate.model.UserMapper;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import facebook4j.Facebook;
import facebook4j.FacebookFactory;

public class UserUtils {
	
	public static String existsTwitterUser(Twitter twitter){
		
		String ret="";
		
		try {
			SqlSession sqlSession = MyBatis.getSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			UserExample example = new UserExample();
			
			
			example.createCriteria().andTwitter_idEqualTo(String.valueOf(twitter.getId()));
			
			List<User> users = mapper.selectByExample(example);
			
			if(users.size()>0)
				ret=users.get(0).getUsername();
			
			sqlSession.close();

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	}
	
	public static String existsFacebookUser(Facebook facebook){
		
		
		String ret="";
		
		try {
			SqlSession sqlSession = MyBatis.getSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			UserExample example = new UserExample();
			
			
			example.createCriteria().andFacebook_idEqualTo(String.valueOf(facebook.getId()));
			
			List<User> users = mapper.selectByExample(example);
			
			if(users.size()>0)
				ret=users.get(0).getUsername();
			
			sqlSession.close();

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	}
	
	public static boolean validateUser(String username, String password){
		
		boolean ret=false;
		
		
		try {
			SqlSession sqlSession = MyBatis.getSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			User user = mapper.selectByPrimaryKey(username);
			
			BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
			String salt = user.getSalt();
			String encryptedPassword = passwordEncryptor.encryptPassword(password+salt);
			
			if(StringUtils.equals(encryptedPassword, user.getPassword()));
				ret=true;

				sqlSession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	}

	public static Facebook getFacebookUser(String username) {
		
			Facebook facebook = null;
		
		try {
			SqlSession sqlSession = MyBatis.getSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			User user = mapper.selectByPrimaryKey(username);
			if(StringUtils.isNotEmpty(user.getFacebook_token()))
			{
				facebook4j.conf.ConfigurationBuilder cb = new facebook4j.conf.ConfigurationBuilder();
	        	cb.setDebugEnabled(true)
	        	  .setOAuthAppId("1427521897511957")
	        	  .setOAuthAppSecret("b58edb7c40ded996479db0f617f8ad04")
	        	  .setOAuthAccessToken(user.getFacebook_token());
	        	facebook = new FacebookFactory(cb.build()).getInstance();
			}
			
        	

	

			sqlSession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return facebook;
	}

	public static Twitter getTwitterUser(String username) {
		
		Twitter twitter = null;
		
		try {
			SqlSession sqlSession = MyBatis.getSession();
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			User user = mapper.selectByPrimaryKey(username);
			if(StringUtils.isNotEmpty(user.getTwitter_token()))
			{
				twitter4j.conf.ConfigurationBuilder cb = new 	twitter4j.conf.ConfigurationBuilder();
			    cb.setDebugEnabled(true)
				.setOAuthConsumerKey("x8P2dt3hnTVcVDaq21smdfLf0")
				.setOAuthConsumerSecret("VfC0A2FiI3Uq1v4NCRJktCpElFgQT7Ri0mxu6E9YsMQuEnpigL")
				.setOAuthAccessToken(user.getTwitter_token())
				.setOAuthAccessTokenSecret(user.getTwitter_token_secret());
			    
			    TwitterFactory tf = new TwitterFactory(cb.build());
			   twitter = tf.getInstance();
			}
			sqlSession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return twitter;
	}
	
   

}
