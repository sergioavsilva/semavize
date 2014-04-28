package br.com.semavize.pmm.mail.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import br.com.semavize.pmm.mailpackage.model.Package;
import br.com.semavize.pmm.util.date.SpitDate;

/**
 * Entidade que representa os eventos de um pacote.
 * 
 * @author jventura
 *
 */
@XmlRootElement(name = "evento")
@Entity
@Table
public class Evento implements Serializable{

	private static final long serialVersionUID = 5020886268089624757L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_EVENTO")
	@SequenceGenerator(name = "SEQ_EVENTO", sequenceName = "SEQ_EVENTO",allocationSize=1)
	private Long id;
	
	private String tipo;
	
	private int status;
	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@Column(name="data")
	private LocalDateTime data_;
	
	@Transient
	private String data;
	
	private String hora;
	
	private String descricao;
	
	private String recebedor;
	
	private String local;
	
	private String codigo;
	
	private String cidade;
	
	private String uf;
	
	private String sto;
	
	@ManyToOne
	@JoinColumn(name="PACKAGE_ID", nullable=false)
	private br.com.semavize.pmm.mailpackage.model.Package package_;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getData_() {
		return data_;
	}

	public void setData_(LocalDateTime data_) {
		this.data_ = data_;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data_ = new SpitDate().splitDateDDMMAAA(data);
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRecebedor() {
		return recebedor;
	}

	public void setRecebedor(String recebedor) {
		this.recebedor = recebedor;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getSto() {
		return sto;
	}

	public void setSto(String sto) {
		this.sto = sto;
	}
	
	public Package getPackage_() {
		return package_;
	}

	public void setPackage_(Package package_) {
		this.package_ = package_;
	}
}
