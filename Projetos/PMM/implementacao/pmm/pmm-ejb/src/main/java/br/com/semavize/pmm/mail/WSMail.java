package br.com.semavize.pmm.mail;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.semavize.pmm.mail.model.DeadlinePackage;
import br.com.semavize.pmm.mail.model.PackageHistory;
import br.com.semavize.pmm.tracking.model.SendType;

/**
 * 
 * @author S�rgio Augusto
 *
 */

public interface WSMail {
	
	/**
	 * Busca o historico do pacote.
	 * 
	 * @param trackingNumbers - numero do pacote, para buscar mais de uma pacote busca
	 * colocar os numeros todos juntos sem espaço :PB536057990BRPB536058195BR
	 * 
	 * @return List<PackageHistory>
	 */
	List<PackageHistory> getTrackingHistory(String trackingNumbers) throws IOException, JAXBException ;
	
	/**
	 * 
	 * @param cepFrom
	 * @param cepTo
	 * @param sendCode
	 * @return DeadlinePackage
	 */
	DeadlinePackage getBeenDelivered(String nCdServico,String sCepOrigem,String sCepDestino);
}
