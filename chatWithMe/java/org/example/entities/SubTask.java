package org.example.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "SUBTASK")
public class SubTask extends AbstractEntityCustom {

	
	private static final long serialVersionUID = -7520908348510173546L;
	
	private SubTask previousTask;
	private SubTask nextTask;
	private Date maximumProcessDate;
	private Task parentTask;
	private TaskType taskType; 
	private MainProcess mainProcess;
	
	

	@OneToOne(fetch = FetchType.LAZY)
	public SubTask getPreviousTask() {
		return previousTask;
	}
	public void setPreviousTask(SubTask previousTask) {
		this.previousTask = previousTask;
	}
	
	

	@OneToOne(fetch = FetchType.LAZY)
	public SubTask getNextTask() {
		return nextTask;
	}
	public void setNextTask(SubTask nextTask) {
		this.nextTask = nextTask;
	}
	
	

	public Date getMaximumProcessDate() {
		return maximumProcessDate;
	}
	public void setMaximumProcessDate(Date maximumProcessDate) {
		this.maximumProcessDate = maximumProcessDate;
	}
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	public Task getParentTask() {
		return parentTask;
	}
	public void setParentTask(Task parentTask) {
		this.parentTask = parentTask;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	public TaskType getTaskType() {
		return taskType;
	}
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	public MainProcess getMainProcess() {
		return mainProcess;
	}
	public void setMainProcess(MainProcess mainProcess) {
		this.mainProcess = mainProcess;
	}
}