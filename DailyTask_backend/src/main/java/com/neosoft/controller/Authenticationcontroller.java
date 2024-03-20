package com.neosoft.controller;

import com.neosoft.config.JwtUtils;
import com.neosoft.model.JwtRequest;
import com.neosoft.model.JwtResponse;
import com.neosoft.model.Users;
import com.neosoft.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class Authenticationcontroller {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	//generate token
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			}
		catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Usernot found");
		}
		
	// authenticate
		UserDetails userDetails= this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
	String token=this.jwtUtils.generateToken(userDetails);
	return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username,String password) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		} catch (DisabledException e) {
			throw new Exception("User Desable"+e.getMessage());
		}catch (BadCredentialsException e) {
			throw new Exception("invalid credentials"+e.getMessage());
		}
	}
	
	@GetMapping("/current-user")
	public Users getCurrentUser(Principal principal)
	{
		return (Users) this.userDetailsServiceImpl.loadUserByUsername(principal.getName());
	}
}
