package org.example.services;

import java.util.List;

import javax.inject.Inject;
import org.example.entities.Spitter;
import org.example.entities.dao.SpitterDaoImpl;
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
@DataEnabled(topic="spitterServiceImpl", publish=PublishMode.ON_SUCCESS)
//@Named("spitterServiceImpl")
//@RemoteDestination(id ="spitterServiceImpl")
public class SpitterServiceImpl implements SpitterService {
	
    @Inject
	private SpitterDaoImpl spitterDaoImpl;
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addSpitter(Spitter spitter) {
		
		spitterDaoImpl.addSpitter(spitter);
	}
	
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public Spitter getSpitterById(Long spitterId) {
		
		return spitterDaoImpl.getSpitterById(spitterId);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public List<Spitter> getTop10Spitters() {
		
		return spitterDaoImpl.getTop10Spitters();
	}
	
}