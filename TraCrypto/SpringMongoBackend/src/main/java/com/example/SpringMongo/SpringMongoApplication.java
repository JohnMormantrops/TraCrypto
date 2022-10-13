package com.example.SpringMongo;

import com.example.SpringMongo.models.User;
import com.example.SpringMongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;


@SpringBootApplication
@ComponentScan
public class SpringMongoApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	@Autowired
	public SpringMongoApplication(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		for(User user: userRepository.findAll()){
			System.out.println(user);
		}
	}
}
