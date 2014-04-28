package br.com.semavize.pmm.tracking.model;

import java.io.Serializable;


/**
 * 
 * @author S�rgio Augusto
 * 
 * Entidade que representa os dados de entrada, para a consulta.
 *
	String 	cepFrom 		- Representa o CEP de origem. 
	String 	cepTo 			- Representa o CEP de destino.
	enum 	SendType 		- Representa o tipo de envio (sedex normal, sedex 10 ...)
	String 	trackingNumber 	- Representa o numero de rastreio. 
 *
 */

public class MailPackage implements Serializable {
	
	/** */
	private static final long serialVersionUID = -4275917176414101273L;
	
	private String cepFrom;
	
	private String cepTo;
	
	private SendType sendType;
	/** */
	private String trackingNumber;
	
	
	public MailPackage(String cepFrom, String cepTo, SendType sendType,
			String trackingNumber) {
		super();
		this.cepFrom = cepFrom;
		this.cepTo = cepTo;
		this.sendType = sendType;
		this.trackingNumber = trackingNumber;
	}

	public MailPackage(){
		
	};
	
	public String getCepFrom() {
		return cepFrom;
	}
	public void setCepFrom(String cepFrom) {
		this.cepFrom = cepFrom;
	}
	public String getCepTo() {
		return cepTo;
	}
	public void setCepTo(String cepTo) {
		this.cepTo = cepTo;
	}
	
	public SendType getSendType() {
		return sendType;
	}

	public void setSendType(SendType sendType) {
		this.sendType = sendType;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	
	public String toString(){
			return ( "Cep Origem : " + getCepFrom() +"\n"
					+"Cep Destino : " + getCepTo() +"\n"
					+"Tipo de Envio : " + getSendType() +"\n"
					+"Cod. de Rastreio : " + getTrackingNumber() +"\n");
	}
	
}
