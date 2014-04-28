package br.com.semavize.pmm.mail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entidade que representa o historico de um unico pacote
 * 
 * @author S�rgio Augusto
 *
 */
@XmlRootElement(name = "objeto")
public class PackageHistory implements Serializable{
	
	private static final long serialVersionUID = 2208514273134437627L;
	
	/**
	 * Representa o trackingNumber do pacote.
	 */
	private String numero;
	
	/**
	 * Representa as movimentacoes do pacote.
	 */
	private List<Evento> evento = new ArrayList<Evento>();
	
	/**
	 * 
	 */
	public PackageHistory() {
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Evento> getEvento() {
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "Objeto [numero=" + numero + ", evento=" + evento + "]";
	}	

}
