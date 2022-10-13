package com.example.SpringMongo.payload.response;


import com.example.SpringMongo.models.myCrypto;

import java.util.ArrayList;
import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String id;
    private String username;
    private String email;
    private List<String> roles;

    private ArrayList<myCrypto> myCryptoList;


    public JwtResponse(String accessToken, String id, String username, String email, List<String> roles, ArrayList<myCrypto> myCryptoList) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.myCryptoList = myCryptoList;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public ArrayList<myCrypto> getMyCryptoList() {
        return myCryptoList;
    }

    public void setMyCryptoList(ArrayList<myCrypto> getMyCryptoList) {
        this.myCryptoList = myCryptoList;
    }
}