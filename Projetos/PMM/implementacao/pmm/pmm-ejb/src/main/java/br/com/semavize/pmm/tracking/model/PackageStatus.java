package br.com.semavize.pmm.tracking.model;

import java.io.Serializable;

import br.com.semavize.pmm.mail.model.PackageHistory;

/**
 * 
 * @author S�rgio Augusto
 * 
 */
public class PackageStatus implements Serializable{
	
	private static final long serialVersionUID = 1819589644511135922L;
	
	/**
	 * Representa o numero de rastreio Date
	 */
	private String trackingNumber;
	
	/**
	 * Representa a data que deve ser entregue o pacote  
	 */
	private String dateBeenDelivered;
	
	/**
	 * Representa o tempo que o pacote esta  em movimento. 
	 */
	private int leadTime;
	
	/**
	 * Representa o historico de movimentacao do pacote.
	 */
	private PackageHistory pkgHistory;
	
	/**
	 * 
	 */
	public PackageStatus() {
	}
	
	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
	public String getDateBeenDelivered() {
		return dateBeenDelivered;
	}

	public void setDateBeenDelivered(String dateBeenDelivered) {
		this.dateBeenDelivered = dateBeenDelivered;
	}

	public int getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}

	public PackageHistory getPkgHistory() {
		return pkgHistory;
	}

	public void setPkgHistory(PackageHistory pkgHistory) {
		this.pkgHistory = pkgHistory;
	}

	@Override
	public String toString() {
		return "PackageStatus [trackingNumber=" + trackingNumber
				+ ", dateBeenDelivered=" + dateBeenDelivered + ", leadTime="
				+ leadTime + ", pkgHistory=" + pkgHistory + "]";
	}
}
