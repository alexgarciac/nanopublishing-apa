package com.nanotate.dao.model;

public class TwitterPost {
    private Integer idtwitter_post;

    private Integer idannotation;

    private String tweet_url;

    private String username;

    public Integer getIdtwitter_post() {
        return idtwitter_post;
    }

    public void setIdtwitter_post(Integer idtwitter_post) {
        this.idtwitter_post = idtwitter_post;
    }

    public Integer getIdannotation() {
        return idannotation;
    }

    public void setIdannotation(Integer idannotation) {
        this.idannotation = idannotation;
    }

    public String getTweet_url() {
        return tweet_url;
    }

    public void setTweet_url(String tweet_url) {
        this.tweet_url = tweet_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}