package com.prac.jwt_practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.jwt_practice.entity.UserInformation;

public interface UserJpaRepository extends JpaRepository<UserInformation, String>{

}
