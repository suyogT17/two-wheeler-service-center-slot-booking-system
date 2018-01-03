package com.tsc.service;


import com.tsc.model.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.tsc.util.ApplicationConstantsUtil;
import com.tsc.util.SearchParameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tsc.dao.RefMasterMaintainDAOImpl;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private RefMasterMaintainDAOImpl refMasterMaintainDAOImpl;

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		UserDetails userDetails  = null;
		List<User> user = new ArrayList<User>();
		//Criterion crt = Restrictions.eq();
		List<SearchParameter> search=new ArrayList<SearchParameter>();
		SearchParameter searchParam=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "userName", arg0);
		search.add(searchParam);
	
		try {
			user = refMasterMaintainDAOImpl.findEntityList(User.class,search ,null);
			if(user!=null){
			System.out.println(user.get(0).getUserName()+" "+user.get(0).getPassword());
			}
			else
			{
					throw new UsernameNotFoundException("user not found");
							
			} 
		System.out.println("got user name");
		userDetails = this.buildUserFromUserEntity(user.get(0));
		System.out.println("executed builduserfromuserentity()");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return userDetails;
	}

	private UserDetails buildUserFromUserEntity(User userEntity) {
		// TODO Auto-generated method stub
		
		System.out.println("in buildUserFromUserEntity()");
		final String username = userEntity.getUserName();
		System.out.println("username: "+username);
		System.out.println("got username in buildUserFromUserEntity()");
		final String password = userEntity.getPassword();
		System.out.println("pass: "+password);
		System.out.println("got password in buildUserFromUserEntity()");
		final boolean enabled = userEntity.getIsEnable();
		System.out.println(enabled);
		System.out.println("got enable in buildUserFromUserEntity()");
		final Collection<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		
		System.out.println("got auth()");
		
		authority.add(new GrantedAuthorityImpl(userEntity.getRole().getRoleName()));
		
		System.out.println("added auth");
		for(GrantedAuthority g:authority)
		{
			System.out.println(g.getAuthority());
		}
		
		org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(username, password, enabled, true, true, true, authority);
		
		System.out.println("before return in buildUserFromUserEntity()");
		return user;
	}

}
 