package org.annotatorjs.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Annotation {
	
	private String id;
	private String annotator_schema_version;
	private String created;
	private String updated;
	private String text;
	private String quote;
	private String uri;
	
	private ArrayList<Range> ranges;
	
	private String user;
	
	private String consumer;
	private ArrayList<String> tags;
	private Permissions permissions;
	
	public Annotation() {
		
	}

	public Annotation(String id, String annotator_schema_version,
			String created, String updated, String text, String quote,
			String uri, ArrayList<Range> ranges, String user, String consumer,
			ArrayList<String> tags, Permissions permissions) {
		this.id = id;
		this.annotator_schema_version = annotator_schema_version;
		this.created = created;
		this.updated = updated;
		this.text = text;
		this.quote = quote;
		this.uri = uri;
		this.ranges = ranges;
		this.user = user;
		this.consumer = consumer;
		this.tags = tags;
		this.permissions = permissions;
	}

	public String getId() {
		return id;
	}

	public void setId(String i) {
		this.id = i;
	}

	public String getAnnotator_schema_version() {
		return annotator_schema_version;
	}

	public void setAnnotator_schema_version(String annotator_schema_version) {
		this.annotator_schema_version = annotator_schema_version;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public ArrayList<Range> getRanges() {
		return ranges;
	}

	public void setRanges(ArrayList<Range> ranges) {
		this.ranges = ranges;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public Permissions getPermissions() {
		return permissions;
	}

	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}
	
	
	

}
