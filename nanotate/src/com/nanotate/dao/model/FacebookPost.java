package com.nanotate.dao.model;

public class FacebookPost {
    private Integer idfacebook_post;

    private Integer idannotation;

    private String username;

    private String url_post;

    public Integer getIdfacebook_post() {
        return idfacebook_post;
    }

    public void setIdfacebook_post(Integer idfacebook_post) {
        this.idfacebook_post = idfacebook_post;
    }

    public Integer getIdannotation() {
        return idannotation;
    }

    public void setIdannotation(Integer idannotation) {
        this.idannotation = idannotation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl_post() {
        return url_post;
    }

    public void setUrl_post(String url_post) {
        this.url_post = url_post;
    }
}