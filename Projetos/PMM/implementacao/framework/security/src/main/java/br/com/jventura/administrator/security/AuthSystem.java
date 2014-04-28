package br.com.jventura.administrator.security;

import java.io.Serializable;

import br.com.jventura.administrator.security.entity.User;

public interface AuthSystem extends Serializable{

	/**
	 * 
	 * @param user
	 * @return
	 */
	boolean createUser(User user);
}
