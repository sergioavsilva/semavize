package br.com.semavize.pmm.tracking;

import java.util.List;

import javax.ejb.Timer;

import br.com.semavize.pmm.tracking.model.Schedule;
import br.com.semavize.pmm.tracking.model.Task;

public interface ScheduleTracking {

	/**
	 * 
	 * @param hour
	 */
	void schedule(Task task);
	
	/**
	 * 
	 * @param timer
	 */
	void executeTask(Timer timer);
	
	/**
	 * 
	 */
	void cancelTask();
	
	/**
	 * 
	 * @return
	 */
	List<Task> getAllTasks();
}
