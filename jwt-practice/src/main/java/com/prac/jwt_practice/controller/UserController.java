package com.prac.jwt_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prac.jwt_practice.LoginDTO;
import com.prac.jwt_practice.UserInformationDTO;
import com.prac.jwt_practice.entity.UserInformation;
import com.prac.jwt_practice.service.UserService;
import com.prac.jwt_practice.util.JwtUtil;

@RestController
public class UserController {

	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserService service;
	
	@Autowired
	private AuthenticationManager authentication;
	
	@GetMapping("/{username}")
	public String user(@PathVariable String username) {
		return util.createToken(username);
	}
	
	@GetMapping("/get-user/{token}")
	public String getUserName(@PathVariable String token) {
		return util.getUserName(token);
	}
	
	@GetMapping("/token-validation/{user}/{token}")
	public boolean isTokenValidate(@PathVariable String  user,@PathVariable String token) {
		return util.isValidateToken(user, token);
	}
	
	@PostMapping("/public/create")
	public UserInformation createUser(UserInformationDTO dto) {
		return service.createUser(dto);
	}
	
	@PostMapping("/public/user/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO dto ) {
		
		UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(dto.getEmailId(),dto.getPassword());
		Authentication auth = authentication.authenticate(credentials);
		System.out.println(auth.getCredentials());
		
		String token = util.createToken(dto.getEmailId());
		
		HttpHeaders responseHeader = new HttpHeaders();
		
		responseHeader.add("Autharization",token);
		
		return new ResponseEntity<String>("welcom to Home : "+dto.getEmailId(),HttpStatus.ACCEPTED);
	}
}
