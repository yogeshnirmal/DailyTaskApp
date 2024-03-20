package com.neosoft.service;

import com.neosoft.exception.UserFoundException;
import com.neosoft.model.Users;
import com.neosoft.model.UserRole;
import com.neosoft.repository.RoleRepository;
import com.neosoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public Users createUser(Users users, Set<UserRole> userRoles) throws Exception {
		Users local=
		this.userRepository.findByUsername(users.getUsername());
		if(local!=null) {
		//	System.out.println("user is alreday here");
			throw new UserFoundException();
		}
		else {
			//create user
			for(UserRole ur:userRoles ) {
				roleRepository.save(ur.getRole());
			}
			users.getUserRoles().addAll(userRoles);
			local=this.userRepository.save(users);
		}
		return local;
	}

	//geting user by user name
	@Override
	public Users getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}

	@Override
	public Users update(Users users) {
		// TODO Auto-generated method stub
		return this.userRepository.save(users);
	}

}
