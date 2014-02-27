package org.example.services;

import java.util.List;

import org.example.entities.MainProcess;
import org.example.entities.Task;
import org.granite.messaging.service.annotations.RemoteDestination;


@RemoteDestination
public interface TaskService {

    public void addTask(Task task);
    
    public Task updateTask(Task task);
    
    public Task getTaskById(Long taskId);
    
    public List<Task> getTaskList();
    
    public List<Task> getTaskListByProcessId(Long processId);
    
    public void updateTaskFromProcess(Task task,MainProcess process);
    
    public void deleteTask(Task task);
    
    public MainProcess getProcessByTaskId(Long taskId);
}
