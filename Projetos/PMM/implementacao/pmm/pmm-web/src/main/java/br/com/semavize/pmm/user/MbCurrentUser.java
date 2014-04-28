package br.com.semavize.pmm.user;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jventura.administrator.security.Security;
import br.com.jventura.administrator.security.impl.SecurityImpl;

@ViewScoped
@Named(value="mbCurrentUser")
public class MbCurrentUser implements Serializable{

	private static final long serialVersionUID = 2006459629139355816L;

	@Inject
	private Logger log;
	
	private String nameCurrentUser;
	
	public MbCurrentUser() {
		init();
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Iniciando MbCurrentUser..");
		
		Security security = new SecurityImpl();
		
		nameCurrentUser = security.currentUser();
	}
	
	public String getNameCurrentUser() {
		return nameCurrentUser;
	}

	public void setNameCurrentUser(String nameCurrentUser) {
		this.nameCurrentUser = nameCurrentUser;
	}
	
	
}
