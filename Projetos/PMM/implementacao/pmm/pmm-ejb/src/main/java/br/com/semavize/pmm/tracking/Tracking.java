package br.com.semavize.pmm.tracking;

import java.io.InputStream;
import java.util.HashMap;

import javax.persistence.EntityManager;

import br.com.semavize.pmm.mailpackage.model.Package;
import br.com.semavize.pmm.tracking.model.MailPackage;
import br.com.semavize.pmm.tracking.model.PackageStatus;


/**
 * 
 * @author Sergio Augusto
 *
 * Entidade interface, que e responsavel por fazer a solicitacao do WEBService
 */
public interface Tracking {
	

	/**
	 * 
	 * @param pkg
	 */
	void trackingSearch(Package pkg);
	
	/**
	 * 
	 * @param pkg
	 */
	void trackingSearch(HashMap<String,Package> pkg);

	/**
	 * Calcula o tempo de entreda de casa pacote
	 * 
	 * @param pkgStatus
	 */
	void calculatingDayDelivery(Package pkg);
	
	/**
	 * 
	 * @param fileInput - Arquivo que contém informações de varios pacotes.
	 * A estrutura do arquivo é :
	 * 
	 * @return HashMap<K,V> - K - Numero do pacote , V - Objeto Pacote
	 */
	public HashMap<String, Package> fileUploadTrackingNumbers(InputStream fileInput);
	
	/**
	 * Realiza o processamento Asynchronous, esse processo pode demorar de acordo com
	 * a quantidade de pacotes a ser pesquisado.
	 * 
	 * @param pkgs - HashMap<K,V> - K - Numero do pacote , V - Objeto Pacote
	 */
	//public void processAsynSearchPackages(HashMap<String, Package> pkgs);
	
	EntityManager getEm();
	
	void setEm(EntityManager em);
}
