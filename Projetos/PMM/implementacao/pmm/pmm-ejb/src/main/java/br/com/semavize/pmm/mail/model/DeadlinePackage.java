package br.com.semavize.pmm.mail.model;

public class DeadlinePackage {
	
	/**
	 * 
	 */
	private Integer deadlineDelivere;

	/**
	 * 
	 */
	private Boolean delivereHome;
	
	/**
	 * 
	 */
	private Boolean deliveredSaturday;
	
	/**
	 * 
	 */
	public DeadlinePackage() {
	}
	
	public Integer getDeadlineDelivere() {
		return deadlineDelivere;
	}

	public void setDeadlineDelivere(Integer deadlineDelivere) {
		this.deadlineDelivere = deadlineDelivere;
	}

	public Boolean getDelivereHome() {
		return delivereHome;
	}

	public void setDelivereHome(Boolean delivereHome) {
		this.delivereHome = delivereHome;
	}

	public Boolean getDeliveredSaturday() {
		return deliveredSaturday;
	}

	public void setDeliveredSaturday(Boolean deliveredSaturday) {
		this.deliveredSaturday = deliveredSaturday;
	}	
}
