package com.securitypractice.springsecuritydbconnection.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securitypractice.springsecuritydbconnection.entity.Account;
@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Long>{

	public Optional<Account> findByUsername(String username);
	
	public boolean existsByUsername(String username);
	
	public boolean existsByEmail(String email);
	
}
