package br.com.semavize.pmm.tracking.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

import br.com.semavize.pmm.tracking.ScheduleTracking;
import br.com.semavize.pmm.tracking.model.Schedule;
import br.com.semavize.pmm.tracking.model.Task;

@Stateless
public class ScheduleTrackingBean implements ScheduleTracking {

	@Resource
	private TimerService timerService;

	@Override
	public void schedule(Task task) {

		ScheduleExpression expression = new ScheduleExpression()
		        .hour(task.getHour())
				.minute(task.getMinute());

		TimerConfig timerConfig = new TimerConfig();
		
		//TODO Adicionar o objeto Task
		timerConfig.setInfo("Teste");
		
		//TODO mudar para true
		timerConfig.setPersistent(false);

		this.timerService.createCalendarTimer(expression, timerConfig);
	}

	@Override
	@Timeout
	public void executeTask(Timer timer) {
		System.out.println("Timer " + timer.getInfo());
	}

	@Override
	public List<Task> getAllTasks() {
		final List<Task> schedules = new ArrayList<Task>();	
		//Recupera cada Timer	
		for (Timer timer : this.timerService.getTimers()) {
			//Recupera as informações relacionadas ao tempo.
			ScheduleExpression sc = timer.getSchedule();
		
			schedules.add(new Task((String) timer.getInfo(),sc.getHour(),sc.getMinute())); 
		}
		return schedules;
	}

	@Override
	public void cancelTask() {

	}
	
	private void createTask(){
		//Criar um objeto chamado Task
		//Persiste esse objeto
		//Retorna um id para criar o Timer
		
	}

}
