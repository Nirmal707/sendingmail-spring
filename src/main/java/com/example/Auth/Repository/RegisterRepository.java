package com.example.Auth.Repository;
import com.example.Auth.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 @Repository

public interface RegisterRepository extends JpaRepository<User, Long> {
    
    }