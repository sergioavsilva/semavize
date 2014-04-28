package br.com.jventura.administrator.security.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.jventura.administrator.security.Security;

public class SecurityImpl implements Security {

	public String currentUser() {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		return currentUser.getName();
	}

	public void createUser(String name, String password) {
		
		
	}
	
	

}
