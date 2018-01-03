package com.tsc.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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


@Entity
@Table
public class Slot {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bslotId;
	
	@Column
	private Integer bcost;
	
	
	@Column
	private Boolean bpick;
	
	@Column
	private Boolean bdrop;

	@Column
	private String bOTP;

		
	@Transient
	private String vehicleIds;
	
	@Transient
	private String branchIds;

	
	@ManyToOne
	@JoinColumn(name="userId",nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="vehicleId",nullable=false)
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name="branchId",nullable=false)
	private Branch branch;
	
	@OneToMany(mappedBy="slot")
	private Set<ServiceRegistry>  serviceRegistry=new HashSet<ServiceRegistry>();

	public Integer getBslotId() {
		return bslotId;
	}

	public void setBslotId(Integer bslotId) {
		this.bslotId = bslotId;
	}

	public Integer getBcost() {
		return bcost;
	}

	public void setBcost(Integer bcost) {
		this.bcost = bcost;
	}

	public Boolean getBpick() {
		return bpick;
	}

	public void setBpick(Boolean bpick) {
		this.bpick = bpick;
	}

	public Boolean getBdrop() {
		return bdrop;
	}

	public void setBdrop(Boolean bdrop) {
		this.bdrop = bdrop;
	}

	public String getbOTP() {
		return bOTP;
	}

	public void setbOTP(String bOTP) {
		this.bOTP = bOTP;
	}

	public String getVehicleIds() {
		return vehicleIds;
	}

	public void setVehicleIds(String vehicleIds) {
		this.vehicleIds = vehicleIds;
	}

	public String getBranchIds() {
		return branchIds;
	}

	public void setBranchIds(String branchIds) {
		this.branchIds = branchIds;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Set<ServiceRegistry> getServiceRegistry() {
		return serviceRegistry;
	}

	public void setServiceRegistry(Set<ServiceRegistry> serviceRegistry) {
		this.serviceRegistry = serviceRegistry;
	}
	
	
	
		
	
}
