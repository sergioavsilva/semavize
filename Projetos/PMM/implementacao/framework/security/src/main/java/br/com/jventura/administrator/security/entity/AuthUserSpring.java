package br.com.jventura.administrator.security.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Entidade utilizada pelo SpringSecurity
 * 
 * @author henrique
 *
 */
public class AuthUserSpring implements UserDetails{

	private static final long serialVersionUID = -1431965451801370835L;

	private User user;
	
	private List<GrantedAuthority> authorities;
	
	public AuthUserSpring(User user,List<GrantedAuthority> authorities) {
		setAuthorities(authorities);
		setUser(user);
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(){
	
		return authorities;
	}


	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getName();
	}


	public boolean isAccountNonExpired() {
		return true;
	}


	public boolean isAccountNonLocked() {
		return true;
	}

	
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
