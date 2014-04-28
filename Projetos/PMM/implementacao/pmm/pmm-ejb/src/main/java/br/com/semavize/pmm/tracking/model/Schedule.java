package br.com.semavize.pmm.tracking.model;

import br.com.jventura.commonsresource.config.entity.BaseEntity;

public class Schedule extends BaseEntity<Schedule> implements Comparable<Schedule>{
	
	/**
	 * Nome da tarefa
	 */
	private String name;
	
	/**
	 * Tempo progrado para execução
	 */
	private String scheduleExpression;
	
	private String hour;
	private String minute;
	
	
	public Schedule() {	}
	
		
	public Schedule(String name, String scheduleExpression) {
		super();
		this.name = name;
		this.scheduleExpression = scheduleExpression;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScheduleExpression() {
		return scheduleExpression;
	}

	public void setScheduleExpression(String scheduleExpression) {
		this.scheduleExpression = scheduleExpression;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Schedule other = (Schedule) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Schedule o) {
		return this.name.compareTo(o.getName());
	}
	
}
