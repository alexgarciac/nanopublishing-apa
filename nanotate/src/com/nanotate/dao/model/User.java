package com.nanotate.dao.model;

public class User {

	private String username;
	private String password;
	private String twitter_username;
	private String facebook_username;
	private String firstname;
	private String lastname;
	private String facebook_token;
	private Long facebook_token_expires;
	private String twitter_token;
	private String twitter_token_secret;
	private String profile_pic_url;
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTwitter_username() {
		return twitter_username;
	}

	public void setTwitter_username(String twitter_username) {
		this.twitter_username = twitter_username;
	}

	public String getFacebook_username() {
		return facebook_username;
	}

	public void setFacebook_username(String facebook_username) {
		this.facebook_username = facebook_username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFacebook_token() {
		return facebook_token;
	}

	public void setFacebook_token(String facebook_token) {
		this.facebook_token = facebook_token;
	}

	public Long getFacebook_token_expires() {
		return facebook_token_expires;
	}

	public void setFacebook_token_expires(Long facebook_token_expires) {
		this.facebook_token_expires = facebook_token_expires;
	}

	public String getTwitter_token() {
		return twitter_token;
	}

	public void setTwitter_token(String twitter_token) {
		this.twitter_token = twitter_token;
	}

	public String getTwitter_token_secret() {
		return twitter_token_secret;
	}

	public void setTwitter_token_secret(String twitter_token_secret) {
		this.twitter_token_secret = twitter_token_secret;
	}

	public String getProfile_pic_url() {
		return profile_pic_url;
	}

	public void setProfile_pic_url(String profile_pic_url) {
		this.profile_pic_url = profile_pic_url;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}}