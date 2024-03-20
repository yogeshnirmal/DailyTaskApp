package com.neosoft.service;

import com.neosoft.model.Users;
import com.neosoft.model.UserRole;

import java.util.Set;

public interface UserService {

	public Users createUser(Users users, Set<UserRole> userRoles) throws Exception;
	
	public Users getUser(String usernmae);
	
	public void deleteUser(long userId);

	public Users update(Users users);
}
