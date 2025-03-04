package org.example.springboot.userservice.Data.Repository;

import org.example.springboot.userservice.Data.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> getUserById(String id);
}
