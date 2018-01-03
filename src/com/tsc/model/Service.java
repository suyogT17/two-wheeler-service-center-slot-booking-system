package com.tsc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="service")
public class Service {

		private Integer serviceId;
		private Integer charges;
		public String name;
		private Integer timeToComplete;
		private ServiceType servicetype;
		private String serviceTypeIds;
		
		
		@Transient
		public String getServiceTypeIds() {
			return serviceTypeIds;
		}
		public void setServiceTypeIds(String serviceTypeIds) {
			this.serviceTypeIds = serviceTypeIds;
		}
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		public Integer getServiceId() {
			return serviceId;
		}
		public void setServiceId(Integer serviceId) {
			this.serviceId = serviceId;
		}
		
		@Column
		public Integer getCharges() {
			return charges;
		}
		public void setCharges(Integer charges) {
			this.charges = charges;
		}
		
		@Column
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		@Column
		public Integer getTimeToComplete() {
			return timeToComplete;
		}
		public void setTimeToComplete(Integer timeToComplete) {
			this.timeToComplete = timeToComplete;
		}
		
		@ManyToOne
		@JoinColumn(name="serviceTypeId",nullable=false)
		public ServiceType getServicetype() {
			return servicetype;
		}
		public void setServicetype(ServiceType servicetype) {
			this.servicetype = servicetype;
		}

		
}
