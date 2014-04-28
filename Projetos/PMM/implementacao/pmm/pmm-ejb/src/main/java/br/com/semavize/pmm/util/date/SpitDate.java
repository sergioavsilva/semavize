package br.com.semavize.pmm.util.date;

import org.joda.time.LocalDateTime;

/**
 * 
 * @author henrique
 *
 */
public class SpitDate {

	public SpitDate() {
	}
	
	/**
	 * 
	 * @param dateDDMMAAAA
	 * @return
	 */
	public LocalDateTime splitDateDDMMAAA(String dateDDMMAAAA){
		
		if(dateDDMMAAAA == null){
			throw new NullPointerException("A data não pode ser vazia.");
		}
		
		String[] date = dateDDMMAAAA.split("/");
		
		if(dateDDMMAAAA.length() == 3){
			throw new NumberFormatException("A data não está no formato esperado : dd/mm/aaaa");
		}
	
		int year = Integer.parseInt(date[2]);
		int monthOfyear = Integer.parseInt(date[1]);
		int dayOfMonth = Integer.parseInt(date[0]);
				
		return new LocalDateTime(year,monthOfyear,dayOfMonth,0,0);
	}
}
