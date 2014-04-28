package br.com.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.semavize.pmm.mail.WSMail;
import br.com.semavize.pmm.mail.impl.WSMailImpl;
import br.com.semavize.pmm.mail.model.DeadlinePackage;
import br.com.semavize.pmm.mail.model.PackageHistory;

public class Test {
	
	public static void main(String[] a) throws IOException, JAXBException{

		WSMail wsimpl = new WSMailImpl();
		
		/**
		List<PackageHistory> pkgHists = wsimpl.getTrackingHistory("PB536058425BR");
		
		System.out.println(pkgHists.size());
		
		String numeros = "PB536058425BRSX689968063BRSX689968077BRSX689968103BRSX689968125BRSW274561927BR";
		
		//Descobre quantos pacotes tem.
		int quantidadePacotes = numeros.length();
		System.out.println(numeros.length());

		System.out.println(numeros.substring(0,13));
		System.out.println(numeros.substring(13,26));
		System.out.println(numeros.length());
		 */
		
		DeadlinePackage dlpkg = wsimpl.getBeenDelivered("41106","01156040","14804061");
		
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		String meuNiver = "16/10/2012";
		 
		try {
			Date data = sd.parse(null);
			
			System.out.println(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
