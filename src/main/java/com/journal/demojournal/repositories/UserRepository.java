package com.journal.demojournal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.journal.demojournal.Models.User;


@Repository
public interface  UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
