package br.com.jventura.facesmessage;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * @author henrique
 * 
 *         Classe responsavel por carregar o arquivo properties que contém
 *         mensagens do sistema para memoria.
 */
class ResourceBlunde {

	private static ResourceBundle bundle = null;

	static {

		bundle = ResourceBundle.getBundle("mensagens", new Locale("pt", "BR"));
	}

	static ResourceBundle getBungle() {

		return bundle;
	}

}