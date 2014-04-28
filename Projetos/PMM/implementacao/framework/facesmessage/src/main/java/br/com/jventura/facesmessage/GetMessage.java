package br.com.jventura.facesmessage;

import java.text.MessageFormat;

/**
 * @author henrique
 * 
 *         Classe responsavel em recuperar mensagens do arquivo properties e
 *         parametrizalas ou não.
 */
class GetMessage {

	/**
	 * 
	 * @param message
	 *            - Nome da chave da mensagem (<b>nome</b>=Semavize é {0})
	 * @param params
	 *            - Paramentros da mensagem (nome=Semavize é <b>{0}</b>)
	 * @return Retorna uma string que é a mensagem recuperada no arquivo
	 *         properties e com os parametros devidamento substituidos.
	 */
	synchronized static String findMensagem(String message, Object... params) {

		return MessageFormat.format(ResourceBlunde.getBungle().getString(message),
				params);
	}

}
