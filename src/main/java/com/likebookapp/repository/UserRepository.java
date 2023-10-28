package com.likebookapp.repository;

import com.likebookapp.model.entity.User;
import com.likebookapp.model.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String value);

    Optional<User> findByEmail(String value);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
