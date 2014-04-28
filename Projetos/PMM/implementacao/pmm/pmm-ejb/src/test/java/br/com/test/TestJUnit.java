package br.com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.junit.Test;

import br.com.semavize.pmm.mailpackage.model.Package;
import br.com.semavize.pmm.tracking.Tracking;
import br.com.semavize.pmm.tracking.impl.TrackingImpl;

public class TestJUnit {

	@Test
	public void test(){

		
		HashMap<String, Package> pkg = getPackages();	
	}
	
	private HashMap<String, Package> getPackages() {

		File input = new File(
				"/home/henrique/Downloads/CORRECAO_POSTAG_PARA_RECOVER_V.CSV");

		Tracking trk = new TrackingImpl();
		HashMap<String, Package> pks = null;
	
		try {

			pks = trk.fileUploadTrackingNumbers(new FileInputStream(input));
			
			System.out.println(pks.size());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return pks;
	}
}
