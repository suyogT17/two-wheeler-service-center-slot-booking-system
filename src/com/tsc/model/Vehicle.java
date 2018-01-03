package com.tsc.model;

import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;


@Entity
@Table(name="vehicle")
public class Vehicle {

	private Integer vehicleId;
	private String chassisNo;
	private String number;
	private Integer noOfFreeServices;
	private Date purchaseDate;
	private Date regiDate;
	private String vehicleName;
	private User user;
	private Branch branch;
	private Integer branchIds;
	private Integer userIds;
	private Set<Slot> bookslot=new HashSet<Slot>();

	
	@OneToMany(mappedBy="vehicle")
	public Set<Slot> getBookslot() {
		return bookslot;
	}
	public void setBookslot(Set<Slot> bookslot) {
		this.bookslot = bookslot;
	}
@Transient
	public Integer getBranchIds() {
		return branchIds;
	}
	public void setBranchIds(Integer branchIds) {
		this.branchIds = branchIds;
	}
	
	@Transient
	public Integer getUserIds() {
		return userIds;
	}
	public void setUserIds(Integer userIds) {
		this.userIds = userIds;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	@Column
	public String getChassisNo() {
		return chassisNo;
	}
	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}
	
	@Column
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Column
	public Integer getNoOfFreeServices() {
		return noOfFreeServices;
	}
	public void setNoOfFreeServices(Integer noOfFreeServices) {
		this.noOfFreeServices = noOfFreeServices;
	}
	
	@Column
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	@Column
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
	
	@Column
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	@ManyToOne
    @JoinColumn(name="userId",nullable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
	@JoinColumn(name="branchId",nullable=false)
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	
}
