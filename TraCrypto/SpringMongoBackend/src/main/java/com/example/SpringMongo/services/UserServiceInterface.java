package com.example.SpringMongo.services;

import com.example.SpringMongo.models.User;
import com.example.SpringMongo.models.myCrypto;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public interface UserServiceInterface {

    User updatePerson(HttpServletRequest request, ArrayList<myCrypto> myCryptoList);

}
