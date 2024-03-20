package com.neosoft.model;

import javax.persistence.*;

@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userRoleId;
	
	//user
	@ManyToOne(fetch = FetchType.EAGER)
	private Users users;
	
	@ManyToOne
	private Role role;

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUser(Users users) {
		this.users = users;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRole(long userRoleId, Users users, Role role) {
		super();
		this.userRoleId = userRoleId;
		this.users = users;
		this.role = role;
	}

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
