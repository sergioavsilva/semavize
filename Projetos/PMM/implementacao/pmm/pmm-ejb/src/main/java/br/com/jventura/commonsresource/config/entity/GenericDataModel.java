package br.com.jventura.commonsresource.config.entity;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public class GenericDataModel<T extends BaseEntity<?>> extends ListDataModel<T> implements SelectableDataModel<T> , Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = 7843968143232423752L;


	public GenericDataModel(List<T> data) {
        super(data);
    }
    
    @Override
    public T getRowData(String rowKey) {
        
        @SuppressWarnings("unchecked")
		List<T> cars = (List<T>) getWrappedData();
        
        for(T car : cars) {
            if(car.getIndexTable().equals(rowKey))
                return car;
        }        
        return null;
    }
   
	@Override
	public Object getRowKey(T arg0) {
	
		return arg0.getIndexTable();
	} 

}
