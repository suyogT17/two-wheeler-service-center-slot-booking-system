package com.tsc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	private Integer roleId;
	private String description;
	private String roleName;
	private Set<User> user=new HashSet<User>(0);
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getRoleId() {
		return roleId;
	}
	
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	@Column
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@OneToMany(mappedBy="role")
	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

}
