package com.nanotate.dao.model;

public class AnnotationWithBLOBs extends Annotation {

	private String original_text;
	private String facebook_posts;
	private String json_value;

	public String getOriginal_text() {
		return original_text;
	}

	public void setOriginal_text(String original_text) {
		this.original_text = original_text;
	}

	public String getFacebook_posts() {
		return facebook_posts;
	}

	public void setFacebook_posts(String facebook_posts) {
		this.facebook_posts = facebook_posts;
	}

	public String getJson_value() {
		return json_value;
	}

	public void setJson_value(String json_value) {
		this.json_value = json_value;
	}}