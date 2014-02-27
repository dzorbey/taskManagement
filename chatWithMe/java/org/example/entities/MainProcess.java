package org.example.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;


@Entity
@Table(name = "MainProcess")
public class MainProcess extends AbstractEntityCustom {

	private static final long serialVersionUID = 8151262180206780432L;
	
	private Task startTask;
	private Task endTask;
	private List<Task> taskList;

	@OneToOne(fetch = FetchType.LAZY)
	public Task getStartTask() {
		return startTask;
	}
	public void setStartTask(Task startTask) {
		this.startTask = startTask;
	}
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mainProcess")
	public List<Task> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	public Task getEndTask() {
		return endTask;
	}
	public void setEndTask(Task endTask) {
		this.endTask = endTask;
	}
	
}