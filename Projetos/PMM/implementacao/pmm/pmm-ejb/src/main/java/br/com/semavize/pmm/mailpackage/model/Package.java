package br.com.semavize.pmm.mailpackage.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import br.com.jventura.commonsresource.config.entity.BaseEntity;
import br.com.semavize.pmm.mail.model.Evento;

/**
 * @author henrique
 *
 */
@Entity
@Table(name="PACKAGE")
public class Package extends BaseEntity<Package>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PACKAGE")
	@SequenceGenerator(name = "SEQ_PACKAGE", sequenceName = "SEQ_PACKAGE",allocationSize=1)
	private Long id;
	
	/** DT_POSTAGEM */
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime dtPostagem;
	
	/** CEP_DE_ORIGEM */
	private String cepDeOrigem;
	
	/** CEP_DE_DESTINO */
	private String cepDestino;
	
	/** TP_SERVICO */
	private String tpPostagem;
	
	/** NRO_REGISTRO */
	private String nrPostagem;
	
	/** PESO_POSTAGEM */
	private String pesoPostagem;

	/** POSTAGEM_FATUARDA_POR */
	private String postagemFaturadaPor;
	
	/** NOME_DESTINATARIO */
	private String nomeDestinatario;
	
	/** CODSERV */
	private String codServico;
	
	/** Representa a data que deve ser entregue o pacote */
	private Integer diaDeEntrega;
	
	/** Representa o tempo que o pacote esta  em movimento. */
	private int tempoMovimento;
	
	/** Entrega em casa */
	private Boolean entregaCasa;
	
	/** Entrega de sabada */
	private Boolean entregaSabado;
	
	/** Prazo de entrega */
	private Integer prazoEntrega;
	
	private String situacao = "NAO ENTREGE";
	
	/** Hitoricos do pacote */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="package_")
	private List<Evento> evento = new ArrayList<Evento>();
	
	public Package() {
	}

	/**
	 * 
	 * @param dtPostagem
	 * @param cepDeOrigem
	 * @param tpPostagem
	 * @param nrPostagem
	 * @param pesoPostagem
	 * @param adicionaisNaPostagem
	 * @param vlrDeclarado
	 * @param vlrPostagem
	 * @param postagemFaturadaPor
	 * @param nomeDestinatario
	 */
	public Package(LocalDateTime dtPostagem,
			String codServico,
			String nrPostagem,
			String pesoPostagem,
			String cepDeOrigem,
			String cepDestino,
		    String nomeDestinatario) {
		super();
		
		this.dtPostagem = dtPostagem;
		this.codServico = codServico;
		this.nrPostagem = nrPostagem;
		this.pesoPostagem = pesoPostagem;
		this.cepDeOrigem = cepDeOrigem;
		this.cepDestino = cepDestino;
		this.nomeDestinatario = nomeDestinatario;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDtPostagem() {
		return dtPostagem;
	}

	public void setDtPostagem(LocalDateTime dtPostagem) {
		this.dtPostagem = dtPostagem;
	}

	public String getCepDeOrigem() {
		return cepDeOrigem;
	}

	public void setCepDeOrigem(String cepDeOrigem) {
		this.cepDeOrigem = cepDeOrigem;
	}

	public String getTpPostagem() {
		return tpPostagem;
	}

	public void setTpPostagem(String tpPostagem) {
		this.tpPostagem = tpPostagem;
	}

	public String getNrPostagem() {
		return nrPostagem;
	}

	public void setNrPostagem(String nrPostagem) {
		this.nrPostagem = nrPostagem;
	}

	public String getPesoPostagem() {
		return pesoPostagem;
	}

	public void setPesoPostagem(String pesoPostagem) {
		this.pesoPostagem = pesoPostagem;
	}

	public String getPostagemFaturadaPor() {
		return postagemFaturadaPor;
	}

	public void setPostagemFaturadaPor(String postagemFaturadaPor) {
		this.postagemFaturadaPor = postagemFaturadaPor;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public String getCodServico() {
		return codServico;
	}

	public void setCodServico(String codServico) {
		this.codServico = codServico;
	}	

	public List<Evento> getEvento() {
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}	
	
	public void addEventos(List<Evento> evento){
		
		for(Evento e : evento){
			e.setPackage_(this);
			String situacao = e.getTipo();
			
			if(situacao.equals("BDE")
					||situacao.equals("BDI")
						||situacao.equals("BDR")){
			 this.situacao = "ENTREGE";	
			}
			/**
			 * Para isso, indicamos que todos os objetos que forem retornados com o
			 *	evento tipo BDE, BDI e BDR com status 01 estão com o rastro concluído.	
			 *	Não será mais necessário enviá-los para novas consultas.
			 *
			 *  Adicionar um campo no objeto package que represente essa informação, 
			 *  para que não seja preciso consultar os eventos para saber o status.
			 */
			this.evento.add(e);
		}
	}
	
	public Integer getDiaDeEntrega() {
		return diaDeEntrega;
	}

	public void setDiaDeEntrega(Integer diaDeEntrega) {
		this.diaDeEntrega = diaDeEntrega;
	}

	public int getTempoMovimento() {
		return tempoMovimento;
	}

	public void setTempoMovimento(int tempoMovimento) {
		this.tempoMovimento = tempoMovimento;
	}

	public Boolean getEntregaCasa() {
		return entregaCasa;
	}

	public void setEntregaCasa(Boolean entregaCasa) {
		this.entregaCasa = entregaCasa;
	}

	public Boolean getEntregaSabado() {
		return entregaSabado;
	}

	public void setEntregaSabado(Boolean entregaSabado) {
		this.entregaSabado = entregaSabado;
	}

	public Integer getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(Integer prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nrPostagem == null) ? 0 : nrPostagem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Package other = (Package) obj;
		if (nrPostagem == null) {
			if (other.nrPostagem != null)
				return false;
		} else if (!nrPostagem.equals(other.nrPostagem))
			return false;
		return true;
	}

	@Override
	public int compareTo(Package arg0) {
		return this.nrPostagem.compareTo(arg0.getNrPostagem());
	}	
}
