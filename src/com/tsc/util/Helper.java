package com.tsc.util;

import java.util.Random;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Helper {

	public  static String generatePin() throws Exception {
		final Random generator = new Random();
		generator.setSeed(System.currentTimeMillis());
		String genCode = Integer.toString(generator.nextInt(899999) + 100000);
		return genCode ;
	}
	
	public static String getUsername()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("in helper authentication: "+authentication);
		if ((authentication == null)
				|| authentication.getPrincipal().equals("anonymousUser"))
		{
			return null;
		}
		else
		{
			
			return authentication.getName();
		}
	}
	
}
