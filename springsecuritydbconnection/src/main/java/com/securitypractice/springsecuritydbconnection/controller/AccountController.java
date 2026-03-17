package com.securitypractice.springsecuritydbconnection.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.securitypractice.springsecuritydbconnection.dto.AccountRequestDTO;
import com.securitypractice.springsecuritydbconnection.dto.AccountResponseDTO;
import com.securitypractice.springsecuritydbconnection.service.AccountService;

@RestController
public class AccountController {

	private AccountService service;

	public AccountController(AccountService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/public")
	public AccountResponseDTO create(@RequestBody AccountRequestDTO dto) {
		return service.createAccount(dto);
	}
	
	@GetMapping("/findby-id/{id}")
	public AccountResponseDTO getById(@PathVariable long id) {
		return service.getById(id);
	}
	
	@GetMapping("/admin/all")
	public List<AccountResponseDTO> getAllAccount(){
		return service.getAllAccount();
		
	}
	
	@GetMapping("public/profile")
	public String profile(Authentication auth) {
		return auth.getName() + auth.getAuthorities();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable long id) {
		return service.deleteById(id);
	}
	
	
}
