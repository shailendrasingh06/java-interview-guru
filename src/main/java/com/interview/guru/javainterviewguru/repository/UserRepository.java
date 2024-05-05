package com.interview.guru.javainterviewguru.repository;

import com.interview.guru.javainterviewguru.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
