package com.neosoft;

import com.neosoft.exception.UserFoundException;
import com.neosoft.model.Role;
import com.neosoft.model.Users;
import com.neosoft.model.UserRole;
import com.neosoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DailyTaskBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DailyTaskBackendApplication.class, args);
	}


	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		try {
//		System.out.println("Strating code");
//
//		Users users =new Users();
//     	users.setFirstName("Yogesh");
//    	users.setLastName("Nirmal");
//     	users.setUsername("Yogesh3020");
//     	users.setPassword(this.bCryptPasswordEncoder.encode("Ascii#3020"));
//     	users.setEmail("Yogesh@gmail.com");
//
//     	Role role1=new Role();
//     	role1.setRoleId(11L);
//     	role1.setRoleName("ADMIN");
//
//     	Set<UserRole> userRoleSet=new HashSet<>();
//     	UserRole userRole=new UserRole();
//     	userRole.setRole(role1);
//     	userRole.setUser(users);
//
//     	userRoleSet.add(userRole);
//
//     	Users users1 =this.userService.createUser(users, userRoleSet);
//     	System.out.println(users1.getUsername());
//
//		}catch(UserFoundException e) {
//			e.printStackTrace();
//		}

	}

}
