package br.com.jventura.security.login.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jventura.administrator.security.entity.AuthUserSpring;
import br.com.jventura.administrator.security.entity.Role;
import br.com.jventura.administrator.security.entity.User;

@Service("hibernateUserDetailsService")
public class UserLoginDetailService extends HibernateDaoSupport implements
		UserDetailsService {

	public UserLoginDetailService() {

	}

	@Autowired(required = true)
	public UserLoginDetailService(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public UserDetails loadUserByUsername(String username) {

		SessionFactory s = getSessionFactory();

		s.getCurrentSession().beginTransaction();

		List<User> resultado = s.getCurrentSession()
				.getNamedQuery(User.USER_BY_NAME)
				.setString("name", username)
				.list();

		s.getCurrentSession().close();
		
		if (resultado != null && resultado.size() == 0) {
			throw new UsernameNotFoundException("Usuário não encontrado..");
		}

		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();

		for (Role role : resultado.get(0).getRoles()) {
			result.add(new SimpleGrantedAuthority(role.getPermission()));
		}

		AuthUserSpring au = new AuthUserSpring(resultado.get(0), result);

		return au;

	}

}
