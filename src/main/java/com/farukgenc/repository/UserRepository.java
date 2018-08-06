package com.farukgenc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farukgenc.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//	User findByUserName(String userName);
//
//	User findByIsDeletedFalseAndUserName(String userName);

}
