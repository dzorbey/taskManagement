package org.example.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;


@Entity
@Table(name = "Task")
public class Task extends AbstractEntityCustom {
	
	private static final long serialVersionUID = -12138788832416509L;
	
	private Task previousTask;
	private Task nextTask;
	private List<SubTask> subTaskList;
	private Date maximumProcessDate;
	private TaskType taskType;
	private MainProcess mainProcess;
	


	@OneToOne(fetch = FetchType.LAZY)
	public Task getPreviousTask() {
		return previousTask;
	}
	public void setPreviousTask(Task previousTask) {
		this.previousTask = previousTask;
	}
	
	


	@OneToOne(fetch = FetchType.LAZY)
	public Task getNextTask() {
		return nextTask;
	}
	public void setNextTask(Task nextTask) {
		this.nextTask = nextTask;
	}
	
	

	public Date getMaximumProcessDate() {
		return maximumProcessDate;
	}
	public void setMaximumProcessDate(Date maximumProcessDate) {
		this.maximumProcessDate = maximumProcessDate;
	}
	
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentTask")
	public List<SubTask> getSubTaskList() {
		return subTaskList;
	}
	public void setSubTaskList(List<SubTask> subTaskList) {
		this.subTaskList = subTaskList;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	public TaskType getTaskType() {
		return taskType;
	}
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	

	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@ManyToOne(fetch = FetchType.LAZY)
	public MainProcess getMainProcess() {
		return mainProcess;
	}
	public void setMainProcess(MainProcess mainProcess) {
		this.mainProcess = mainProcess;
	}
}