package org.example.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "AssignedJob")
public class AsssignedJob extends AbstractEntityCustom {

	private static final long serialVersionUID = -2848158418736798728L;
	
	private MainProcess process;
	private Task currentTask;
	private Task currentSubTask;
	private Date lastprocessDate;
	private Boolean completed;
	
	
	public Task getCurrentTask() {
		return currentTask;
	}
	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}
	
	
	public Task getCurrentSubTask() {
		return currentSubTask;
	}
	public void setCurrentSubTask(Task currentSubTask) {
		this.currentSubTask = currentSubTask;
	}
	
	
	public Date getLastprocessDate() {
		return lastprocessDate;
	}
	public void setLastprocessDate(Date lastprocessDate) {
		this.lastprocessDate = lastprocessDate;
	}
	
	
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
	public MainProcess getProcess() {
		return process;
	}
	public void setProcess(MainProcess process) {
		this.process = process;
	}
}