package com.basepack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basepack.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username); 
	

}

