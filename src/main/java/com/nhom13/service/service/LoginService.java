package com.nhom13.service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.nhom13.model.User;
import com.nhom13.payload.request.LoginRequest;
import com.nhom13.payload.response.JwtResponse;
import com.nhom13.repository.UserRepository;
import com.nhom13.security.jwt.JwtProvider;
import com.nhom13.security.userprincipal.UserPrincipal;
import com.nhom13.service.impl.IUserService;

@Service
public class LoginService {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	IUserService userService;
	
	public JwtResponse authenticateUser(LoginRequest request, String rolePrefix) {
		Optional<User> user = userService.findByUsername(request.getUsername());
		if(user.get().getRoles().toString().equals("ADMIN") || user.get().isStatus()) {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(rolePrefix + request.getUsername(), request.getPassword()));
				SecurityContextHolder.getContext().setAuthentication(authentication);
				String token = jwtProvider.createToken(authentication, rolePrefix);
				UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
				return new JwtResponse(token, userPrincipal.getUsername(), userPrincipal.getAuthorities());
		}
		else {
			return null;
		}
		
	}

}
