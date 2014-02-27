package org.example.services;

import java.util.List;

import javax.inject.Inject;

import org.example.entities.MainProcess;
import org.example.entities.Task;
import org.example.entities.dao.TaskDaoImpl;
import org.granite.tide.data.DataEnabled;
import org.granite.tide.data.DataEnabled.PublishMode;
//import org.granite.tide.data.DataEnabled;
//import org.granite.tide.data.DataEnabled.PublishMode;
//import org.granite.tide.data.DataEnabled;
//import org.granite.tide.data.DataEnabled.PublishMode;
///import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
@DataEnabled(topic="taskServiceImpl", publish=PublishMode.ON_SUCCESS)
//@Named("spitterServiceImpl")
//@RemoteDestination(id ="spitterServiceImpl")
public class TaskServiceImpl implements TaskService {
	
    @Inject
	private TaskDaoImpl taskDaoImpl;
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addTask(Task task) {
		taskDaoImpl.addTask(task);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Task updateTask(Task task) {
		return taskDaoImpl.updateTask(task);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateTaskFromProcess(Task task,MainProcess process) {
		taskDaoImpl.updateTaskFromProcess(task,process); 
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteTask(Task task) {
		taskDaoImpl.deleteTask(task);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public Task getTaskById(Long taskId) {
		return taskDaoImpl.getTaskById(taskId);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public List<Task> getTaskList() {
		return taskDaoImpl.getTaskList();
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public List<Task> getTaskListByProcessId(Long processId) {
		return taskDaoImpl.getTaskListByProcessId(processId);
	}
	
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public MainProcess getProcessByTaskId(Long taskId) {
		return taskDaoImpl.getProcessByTaskId(taskId);
	}	
}
