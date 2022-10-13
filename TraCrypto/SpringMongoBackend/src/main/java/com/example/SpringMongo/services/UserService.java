package com.example.SpringMongo.services;

import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.example.SpringMongo.models.User;
import com.example.SpringMongo.models.myCrypto;
import com.example.SpringMongo.repositories.UserRepository;
import com.example.SpringMongo.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    //private MongoTemplate mongoTemplate;
    @Override
    public User updatePerson(HttpServletRequest request, ArrayList<myCrypto> myCryptoList) {

        System.out.println("update person from personService");

        String user = request.getHeader("Authorization");

        Optional<User> opUser = userRepository.findByUsername(jwtUtils.getUserNameFromJwtToken(user.split(" ")[1]));
        User curUser = opUser.get();

        System.out.println(curUser);
        curUser.setMyCryptoList(myCryptoList);
        System.out.println("LIST SET??");
        System.out.println(curUser);
        userRepository.save(curUser);
//        List<User> user = mongoTemplate.find(query, User.class);
//        System.out.println("Found one??");
//        System.out.println(user);
        return curUser;
    }

}
