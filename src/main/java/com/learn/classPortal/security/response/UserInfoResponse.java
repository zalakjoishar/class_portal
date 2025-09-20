package com.learn.classPortal.security.response;

import java.util.List;

public class UserInfoResponse {
    private int id;
    private String jwtToken;
    private String name;
    private String emailId;
    private List<String> roles;

    public UserInfoResponse(int id, String name, List<String> roles, String emailId, String jwtToken) {
        this.id = id;
        this.name = name;
        this.roles = roles;
        this.emailId = emailId;
        this.jwtToken = jwtToken;
    }

    public UserInfoResponse(int id, String name, List<String> roles) {
        this.id = id;
        this.name = name;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getemailId() {
        return emailId;
    }

    public void setemailId(String emailId) {
        this.emailId = emailId;
    }
}