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
@Table(name="branch")
public class Branch {

	private Integer branchId;
	private String branchName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String country;
	private String landmark;
	private Integer pinno;
	private String state;
	private String street;
	private String contactNo;
	private String emailId;
	private String managerName;
	private Double longitude;
	private Double latitude;
	private Set<Vehicle> vehicle=new HashSet<Vehicle>(0);
	
	
	private Set<Slot> bookslot=new HashSet<Slot>();
	
	
	@OneToMany(mappedBy="branch")
	public Set<Slot> getBookslot() {
		return bookslot;
	}
	public void setBookslot(Set<Slot> bookslot) {
		this.bookslot = bookslot;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getBranchId() {
		return branchId;
	}
	
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	
	@Column
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	@Column
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	@Column
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	@Column
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
	@Column
	public Integer getPinno() {
		return pinno;
	}
	public void setPinno(Integer pinno) {
		this.pinno = pinno;
	}
	
	@Column
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Column
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	@OneToMany(mappedBy="branch")
	public Set<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Set<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	@Column
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	@Column
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	
	
	
	
	
}
