package br.com.semavize.pmm.tracking.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.JAXBException;

import org.joda.time.DateTime;

import br.com.semavize.pmm.mail.WSMail;
import br.com.semavize.pmm.mail.impl.WSMailImpl;
import br.com.semavize.pmm.mail.model.DeadlinePackage;
import br.com.semavize.pmm.mail.model.PackageHistory;
import br.com.semavize.pmm.mailpackage.model.Package;
import br.com.semavize.pmm.tracking.Tracking;
import br.com.semavize.pmm.tracking.model.PackageStatus;
import br.com.semavize.pmm.util.date.SpitDate;

@Stateless
public class TrackingImpl implements Tracking {

    @PersistenceContext(name="PMMDS")
    private EntityManager em;
	
	@Inject
	private Logger log;

	@Override
	public void trackingSearch(Package pkg) {
		List<Package> pkgs = new ArrayList<Package>();
		pkgs.add(pkg);

	}

	@Override
	public void trackingSearch(HashMap<String, Package> pkgs) {
		
		
		
		WSMail wsimpl = new WSMailImpl();
		List<PackageHistory> pkgHists = new ArrayList<PackageHistory>();
		PackageStatus pkgStatus = null;
		StringBuilder numbers = new StringBuilder();

		try {
			Set<Map.Entry<String, Package>> lpck = pkgs.entrySet();

			// O WebService do correio está limitando a busca de 5 pacotes por
			// vez,
			// então concatena 5 numeros e busca até acabar.
			int qtdNumeros = 0;
			for (Map.Entry<String, Package> me : lpck) {
				numbers.append(me.getKey());

				++qtdNumeros;
				if (qtdNumeros == 5) {
					pkgHists.addAll(wsimpl.getTrackingHistory(numbers
							.toString()));

					// Zera o contador e os numeros
					qtdNumeros = 0;
					numbers = new StringBuilder();
				}
			}

			// Para cada Historico
			for (PackageHistory pkgHist : pkgHists) {

				// Recupera o pacote correspondente
				Package pck = pkgs.get(pkgHist.getNumero());

				// Busca informações referente ao prazo de entrega
				DeadlinePackage dlpkg = wsimpl.getBeenDelivered(pck.getCodServico(), pck.getCepDeOrigem(),
						pck.getCepDestino());
							
			    pck.setPrazoEntrega(dlpkg.getDeadlineDelivere());
				pck.setEntregaSabado(dlpkg.getDeliveredSaturday());
				pck.setEntregaCasa(dlpkg.getDelivereHome());
				pck.addEventos(pkgHist.getEvento());
				
				// Calcula o tempo de entrega.
				this.calculatingDayDelivery(pck);
				
				em.persist(pck);
			}
			
		
			
		} catch (IOException e) {
			log.info(e.getMessage());
		} catch (JAXBException e) {
			log.info(e.getMessage());
		}
	}

	@Override
	public HashMap<String, Package> fileUploadTrackingNumbers(InputStream fileInput) {
		String line = null;
		Package pck = null;
		int contador = 0;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(fileInput));
		HashMap<String, Package> hsPackages = new HashMap<String, Package>();		

		try {
			
			while ((line = in.readLine()) != null) {
				// Pula a primeira linha do arquivo pois é o cabeçalho do
				// arquivo.
				if (contador == 0) {
					++contador;
					continue;
				}

				StringTokenizer stringTokenizer = new StringTokenizer(line, ";",false);
				
				while (stringTokenizer.hasMoreTokens() && stringTokenizer.countTokens()>1) {
					pck = new Package(new SpitDate().splitDateDDMMAAA(stringTokenizer.nextToken()),
							stringTokenizer.nextToken(),
							stringTokenizer.nextToken(),
							stringTokenizer.nextToken(),
							stringTokenizer.nextToken(),
							stringTokenizer.nextToken(),
							stringTokenizer.nextToken());
					break;
				}
				
				//A chave é o numero do arquivo e o valor o proprio pacote.
				hsPackages.put(pck.getNrPostagem(),pck);
			}

			in.close();
		} catch (IOException e) {
			log.info(e.getMessage());
		}
		
		return hsPackages;
	}

	@Override
	public void calculatingDayDelivery(Package pkg) {
		
	}

	public EntityManager getEm() {
		return em;
	}

	@Override
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
