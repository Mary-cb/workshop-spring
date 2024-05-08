package com.springprojeto.demo.repositories;

import com.springprojeto.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
