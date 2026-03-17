package com.securitypractice.springsecuritydbconnection.dto;

import lombok.Data;

@Data
public class AccountResponseDTO {

	private String username;
	private String email;
	private String phone;
	private String fullname;
}
