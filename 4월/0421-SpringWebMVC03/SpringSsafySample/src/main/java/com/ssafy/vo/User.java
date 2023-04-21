package com.ssafy.vo;

public class User {
    private String user_id; // PK
    private String user_name;
    private String user_password;
    private String email_id; // null 가능, default null
    private String email_domain; // null 가능, default null
    private String join_date; // default current_timestamp

    public User(String user_id, String user_name, String user_password, String email_id, String email_domain, String join_date) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.email_id = email_id;
        this.email_domain = email_domain;
        this.join_date = join_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getEmail_domain() {
        return email_domain;
    }

    public void setEmail_domain(String email_domain) {
        this.email_domain = email_domain;
    }

    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }
}
