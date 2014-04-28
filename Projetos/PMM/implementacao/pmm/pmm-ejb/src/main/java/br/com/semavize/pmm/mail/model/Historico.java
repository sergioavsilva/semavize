package br.com.semavize.pmm.mail.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sroxml")
public class Historico {

	/**
	 * 
	 */
	private String versao;

	/**
	 * Quantidade de pacotes consultados.
	 */
	private int qtd;

	/**
	 * 
	 */
	private String tipoPesquisa;

	/**
	 * 
	 */
	private String tipoResultado;

	/**
	 * Pacotes consultados
	 */
	private List<PackageHistory> objeto = new ArrayList<PackageHistory>();

	
	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public String getTipoPesquisa() {
		return tipoPesquisa;
	}

	public void setTipoPesquisa(String tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
	}

	public String getTipoResultado() {
		return tipoResultado;
	}

	public void setTipoResultado(String tipoResultado) {
		this.tipoResultado = tipoResultado;
	}

	public List<PackageHistory> getObjeto() {
		return objeto;
	}

	public void setObjeto(List<PackageHistory> objeto) {
		this.objeto = objeto;
	}

	@Override
	public String toString() {
		return "Historico [versao=" + versao + ", qtd=" + qtd
				+ ", tipoPesquisa=" + tipoPesquisa + ", tipoResultado="
				+ tipoResultado + ", objeto=" + objeto + "]";
	}
	
}
