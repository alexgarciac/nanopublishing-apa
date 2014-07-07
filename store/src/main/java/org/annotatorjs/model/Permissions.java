package org.annotatorjs.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Permissions {

	private ArrayList<String> read;
	private ArrayList<String> admin;
	private ArrayList<String> update;
	private ArrayList<String> delete;
	
	public Permissions() {

	}

	public Permissions(ArrayList<String> read, ArrayList<String> admin,
			ArrayList<String> update, ArrayList<String> delete) {

		this.read = read;
		this.admin = admin;
		this.update = update;
		this.delete = delete;
	}

	public ArrayList<String> getRead() {
		return read;
	}

	public void setRead(ArrayList<String> read) {
		this.read = read;
	}

	public ArrayList<String> getAdmin() {
		return admin;
	}

	public void setAdmin(ArrayList<String> admin) {
		this.admin = admin;
	}

	public ArrayList<String> getUpdate() {
		return update;
	}

	public void setUpdate(ArrayList<String> update) {
		this.update = update;
	}

	public ArrayList<String> getDelete() {
		return delete;
	}

	public void setDelete(ArrayList<String> delete) {
		this.delete = delete;
	}
	
	
	
	
	
	

}
