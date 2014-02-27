package org.example.entities.dao;


import java.util.List;
import org.example.entities.TaskType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class TaskTypeDaoImpl extends BaseDaoImpl {
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addTaskType(TaskType taskType) {
		getcurrentSession().save(taskType);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateTaskType(TaskType taskType) {
		getcurrentSession().update(taskType);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteTaskType(TaskType taskType) {
		getcurrentSession().delete(taskType);
	}
	
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public TaskType getTaskTypeById(Long taskTypeId) {
		
		Criteria criteria = getcurrentSession().createCriteria(TaskType.class);
		criteria.add(Restrictions.eq("id", taskTypeId));
		return  (TaskType) criteria.uniqueResult();
	}	
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public List<TaskType> getTaskTypes() {
		
		Criteria criteria = getcurrentSession().createCriteria(TaskType.class);
		criteria.addOrder(Order.desc("id"));
		return criteria.list();
	}
}