package org.example.entities.dao;


import java.util.List;
import org.example.entities.Spitter;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class SpitterDaoImpl extends BaseDaoImpl {
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addSpitter(Spitter spitter) {
		getcurrentSession().save(spitter);
	}
	
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public Spitter getSpitterById(Long spitterId) {
		
		Criteria criteria = getcurrentSession().createCriteria(Spitter.class);
		criteria.add(Restrictions.eq("id", spitterId));
		return  (Spitter) criteria.uniqueResult();
	}	
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public List<Spitter> getTop10Spitters() {
		
		Criteria criteria = getcurrentSession().createCriteria(Spitter.class);
		criteria.addOrder(Order.desc("id"));
		criteria.setMaxResults(10);
		return criteria.list();
	}
}