package com.nanotate.model;

public class Document {
    private String doc_uuid;

    private String doi;

    private String title;

    private String full_citation;

    private Integer year;

    private String uploaded_by;

    public String getDoc_uuid() {
        return doc_uuid;
    }

    public void setDoc_uuid(String doc_uuid) {
        this.doc_uuid = doc_uuid;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFull_citation() {
        return full_citation;
    }

    public void setFull_citation(String full_citation) {
        this.full_citation = full_citation;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getUploaded_by() {
        return uploaded_by;
    }

    public void setUploaded_by(String uploaded_by) {
        this.uploaded_by = uploaded_by;
    }
}