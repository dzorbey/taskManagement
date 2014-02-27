package org.example.entities.dao;


import java.util.List;

import org.example.entities.MainProcess;
import org.example.entities.Task;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class TaskDaoImpl extends BaseDaoImpl {
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Task addTask(Task task) {
		
		getcurrentSession().save(task);
		return task;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Task updateTask(Task task) {
		return (Task) getcurrentSession().merge(task);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Task updateTaskFromProcess(Task task,MainProcess process) {
		return (Task) getcurrentSession().merge(task);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteTask(Task task) {
		getcurrentSession().delete(task);
	}
	
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public Task getTaskById(Long taskId) {
		
		Criteria criteria = getcurrentSession().createCriteria(Task.class);
		criteria.add(Restrictions.eq("id", taskId));
		return  (Task) criteria.uniqueResult();
	}	
	
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public MainProcess getProcessByTaskId(Long taskId) {
		
		Criteria criteria = getcurrentSession().createCriteria(MainProcess.class);
		criteria.add(Restrictions.eq("id", taskId));
		return  (MainProcess) criteria.uniqueResult();
	}	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public List<Task> getTaskList() {
		
		Criteria criteria = getcurrentSession().createCriteria(Task.class);
		criteria.createCriteria("mainProcess", Criteria.LEFT_JOIN);
		criteria.createCriteria("previousTask", Criteria.LEFT_JOIN);
		criteria.createCriteria("nextTask", Criteria.LEFT_JOIN);
		criteria.createCriteria("taskType", Criteria.LEFT_JOIN);
		

		criteria.addOrder(Order.desc("id"));
		return criteria.list();
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public List<Task> getTaskListByProcessId(Long processId) {
		
		Criteria criteria = getcurrentSession().createCriteria(Task.class);
		criteria.add(Restrictions.eq("mainProcess.id", processId));
		criteria.addOrder(Order.desc("id"));
		return criteria.list();
	}
}