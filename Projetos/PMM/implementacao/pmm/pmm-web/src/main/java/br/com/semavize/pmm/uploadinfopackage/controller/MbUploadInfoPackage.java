package br.com.semavize.pmm.uploadinfopackage.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultUploadedFile;
import org.primefaces.model.UploadedFile;

import br.com.jventura.commonsresource.controller.BaseController;
import br.com.jventura.facesmessage.ViewMessage;
import br.com.semavize.pmm.mailpackage.model.Package;
import br.com.semavize.pmm.tracking.Tracking;
import br.com.semavize.pmm.tracking.impl.TrackingImpl;

@ViewScoped
@Named(value = "mbUploadinfopackage")
public class MbUploadInfoPackage extends BaseController<Package> implements
		Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Package> listPackage = new ArrayList<Package>();
	
	/** Arquivo de upload **/
	private UploadedFile file;
	
	/** Quantidade de registro do arquivo do Upload" **/
	private Integer quantidadeRegistros;
	
	@Inject
	private Logger log;
	
	@Inject
	Tracking track;
	
	public MbUploadInfoPackage() {
	}

	@PostConstruct
	public void init() {
		System.out.println("ManagerBean inicializado com sucesso.");
	}

	public String teste() {
		ViewMessage.addMessage("msg.uploadinfopackage.process_file");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * Evento do componente de upload
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void handleFileUpload() {
	
		HashMap<String, Package> pkgs;
		
		listPackage.clear();
		
		try {
			
			pkgs = track.fileUploadTrackingNumbers(file.getInputstream());
			
			track.trackingSearch(pkgs);
			
			Set<Map.Entry<String, Package>> lpck = pkgs.entrySet();
			
			for (Map.Entry<String, Package> me : lpck) {
				listPackage.add(me.getValue());
			}
			
			quantidadeRegistros = listPackage.size();
			
			file = new DefaultUploadedFile();
			
		} catch (IOException e) {
			log.info(e.getMessage());
		}	
	}

	public List<Package> getListPackage() {
		return listPackage;
	}

	public void setListPackage(List<Package> listPackage) {
		this.listPackage = listPackage;
	}

	@Override
	public void execute() {
	
	}

	@Override
	public void refrehInputs() {

	}

	@Override
	public void refrehInputsMandatory() {

	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public Integer getQuantidadeRegistros() {
		return quantidadeRegistros;
	}

	public void setQuantidadeRegistros(Integer quantidadeRegistros) {
		this.quantidadeRegistros = quantidadeRegistros;
	}
	
}
