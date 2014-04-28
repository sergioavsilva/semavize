package br.com.semavize.pmm.mail.impl;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.semavize.pmm.mail.WSMail;
import br.com.semavize.pmm.mail.model.DeadlinePackage;
import br.com.semavize.pmm.mail.model.Historico;
import br.com.semavize.pmm.mail.model.PackageHistory;
import br.com.semavize.pmm.precoPrazoSOAP.ArrayOfCServico;
import br.com.semavize.pmm.precoPrazoSOAP.CResultado;
import br.com.semavize.pmm.precoPrazoSOAP.CServico;
import br.com.semavize.pmm.precoPrazoSOAP.CalcPrecoPrazoWS;
import br.com.semavize.pmm.precoPrazoSOAP.CalcPrecoPrazoWSSoap;

public class WSMailImpl implements WSMail {
	
	/**
	 * URL do WebService do Correio
	 */
	private static final String WS_CORREIO = "http://websro.correios.com.br/sro_bin/sroii_xml.eventos";
	
	/**
	 * Instância do WebService
	 */


	@Override
	public List<PackageHistory> getTrackingHistory(String trackingNumbers)
			throws IOException, JAXBException {
		
		//Consulta
		Historico hist = getHistorico(trackingNumbers);
		
		//Retorna apenas o Historico do objeto
		return hist.getObjeto();
	}

	@Override
	public DeadlinePackage getBeenDelivered(String nCdServico,
			String sCepOrigem, String sCepDestino) {

		DeadlinePackage dlpkg = new DeadlinePackage();
		
		CalcPrecoPrazoWSSoap calcPrecoPrazoWS = new CalcPrecoPrazoWS().getCalcPrecoPrazoWSSoap();
		//Executa a consulta
		CResultado cresultado = calcPrecoPrazoWS.calcPrazo(nCdServico, sCepOrigem, sCepDestino);

		ArrayOfCServico arrayOfSerico = cresultado.getServicos();
		
		String not = "N";
				
		//Prazo de entrega
		String prazoEntega = arrayOfSerico.getCServico().get(0).getPrazoEntrega();
			dlpkg.setDeadlineDelivere(Integer.valueOf(prazoEntega));
		
		//Entrega de sabado	
		String delivereHome = arrayOfSerico.getCServico().get(0).getEntregaSabado();
			dlpkg.setDeliveredSaturday((delivereHome.equals(not) ? new Boolean("false") : new Boolean("true")));
			
		//Entrega de sabado	
		String delivereSaturday = arrayOfSerico.getCServico().get(0).getEntregaSabado();
			dlpkg.setDeliveredSaturday((delivereSaturday.equals(not) ? new Boolean("false") : new Boolean("true")));
			

		return dlpkg;
	}

	/**
	 * Recupera as informações de status (Saiu, Encaminhado..etc ) do pacote.
	 * 
	 * @param trackingNumber
	 * @return
	 * @throws IOException
	 * @throws JAXBException
	 */
	public Historico getHistorico(String trackingNumber) throws IOException,
			JAXBException {

		URLConnection connection = new URL(WS_CORREIO).openConnection();
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		connection.setAllowUserInteraction(false);

		
		PrintStream outStream = new PrintStream(connection.getOutputStream());
		outStream.println("usuario=ECT&senha=SRO&tipo=L&resultado=T&objetos="+trackingNumber);
		outStream.close();

		DataInputStream inStream = new DataInputStream(connection.getInputStream());

		JAXBContext context = JAXBContext.newInstance(Historico.class);
		Unmarshaller um = context.createUnmarshaller();
		Historico historico = (Historico) um.unmarshal(inStream);

		return historico;

	}
}
