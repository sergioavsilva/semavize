package br.com.jventura.administrator.security.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role implements Serializable{
	
	private static final long serialVersionUID = 2781992446833578758L;

	/**
	 * Id
	 */
	private Long id;
	
	/**
	 * Permission - Permissão do usuário
	 */
	private String permission;
	

	private User user;
	/**
	 * Role() - Construtor default
	 */
	public Role() {
	}
	
	public Role(String permission) {
		this.permission = permission;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ROLE")
	@SequenceGenerator(name = "SEQ_ROLE", sequenceName = "SEQ_ROLE")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
