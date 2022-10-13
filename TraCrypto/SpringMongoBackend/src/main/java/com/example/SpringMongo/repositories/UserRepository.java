package com.example.SpringMongo.repositories;


import com.example.SpringMongo.models.User;
import com.example.SpringMongo.models.myCrypto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    //Optional<User> updateCrypto(String id, ArrayList<myCrypto> myCryptoList);
}
