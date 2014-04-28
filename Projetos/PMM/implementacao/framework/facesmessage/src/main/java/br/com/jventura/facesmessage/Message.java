package br.com.jventura.facesmessage;

import javax.faces.application.FacesMessage.Severity;

public abstract class Message {

	protected abstract void message(Severity severity, String component,
			String mensagem, Object... params);
}
