package com.nanotate.dao.model;

public class Document {
    private String uuid;

    private String doi;

    private String title;

    private String full_citation;

    private Integer year;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
}