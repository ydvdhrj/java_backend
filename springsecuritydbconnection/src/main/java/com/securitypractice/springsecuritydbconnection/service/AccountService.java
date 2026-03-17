package com.securitypractice.springsecuritydbconnection.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.securitypractice.springsecuritydbconnection.dto.AccountRequestDTO;
import com.securitypractice.springsecuritydbconnection.dto.AccountResponseDTO;
import com.securitypractice.springsecuritydbconnection.entity.Account;
import com.securitypractice.springsecuritydbconnection.repo.AccountJpaRepository;

@Service
public class AccountService {

	private AccountJpaRepository jpa;

	private PasswordEncoder encode;

	public AccountService(AccountJpaRepository jpa, PasswordEncoder encode) {
		this.jpa = jpa;
		this.encode = encode;
	}

	public AccountResponseDTO createAccount(AccountRequestDTO dto) {
		if (jpa.existsByUsername(dto.getUsername())) {
			throw new RuntimeException("user name exist");
		}
		if (jpa.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("user email exist");
		}

		Account account = new Account();
		account.setUsername(dto.getUsername());
		account.setFullname(dto.getFullname());
		account.setPassword(encode.encode(dto.getPassword()));
		account.setPhone(dto.getPhone());
		account.setCreatedAt(dto.getCreatedAt());
		account.setRole(normalizeAndValidateRole(dto.getRole()));
		account.setEmail(dto.getEmail());

		jpa.save(account);

		return toResponse(account);

	}

	public String normalizeAndValidateRole(String role) {
		if (role == null || role.trim().isEmpty()) {
			return "ROLE_USER";
		}

		String r = role.trim().toUpperCase();
		if (!r.startsWith("ROLE_")) {
			r = "ROLE_" + r;
		}

		if (!(r.equalsIgnoreCase("ROLE_USER") || r.equalsIgnoreCase("ROLE_ADMIN"))) {
			throw new RuntimeException("Invalid Role for Authorization");
		}
		return r;
	}

	public AccountResponseDTO toResponse(Account a) {

		AccountResponseDTO dto = new AccountResponseDTO();
		dto.setEmail(a.getEmail());
		dto.setPhone(a.getPhone());
		dto.setFullname(a.getFullname());
		dto.setUsername(a.getUsername());

		return dto;
	}

	public AccountResponseDTO getById(Long id) {
		Account account = jpa.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
		return toResponse(account);
	}

	public List<AccountResponseDTO> getAllAccount() {

		List<Account> allAccounts = jpa.findAll();
		return allAccounts.stream().map(acc -> toResponse(acc)).collect(Collectors.toList());

	}
	
	@PreAuthorize("hasRole('ADMIN')") // this is only access by admin
	public String deleteById(long id) {
		Account account = jpa.findById(id).orElseThrow(()->
		new RuntimeException("Id not found")
		);
		jpa.deleteById(account.getId());
		return "Deleted";
		
	}
}
