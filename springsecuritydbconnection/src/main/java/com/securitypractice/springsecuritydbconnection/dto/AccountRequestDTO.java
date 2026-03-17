package com.securitypractice.springsecuritydbconnection.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AccountRequestDTO {

	private String username;
	private String password;
	private String email;
	private String phone;
	private String fullname;
	private String role;
	private LocalDateTime createdAt=LocalDateTime.now();
}
