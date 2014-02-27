package org.example.services;

import java.util.List;

import javax.inject.Inject;
import org.example.entities.TaskType;
import org.example.entities.dao.TaskTypeDaoImpl;
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
@DataEnabled(topic="taskTypeServiceImpl", publish=PublishMode.ON_SUCCESS)
//@Named("spitterServiceImpl")
//@RemoteDestination(id ="spitterServiceImpl")
public class TaskTypeServiceImpl implements TaskTypeService {
	
    @Inject
	private TaskTypeDaoImpl taskTypeDaoImpl;
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addTaskType(TaskType taskType) {
		taskTypeDaoImpl.addTaskType(taskType);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateTaskType(TaskType taskType) {
		taskTypeDaoImpl.updateTaskType(taskType);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteTaskType(TaskType taskType) {
		taskTypeDaoImpl.deleteTaskType(taskType);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public TaskType getTaskTypeById(Long taskTypeId) {
		return taskTypeDaoImpl.getTaskTypeById(taskTypeId);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public List<TaskType> getTaskTypes() {
		return taskTypeDaoImpl.getTaskTypes();
	}
	
}