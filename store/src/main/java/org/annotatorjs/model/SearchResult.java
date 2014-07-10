package org.annotatorjs.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SearchResult {
	
	private int total;
	private ArrayList<Annotation> rows;
	
	public SearchResult(){}
	
	public SearchResult(int total, ArrayList<Annotation> rows) {
		this.setTotal(total);
		this.setRows(rows);
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public ArrayList<Annotation> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Annotation> rows) {
		this.rows = rows;
	}

	
	
	
	

}
