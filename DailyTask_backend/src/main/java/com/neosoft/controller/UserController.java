package com.neosoft.controller;

import com.neosoft.model.Role;
import com.neosoft.model.Users;
import com.neosoft.model.UserRole;
import com.neosoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/")
	public Users createUser(@RequestBody Users users) throws Exception {
		
		//encoding pasword with bCryptPasswordEncoder
		users.setPassword(this.bCryptPasswordEncoder.encode(users.getPassword()));
		Set<UserRole> roles= new HashSet<>();
		
		Role role=new Role();
		role.setRoleId(12L);
		role.setRoleName("NORMAL");
	
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(users);
		roles.add(userRole);
		
		return this.userService.createUser(users, roles);
	}

	@GetMapping("/{username}")
	public Users getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") long userId) {
		userService.deleteUser(userId);
	}
	
	@PutMapping("/updateProduct/{id}")
	public Users updateUser(@RequestBody Users users, @PathVariable  long userId) {
		users.setId(userId); //calling data
		Users ur=userService.update(users);
		return ur;
	}
}
