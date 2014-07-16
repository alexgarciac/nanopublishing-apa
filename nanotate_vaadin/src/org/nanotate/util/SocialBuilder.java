package org.nanotate.util;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;


public class SocialBuilder {
	
	private Twitter twitter;
	private Facebook facebook;
 
	
	public Facebook getFacebook(){
		
		if(facebook==null){
			facebook4j.conf.ConfigurationBuilder cb = new facebook4j.conf.ConfigurationBuilder();
        	cb.setDebugEnabled(true)
        	  .setOAuthAppId("236285369909239")
        	  .setOAuthAppSecret("df356774233762558c63281d90d21368")
        	  .setOAuthPermissions("basic_info,email,publish_stream");
//        	.setOAuthAppId("1427521897511957")
//    	  .setOAuthAppSecret("9a447eb931f93131af68176c006a1a39")
//    	  .setOAuthPermissions("public_profile,user_friends,email,publish_stream,publish_actions");
        	facebook = new FacebookFactory(cb.build()).getInstance();
		}
		
		return facebook;
		
	}
	
	public Twitter getTwitter(){
		
		if(twitter==null){
		   	twitter4j.conf.ConfigurationBuilder cb = new 	twitter4j.conf.ConfigurationBuilder();
            cb.setDebugEnabled(true)
       //        .setOAuthConsumerKey("x8P2dt3hnTVcVDaq21smdfLf0")
//        .setOAuthConsumerSecret("VfC0A2FiI3Uq1v4NCRJktCpElFgQT7Ri0mxu6E9YsMQuEnpigL");
        .setOAuthConsumerKey("Sa3ficmgHpwDHXGOIJHWSysNK")
        .setOAuthConsumerSecret("PQW9JJuN3RxVKPxyyVy4nUnTdkaEYh4RUiagw3nGt6KHNyTQJH");
            TwitterFactory tf = new TwitterFactory(cb.build());
            twitter = tf.getInstance();
		}
		return twitter;
		
	}
	

}
