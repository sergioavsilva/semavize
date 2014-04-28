package br.com.jventura.commonsresource.config.entity;

/**
 * Classe abstrata que representa como base para qualquer entidade
 * que seja persistida. 
 */

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Transient;

public abstract class BaseEntity<T> implements Comparable<T>, Serializable{

	private static final long serialVersionUID = 5384357915115455104L;

	public BaseEntity() {
		setIndexTable(getRandomModel());
	}
	
	/**
	 * indexTable
	 */	
	private String indexTable;
	
	@Transient
	public String getIndexTable() {
		return indexTable;
	}

	public void setIndexTable(String indexTable) {
		this.indexTable = indexTable;
	}
	
	private String getRandomModel() {  
        return UUID.randomUUID().toString().substring(0, 8);  
    }  
	
	@Override
	public abstract boolean equals(Object object);
	
	@Override
	public abstract int hashCode();

}
