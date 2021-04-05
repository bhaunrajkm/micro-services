package com.bhanu.currecnyconversion.repository;

import com.bhanu.currecnyconversion.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> getByName(String name);
}
