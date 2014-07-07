package org.annotatorjs.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Range {
	
	private String start;
	private String end;
	private int startOffset;
	private int endOffset;
	
	public Range() {
		// TODO Auto-generated constructor stub
	}
	
	public Range(String start, String end, int startOffset, int endOffset) {
		this.start = start;
		this.end = end;
		this.startOffset = startOffset;
		this.endOffset = endOffset;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getStartOffset() {
		return startOffset;
	}

	public void setStartOffset(int startOffset) {
		this.startOffset = startOffset;
	}

	public int getEndOffset() {
		return endOffset;
	}

	public void setEndOffset(int endOffset) {
		this.endOffset = endOffset;
	}

	

	

}
