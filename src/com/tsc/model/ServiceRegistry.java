package com.tsc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ServiceRegistry {

	
	private Integer serviceRegistryId;

	
	private Slot slot;	
	
	
	@Column
	private Integer userviceId;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getServiceRegistryId() {
		return serviceRegistryId;
	}

	public void setServiceRegistryId(Integer serviceRegistryId) {
		this.serviceRegistryId = serviceRegistryId;
	}

	@ManyToOne
	@JoinColumn(name="bslotId",nullable=false)
	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public Integer getUserviceId() {
		return userviceId;
	}

	public void setUserviceId(Integer userviceId) {
		this.userviceId = userviceId;
	}

		
	
	
}
