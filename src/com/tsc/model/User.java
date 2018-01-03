package com.tsc.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;


@Entity
@Table(name="user")
public class User {
private Integer userId;
private String ContactNo;
private Date creationDate;
private String emailId;
private String firstName;
private String lastName;
private Boolean isEnable;
private String password;
private String userName;
private Role role;
private Double ulongitude;
private Double ulatitude;
private Set<Address> address=new HashSet<Address>(0);
private Set<Vehicle> vehicle=new HashSet<Vehicle>(0);
private Set<Slot> bookslot=new HashSet<Slot>();


@OneToMany(mappedBy="user")
public Set<Slot> getBookslot() {
	return bookslot;
}
public void setBookslot(Set<Slot> bookslot) {
	this.bookslot = bookslot;
}


@Id
@GeneratedValue(strategy=GenerationType.AUTO)
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}


@Column
public String getContactNo() {
	return ContactNo;
}
public void setContactNo(String contactNo) {
	ContactNo = contactNo;
}
@Column
public Date getCreationDate() {
	return creationDate;
}
public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
}

@Column
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}

@Column
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

@Column
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

@Column
public Boolean getIsEnable() {
	return isEnable;
}
public void setIsEnable(Boolean isEnable) {
	this.isEnable = isEnable;
}

@Column
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

@Column
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}

@ManyToOne
@JoinColumn(name="roleId",nullable=false)
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}

@OneToMany(mappedBy="user")
public Set<Address> getAddress() {
	return address;
}
public void setAddress(Set<Address> address) {
	this.address = address;
}

@OneToMany(mappedBy="user")
public Set<Vehicle> getVehicle() {
	return vehicle;
}
public void setVehicle(Set<Vehicle> vehicle) {
	this.vehicle = vehicle;
}

@Column
public Double getUlongitude() {
	return ulongitude;
}
public void setUlongitude(Double ulongitude) {
	this.ulongitude = ulongitude;
}

@Column
public Double getUlatitude() {
	return ulatitude;
}
public void setUlatitude(Double ulatitude) {
	this.ulatitude = ulatitude;
}


	



}
