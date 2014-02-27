package org.example.services;

import java.util.List;
import org.example.entities.TaskType;
import org.granite.messaging.service.annotations.RemoteDestination;


@RemoteDestination
public interface TaskTypeService {

    public void addTaskType(TaskType taskType);
    
    public void updateTaskType(TaskType taskType);
    
    public TaskType getTaskTypeById(Long taskTypeId);
    
    public List<TaskType> getTaskTypes();
    
    public void deleteTaskType(TaskType taskType);
}
