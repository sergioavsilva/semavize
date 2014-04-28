package br.com.jventura.administrator.security.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USERS",uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@NamedQueries({
	@NamedQuery(name=User.USER_BY_NAME,query="select u from User u where u.name = :name")
 	})
public class User extends BaseEntity<User> implements Serializable{

	private static final long serialVersionUID = 7408361602340725649L;
	/**
	 * @NamedQuery - from User u where u.name = :name
	 */
	public static final String USER_BY_NAME = "USER_AND_ROLES";
	/**
	 * Id
	 */
	private Long id;

	/**
	 * Name - Nome do usuário
	 */
	private String name;

	/**
	 * Password - Senha do usuário
	 */
	private String password;

	/**
	 * roles - Permissões do usuário
	 */
	private List<Role> roles;

	/**
	 * User() - Construtor default
	 */
	public User() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_USER")
	@SequenceGenerator(name = "SEQ_USER", sequenceName = "SEQ_USER")
	@Column(name="id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.ALL,CascadeType.PERSIST} ,mappedBy="user")
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role){
		if(role != null)
			role.setUser(this);
		
		if(this.roles == null)
			roles = new ArrayList<Role>();
			
		this.roles.add(role);
	}

	public int compareTo(User o) {
		return o.getName().compareTo(this.getName());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
