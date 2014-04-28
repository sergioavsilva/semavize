package br.com.semavize.pmm.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jventura.commonsresource.controller.BaseController;
import br.com.semavize.pmm.tracking.ScheduleTracking;
import br.com.semavize.pmm.tracking.Tracking;
import br.com.semavize.pmm.tracking.impl.TrackingImpl;
import br.com.semavize.pmm.tracking.model.MailPackage;
import br.com.semavize.pmm.tracking.model.PackageStatus;
import br.com.semavize.pmm.tracking.model.SendType;

@ViewScoped
@Named(value="mbPackageHistory")
public class MbPackageHistory extends BaseController<PackageStatus> implements Serializable {
	/** */
	private static final long serialVersionUID = 2648302776653403889L;
	
	private MailPackage mailPackage;
	
	private PackageStatus packageStatus;
	
	private List<PackageStatus> listPackageStatus = new ArrayList<PackageStatus>();
	
	/**
	 * Tipoe do SendType escolhido no combo
	 */
	private String sendType;
	
	/**
	 * Combo - Tipo de envio
	 */
	private List<SelectItem> sendTypeItens;
	
	@PostConstruct
	public void init(){
		mailPackage = new MailPackage();
		
		//Preenche o combo.
		comboSentype();
	}	
	
	public void findHistory(){
		
		Tracking tracking = new TrackingImpl();
		
		mailPackage.setSendType(SendType.valueOf(sendType));
		
	//	packageStatus =  tracking.searchTracking(mailPackage);

		listPackageStatus.add(packageStatus);	
	}
	
	public void comboSentype(){
		sendTypeItens = new ArrayList<SelectItem>();
		
		sendTypeItens.add(new SelectItem(SendType.PAC_CC.name(),"PAC_CC"));
		sendTypeItens.add(new SelectItem(SendType.PAC_SC.name(),"PAC_SC"));
		sendTypeItens.add(new SelectItem(SendType.SEDEX.name(),"SEDEX"));
		sendTypeItens.add(new SelectItem(SendType.SEDEX_10.name(),"SEDEX_10"));
		sendTypeItens.add(new SelectItem(SendType.SEDEX_ACCC.name(),"SEDEX_ACCC"));
		sendTypeItens.add(new SelectItem(SendType.SEDEX_ACSC.name(),"SEDEX_ACSC"));
		sendTypeItens.add(new SelectItem(SendType.SEDEX_CC1.name(),"SEDEX_CC1"));
		sendTypeItens.add(new SelectItem(SendType.SEDEX_CC2.name(),"SEDEX_CC2"));		
	}
	
	@Override
	public void execute() {
		findHistory();
	}

	@Override
	public void refrehInputs() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void refrehInputsMandatory() {
		// TODO Auto-generated method stub		
	}

	public MailPackage getMailPackage() {
		return mailPackage;
	}

	public void setMailPackage(MailPackage mailPackage) {
		this.mailPackage = mailPackage;
	}

	public PackageStatus getPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(PackageStatus packageStatus) {
		this.packageStatus = packageStatus;
	}

	public List<PackageStatus> getListPackageStatus() {
		return listPackageStatus;
	}

	public void setListPackageStatus(List<PackageStatus> listPackageStatus) {
		this.listPackageStatus = listPackageStatus;
	}

	public List<SelectItem> getSendTypeItens() {
		return sendTypeItens;
	}

	public void setSendTypeItens(List<SelectItem> sendTypeItens) {
		this.sendTypeItens = sendTypeItens;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	
	

}
