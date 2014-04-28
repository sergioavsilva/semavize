package br.com.jventura.administrator.security.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.jventura.facesmessage.ViewMessage;

@WebServlet(name = "ServletRedirecLogin", urlPatterns = "/redirectLogin")
public class ServletRedirecLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(ServletRedirecLogin.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/**
		FacesContextBuilder fcb = new FacesContextBuilder();
		FacesContext fc = fcb.getFacesContext(req, resp);
		
		NavigationHandler nav = fc.getApplication().getNavigationHandler();

		Authentication currentUser = SecurityContextHolder.getContext()
				.getAuthentication();
		
		if (currentUser.getName() == null || currentUser.getName().equals("")
				|| currentUser.getName().equals("anonymousUser")) {

			System.out.println("[LOGIN] - Redirecionando para pagina de login");
			nav.handleNavigation(fc, null, "pretty:loging");
			fc.renderResponse();
		}

		if (currentUser.getName().equals("adm")) {
			
			ViewMessage.setFacesContext(fc);
			ViewMessage.addError("view.component.message.error");
			
			Map sessionMap = fc.getExternalContext().getSessionMap();
						
			Set<FacesMessage> messages = new HashSet<FacesMessage>();
					messages.addAll(fc.getMessageList());
			sessionMap.put("MULTI_PAGE_MESSAGES_SUPPORT",messages);
			
			
			LOG.info("ServletRedirecLogin [ADMINISTRATOR]");
			
			nav.handleNavigation(fc, null, "pretty:adm");
			fc.renderResponse();
			
		} else {
	
			LOG.info("ServletRedirecLogin [APLICATION]");
			
			nav.handleNavigation(fc, null, "pretty:application");
			fc.renderResponse();
		}
*/
	}

}
