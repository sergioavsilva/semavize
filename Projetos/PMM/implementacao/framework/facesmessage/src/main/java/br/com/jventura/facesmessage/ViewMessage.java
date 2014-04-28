package br.com.jventura.facesmessage;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * @author henrique
 * 
 *         Classe responsavel por recuperar a mensagem e adicionar no contexto
 *         da aplicação para que seja apresentada na pagina .xhtml.
 */
public class ViewMessage {

	/**
	 * Em alguns pontos da aplicação não é possivel obter FacesContext e inserir
	 * uma mensagem no FacesMessage, então essa variavel recebe um instancia do
	 * FacesContext.
	 */
	private static FacesContext facesContext;

	/*
	 * <b>form-principal</b> - é o id do form que se encontra da pagina
	 * default.xhtml. <br> <b>messageGlobal</b> - é o id do component do
	 * "richfaces" que apresenta as mensagens informativas para o usuario na
	 * pagina default.xhtml.
	 * 
	 * private static final String ID_FORM_AND_COMPONENT =
	 * "form-principal:messageGlobal";
	 * <h:message id="messageGlobal" for="messageGlobal" />
	 */

	/*
	 * O botão escolhido é do primefaces, apenas o p:message que funciona, e
	 * para que a as mensagens de informação apareça no topo da pagina foi
	 * preciso habilitar a opção globalOnly="true" (apresenta apenas as
	 * mensagens cujo componente não tenha um id) então o ID_FORM_AND_COMPONENT
	 * não tem um conforme descrito acima.
	 */
	private static final String ID_FORM_AND_COMPONENT = "messageGlobal";

	/**
	 * 
	 * @param severity
	 * @param mensagem
	 *            - Nome da chave da mensagem (<b>nome</b>=Semavize é {0})
	 */
	public static void addMessage(String mensagem) {

		ViewMessage.message(FacesMessage.SEVERITY_INFO, ID_FORM_AND_COMPONENT,
				mensagem, new Object());

	}

	/**
	 * @param mensagem
	 *            - Nome da chave da mensagem (<b>nome</b>=Semavize é {0}).
	 * @param params
	 *            - Parametros que componhe a mensagem (nome=Semavize é
	 *            <b>{0}</b>).
	 */
	public static void addMessage(String mensagem, Object... params) {

		ViewMessage.message(FacesMessage.SEVERITY_INFO, ID_FORM_AND_COMPONENT,
				mensagem, params);
	}

	/**
	 * @param component
	 *            - Id do component.
	 * @param mensagem
	 *            - Nome da chave da mensagem (<b>nome</b>=Semavize é {0}).
	 * @param params
	 *            - Parametros que componhe a mensagem (nome=Semavize é
	 *            <b>{0}</b>).
	 */
	public static void addMessageWithComponent(String component, String mensagem,
			Object... params) {

		ViewMessage.message(FacesMessage.SEVERITY_INFO, component, mensagem,
				params);
	}

	/**
	 * 
	 * @param mensagem
	 *            - Nome da chave da mensagem (<b>nome</b>=Semavize é {0}).
	 */
	public static void addError(String mensagem) {

		ViewMessage.message(FacesMessage.SEVERITY_ERROR, ID_FORM_AND_COMPONENT,
				mensagem, new Object());
	}

	/**
	 * 
	 * @param mensagem
	 *            - Nome da chave da mensagem (<b>nome</b>=Semavize é {0}).
	 * @param params
	 *            - Parametros que componhe a mensagem (nome=Semavize é
	 *            <b>{0}</b>).
	 */
	public static void addError(String mensagem, Object... params) {

		ViewMessage.message(FacesMessage.SEVERITY_ERROR, ID_FORM_AND_COMPONENT,
				mensagem, params);
	}

	/**
	 * 
	 * @param component
	 *            - Id do component.
	 * @param mensagem
	 *            - Nome da chave da mensagem (<b>nome</b>=Semavize é {0}).
	 * @param params<h:messages id="messageGlobal" globalOnly="true" />
	 *            - Parametros que componhe a mensagem (nome=Semavize é
	 *            <b>{0}</b>).
	 */
	public static void addErrorWithComponent(String component, String mensagem,
			Object... params) {

		ViewMessage.message(FacesMessage.SEVERITY_ERROR, component, mensagem,
				params);
	}

	private static void message(Severity severity, String component,
			String mensagem, Object... params) {

		FacesContext facesContextInner = FacesContext.getCurrentInstance();

		if (facesContextInner == null) {
			facesContextInner = getFacesContext();
		}
		
		facesContextInner.addMessage(component, new FacesMessage(severity,GetMessage.findMensagem(mensagem, params), null));
	}

	private static FacesContext getFacesContext() {
		return facesContext;
	}

	public static void setFacesContext(FacesContext facesContext) {
		ViewMessage.facesContext = facesContext;
	}

}
