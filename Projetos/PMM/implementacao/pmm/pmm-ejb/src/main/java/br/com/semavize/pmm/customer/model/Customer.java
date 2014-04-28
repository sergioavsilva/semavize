package br.com.semavize.pmm.customer.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	/**
	 * 
	 */
	@Id
	private Long id;
	
	/**
	 * Nom do usuario
	 */
	private String name;
	
	/**
	 * E-mail
	 */
	private String email;
	
	/**
	 * Nome da empresa
	 */
	private String company;
	
	/**
	 * Indica se o usuario está em fase de teste.
	 */
	private Boolean userTest;
	
	/**
	 * Se o usuario está em fase de teste, uma quantidade
	 * de pacote é definido para ele testar.
	 */
	private Integer qdtPackages;
	

	public Customer() {
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public Boolean getUserTest() {
		return userTest;
	}


	public void setUserTest(Boolean userTest) {
		this.userTest = userTest;
	}


	public Integer getQdtPackages() {
		return qdtPackages;
	}


	public void setQdtPackages(Integer qdtPackages) {
		this.qdtPackages = qdtPackages;
	}
	
	
	
}
