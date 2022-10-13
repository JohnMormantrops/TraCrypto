package com.example.SpringMongo.repositories;

import java.util.Optional;

import com.example.SpringMongo.models.ERole;
import com.example.SpringMongo.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}