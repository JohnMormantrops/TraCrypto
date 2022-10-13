package com.example.SpringMongo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.SpringMongo.models.Crypto;
import com.example.SpringMongo.models.Greeting;
import com.example.SpringMongo.models.User;
import com.example.SpringMongo.models.myCrypto;
import com.example.SpringMongo.repositories.UserRepository;
import com.example.SpringMongo.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.SpringMongo.services.Cryptofinder;

import javax.servlet.http.HttpServletRequest;

//Listening 8093

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/crypto")
public class CryptoController {

    private final UserRepository userRepository;
    @Autowired
    private UserServiceInterface userServiceInterface;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    CryptoController(UserRepository userRepository){
              this.userRepository = userRepository;
    }


    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/users")
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @GetMapping("/crypto")
    public List<Crypto> crypto() throws IOException {
        System.out.println("Getting");
        Cryptofinder cf = new Cryptofinder();
        try{
            List<Crypto> coinData = cf.scrapeCoins();
            return coinData ;
        }catch (Error e){
            System.out.println("HHMMMMM OOOOHHH HNNNNNNOOOOO");
        }
        return null;
    }


    @PutMapping("/addcrypto")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public User updateUser(@RequestBody ArrayList<myCrypto> myCrypto, HttpServletRequest request){
        return userServiceInterface.updatePerson(request, myCrypto);
    }

}
