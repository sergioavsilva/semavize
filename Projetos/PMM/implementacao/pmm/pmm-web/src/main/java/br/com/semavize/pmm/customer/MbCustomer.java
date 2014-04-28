package br.com.semavize.pmm.customer;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.jventura.commonsresource.controller.BaseController;
import br.com.semavize.pmm.customer.model.Customer;

@ViewScoped
@Named(value="mbCustomer")
public class MbCustomer extends BaseController<MbCustomer> implements Serializable{

	private static final long serialVersionUID = -1646048987572338186L;


	private EntityManager em;
	
	@Inject
	private Logger log;
	
	/**
	 * Cliente
	 */
	private Customer customer;
	
	public MbCustomer() {
	}
	
	@PostConstruct
	public void init(){
		customer = new Customer();
	}
	
	private void create(){
		
	}
	
	@Override
	public void execute() {
	}

	@Override
	public void refrehInputs() {
		
	}

	@Override
	public void refrehInputsMandatory() {
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
