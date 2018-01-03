package com.tsc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsc.dao.RefMasterMaintainDAOImpl;
import com.tsc.dto.UserRegistrationDto;
import com.tsc.model.Address;
import com.tsc.model.Role;
import com.tsc.model.User;
import com.tsc.util.ApplicationConstantsUtil;
import com.tsc.util.SearchParameter;
import com.tsc.util.SystemConstants;

import javassist.expr.NewArray;

@Service
public class UserService {

	
	@SuppressWarnings("rawtypes")
	@Autowired
	RefMasterMaintainDAOImpl refMasterMaintainDAOImpl;
	
	
	@SuppressWarnings("unchecked")
	public void addNewUser(UserRegistrationDto userRegistrationDto) {
		// TODO Auto-generated method stub
		User user=this.getUser(userRegistrationDto);
		Address address=this.getAddrress(userRegistrationDto);
		
		address.setUser(user);
		
		
		//System.out.println(this.sendRegistrationConfirmationEmail(user));
		if(this.sendRegistrationConfirmationEmail(user))
		{
			refMasterMaintainDAOImpl.saveEntity(user);
			refMasterMaintainDAOImpl.saveEntity(address);
			System.out.println("added");
		}		
	}




	private Address getAddrress(UserRegistrationDto userRegistrationDto) {
		// TODO Auto-generated method stub
		Address add=new Address();
		add.setAddressLine1(userRegistrationDto.getAddressline1());
		add.setAddressLine2(userRegistrationDto.getAddressline2());
		add.setCity(userRegistrationDto.getCity());;
		add.setCountry(userRegistrationDto.getCountry());
		add.setLandmark(userRegistrationDto.getLandmark());
		add.setPinno(userRegistrationDto.getPinno());
		add.setState(userRegistrationDto.getState());
		add.setStreet(userRegistrationDto.getStreet());
		return add;
	}

	private User getUser(UserRegistrationDto userRegistrationDto) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setContactNo(userRegistrationDto.getContactnumber());
		user.setCreationDate(new Date());
		user.setEmailId(userRegistrationDto.getEmailid());
		user.setFirstName(userRegistrationDto.getFirstname());
		user.setIsEnable(true);
		user.setLastName(userRegistrationDto.getLastname());
		user.setPassword("ABCD1234");
		user.setUserName(userRegistrationDto.getUsername());
		
		System.out.println(userRegistrationDto.getLatitude());
		
		
		
		user.setUlatitude(Double.parseDouble(userRegistrationDto.getLatitude()));
		user.setUlongitude(Double.parseDouble(userRegistrationDto.getLongitude()));
		Role role=new Role();
		role.setRoleId(2);
		user.setRole(role);
		
		return user;
	}

	private Boolean sendRegistrationConfirmationEmail(User u) {

		String body =SystemConstants.REGISTRATION_COMPLETE_EMAIL_BODY;
		String mailbody =body.replaceAll("FirstName", u.getFirstName()).replaceAll("password",u.getPassword()).replaceAll("userid", u.getUserName());
		String subject = SystemConstants.REGISTRATION_COMPLETE_EMAIL_SUBJECT;
		String emailId= u.getEmailId();
		//System.out.println("meassage service: "+EmailService.sendEmaill(mailbody, subject, emailId));
		if(EmailService.sendEmaill(mailbody, subject, emailId))
		{
		return true;
		}
		else
		{
			return false;
		}
	}




	@SuppressWarnings("unchecked")
	public UserRegistrationDto getAllUserDetails(String user) {
		// TODO Auto-generated method stub
		UserRegistrationDto userRegistrationDto=new UserRegistrationDto();
		List<SearchParameter> searchParameters=new ArrayList<>();
		SearchParameter search=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "userName", user);
		searchParameters.add(search);
		List<User> userList=refMasterMaintainDAOImpl.findEntityList(User.class, searchParameters, null);
		List<Address> addressList;
		if(userList!=null)
		{   
			List<SearchParameter> searchParameters2=new ArrayList<>();
			SearchParameter search1=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "user.userId", userList.get(0).getUserId());
			searchParameters2.add(search1);
			addressList=refMasterMaintainDAOImpl.findEntityList(Address.class, searchParameters2, null);
		if(addressList!=null){
			
		userRegistrationDto.setAddressline1(addressList.get(0).getAddressLine1());
		userRegistrationDto.setAddressline2(addressList.get(0).getAddressLine2());
		userRegistrationDto.setContactnumber(userList.get(0).getContactNo().toString());
		userRegistrationDto.setEmailid(userList.get(0).getEmailId());
		userRegistrationDto.setFirstname(userList.get(0).getFirstName());
		userRegistrationDto.setUsername(userList.get(0).getUserName());
		
		}
		}
		return userRegistrationDto;
	}
	

}
