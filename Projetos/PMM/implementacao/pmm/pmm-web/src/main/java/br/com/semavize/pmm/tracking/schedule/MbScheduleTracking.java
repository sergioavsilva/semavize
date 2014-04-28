package br.com.semavize.pmm.tracking.schedule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jventura.commonsresource.controller.BaseController;
import br.com.semavize.pmm.tracking.ScheduleTracking;
import br.com.semavize.pmm.tracking.model.Task;

@ViewScoped
@Named(value="mbScheduleTracking")
public class MbScheduleTracking extends BaseController<Task> implements Serializable{
	
	private static final long serialVersionUID = 8620317563800371286L;
	
	private Task task;
	
	@Inject
	private ScheduleTracking scheduleTracking;
	
	private List<Task> schedules = new ArrayList<Task>();
	
	public MbScheduleTracking() {}
	
	@PostConstruct
	public void init(){
		task = new Task();
	}
	
	/**
	 * Busca todas as tarefas que foram criadas.
	 */
	private void filter(){
		schedules = scheduleTracking.getAllTasks();
	}
	
	/**
	 * Cria uma nova tarefa.
	 */
	private void create(){
		scheduleTracking.schedule(task);
		
		//Atualiza a grid com a nova tarefa
		filter();
	}
	
	/**
	 * Remove uma tarefa
	 */
	private void remove(){
		scheduleTracking.cancelTask();
	}
	
	@Override
	public void execute() {
		switch (getOperacao()) {
		case 1:
			filter();
			break;
		case 2:
			create();
			break;
		case 3:
			remove();
			break;
		default:
			break;
		}
	}
	
	@Override
	public void refrehInputs() {
		task = getSelected();
	}

	@Override
	public void refrehInputsMandatory() {
		if (getOperacao() == 1) {
			setMandatory(false);
		} else {
			setMandatory(true);
		}
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public List<Task> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Task> schedules) {
		this.schedules = schedules;
	}	
}
