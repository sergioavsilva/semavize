package br.com.semavize.pmm.tracking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.jventura.commonsresource.config.entity.BaseEntity;

/**
 * Entidade responsavel por armazenar os dados de cada tarefa que
 * devera ser executa de acordo com o tempo programado.
 * 
 * Cada tarefa será armazena em banco e também em disco, o armazenamento
 * em disco é feito pela classe :
 * @see br.com.semavize.pmm.tracking.impl.ScheduleTrackingBean
 * <b>Método</b> schedule(Task taks), atráves do objeto TimerService
 * método setPersistnce(true).
 * 
 * @author henrique
 *
 */
@Entity
@Table(name="TASK")
public class Task extends BaseEntity<Task> implements Comparable<Task>{

	private static final long serialVersionUID = -7203346512208521294L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TASK")
	@SequenceGenerator(name = "SEQ_TASK", sequenceName = "SEQ_TASK")
	private Long id;
	
	private String name;
	
	private String hour;
	
	private String minute;
	
	public Task() {	}

	public Task(String name, String hour, String minute) {
		super();
		this.name = name;
		this.hour = hour;
		this.minute = minute;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Task o) {
		return this.id.compareTo(o.getId());
	}
	
}
