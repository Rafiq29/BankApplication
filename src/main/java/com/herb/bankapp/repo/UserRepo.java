package com.herb.bankapp.repo;

import com.herb.bankapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByFirstnameAndLastname(String firstname, String lastname);
    Optional<User> findUserByUsername(String username);
}
