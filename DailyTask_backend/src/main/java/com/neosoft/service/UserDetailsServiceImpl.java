package com.neosoft.service;

import com.neosoft.model.Users;
import com.neosoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	 Users users =this.userRepository.findByUsername(username);
	 if(users ==null) {
		 System.out.println("user not found");
		 throw new UsernameNotFoundException("No user found ");
	 }
	 else {
		 return users;
	 }
	}
}
