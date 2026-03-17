package com.prac.jwt_practice.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.prac.jwt_practice.entity.UserInformation;
import com.prac.jwt_practice.repo.UserJpaRepository;

@Component
public class UserAuthanticationService implements UserDetailsService{

	private UserJpaRepository userjpa;
	
	
	
	public UserAuthanticationService(UserJpaRepository userjpa) {
		super();
		this.userjpa = userjpa;
	}



	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserInformation> info = userjpa.findById(email);
		
		if(info.isPresent()) {
			System.out.println("User Authantication service : "+email);
			return info.get();
		}else {
			throw new UsernameNotFoundException("Username with "+email+" is not found");
		}
		
//		return null;
	}

	
}
