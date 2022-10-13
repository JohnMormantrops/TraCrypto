package com.example.SpringMongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @DBRef
    private Set<com.example.SpringMongo.models.Role> roles = new HashSet<>();

    @Field
    private ArrayList<myCrypto> myCryptoList;

    public User() {
    }

    public User(String username){

        this.myCryptoList= new ArrayList<myCrypto>();
    }
    public User(String username, String email, String password, ArrayList<myCrypto> myCryptoList ){
        this.username = username;
        this.email = email;
        this.password = password;
        this.myCryptoList= myCryptoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<com.example.SpringMongo.models.Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<com.example.SpringMongo.models.Role> roles) {
        this.roles = roles;
    }

    public void setMyCryptoList(ArrayList<myCrypto> myCryptoList){
        this.myCryptoList = myCryptoList;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                " username " + username +
                ", myCryptoList=" + myCryptoList +
                '}';
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<myCrypto> getMyCryptoList() {
        return myCryptoList;
    }
}
