package org.nanotate.model;

public class User {
    private String username;

    private String password;

    private String salt;

    private String twitter_id;

    private String facebook_id;

    private String firstname;

    private String lastname;

    private String facebook_token;

    private Long facebook_token_expires;

    private String twitter_token;

    private String twitter_token_secret;

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getTwitter_id() {
        return twitter_id;
    }

    public void setTwitter_id(String twitter_id) {
        this.twitter_id = twitter_id;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public void setFacebook_id(String facebook_id) {
        this.facebook_id = facebook_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}