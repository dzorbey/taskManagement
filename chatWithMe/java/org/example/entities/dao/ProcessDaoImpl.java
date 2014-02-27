package org.example.entities.dao;

import java.util.List;
import org.example.entities.MainProcess;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class ProcessDaoImpl extends BaseDaoImpl {
	
	@Transactional(propagation = Propagation.REQUIRED)
	public MainProcess addProcess(MainProcess mainProcess) {
		
		getcurrentSession().save(mainProcess);	
		return mainProcess;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public MainProcess updateProcess(MainProcess mainProcess) {
		return (MainProcess) getcurrentSession().merge(mainProcess);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteProcess(MainProcess mainProcess) {
		getcurrentSession().delete(mainProcess);
	}
	
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public MainProcess getProcessById(Long processId) {
		
		Criteria criteria = getcurrentSession().createCriteria(MainProcess.class);
		criteria.add(Restrictions.eq("id", processId));
		criteria.createCriteria("startTask", Criteria.LEFT_JOIN);
		criteria.createCriteria("endTask", Criteria.LEFT_JOIN);
		criteria.createCriteria("taskList", Criteria.LEFT_JOIN);
		
		return  (MainProcess) criteria.uniqueResult();
	}	
	
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public List<MainProcess> getProcesses() {
		
		Criteria criteria = getcurrentSession().createCriteria(MainProcess.class);
		criteria.createCriteria("startTask", Criteria.LEFT_JOIN);
		criteria.createCriteria("endTask", Criteria.LEFT_JOIN);
		//criteria.createCriteria("taskList", Criteria.LEFT_JOIN);
		criteria.addOrder(Order.desc("id"));
		
		return criteria.list();
	}
}