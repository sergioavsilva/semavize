package br.com.semavize.pmm.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.jventura.facesmessage.ViewMessage;

@RequestScoped
@Named(value="mblogin")
public class MbLogin implements Serializable {

	private static final long serialVersionUID = 3388546893333509765L;
	
	private static Logger LOG = LoggerFactory.getLogger(MbLogin.class);

	private String name;
	private String password;
	
	@Inject
	private ServletContext sc;
	
	/**
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	public String doLogin() throws IOException, ServletException {

		String page = null;
		//If validation that ok. 
		if(validateAuthentication(name,password)){
			page = redirectForPage();			
		}
		
		name = new String();
		password = new String();
		
		//If else.. page login
		return page;
	}

	/**
	 * Valida se o usuário tem permisão ou não para acessar a aplicação.
	 * 
	 * @param name - nome do usuário
	 * @param password - senha do usuário
	 * @return true se o nome e senha for valido se não false.
	 */
	private boolean validateAuthentication(String name, String password) {
		
		boolean isAuthenticated = true;
		try {
			AuthenticationManager authenticationManager = 
					(AuthenticationManager) getSpringBean("authenticationManager");

			//Do..
			Authentication authenticationRequestToken = createAuthenticationToken(
					name, password);
			
			//Authentication...
			Authentication authenticationResponseToken = authenticationManager
					.authenticate(authenticationRequestToken);

			SecurityContextHolder.getContext().setAuthentication(
					authenticationResponseToken);

		} catch (AuthenticationException e) {
			//Lanca uma mensagem de erro informando que (O nome de usuário ou a senha inserido está incorreto).
			ViewMessage.addError("view.component.message.login");
			isAuthenticated = false;
		}
		
		return isAuthenticated;
	}
	

	/**
	 * Por enquanto existe apenas um tipo de usuário que tem acesso ao modulo de
	 * adminitração do sistema.
	 * 
	 */
	private String redirectForPage(){
		//TODO Melhorar o sistema de login
		String page = null;
		
		Authentication currentUser = SecurityContextHolder.getContext()
				.getAuthentication();
		
		if (currentUser.getName() == null || currentUser.getName().equals("")
				|| currentUser.getName().equals("anonymousUser")) {

			page = "pretty:loging";
		}

		if (currentUser.getName().equals("adm")) {
		
			page = "pretty:administrator";
	
		} else {
			page = "pretty:application";
			
		}
		return page;
	}	

	/**
	 * 
	 * @param nome
	 * @param senha
	 * @return
	 */
	private Authentication createAuthenticationToken(String nome, String senha) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				nome, senha);
		return usernamePasswordAuthenticationToken;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	private Object getSpringBean(String name) {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(sc);
		return ctx.getBean(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
