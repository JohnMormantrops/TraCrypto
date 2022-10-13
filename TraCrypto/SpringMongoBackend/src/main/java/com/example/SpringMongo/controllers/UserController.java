package com.example.SpringMongo.controllers;

import com.example.SpringMongo.models.User;
import com.example.SpringMongo.repositories.UserRepository;
import com.example.SpringMongo.security.jwt.JwtUtils;
import com.example.SpringMongo.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    private UserServiceInterface userServiceInterface;

    @Autowired
    private JwtUtils jwtUtils;

    UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user")
    public Optional<User> getUser(HttpServletRequest request){
        System.out.println("GET REQ");
        String user = request.getHeader("Authorization");
        System.out.println(user);
        return userRepository.findByUsername(jwtUtils.getUserNameFromJwtToken(user.split(" ")[1]));
    }


    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String id){
        userRepository.deleteById(id);
        return "User deleted";
    }
}
