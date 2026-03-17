package com.prac.jwt_practice.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.prac.jwt_practice.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserAuthanticationService authenticationSerivce;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = request.getHeader("Autharization");
		String emailId=null;
		if(token!=null && !token.isEmpty() && !token.isBlank()) {
			
			emailId = util.getUserName(token);
			System.out.println("Request came from token is valide "+emailId);
		}else {
			System.out.println("Once per request filter token is invalid "+token);
		}
		
		if(emailId!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = authenticationSerivce.loadUserByUsername(emailId);
			
			boolean validToken=util.isValidateToken(userDetails.getUsername(), token);
			
			System.out.println("Result of valid token : "+validToken);
			if(validToken) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}else {
				System.out.println("Invalid token : "+emailId);
			}
			
		}
		filterChain.doFilter(request, response);
	}

}
