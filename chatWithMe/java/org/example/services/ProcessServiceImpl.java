package org.example.services;

import java.util.List;
import javax.inject.Inject;
import org.example.entities.MainProcess;
import org.example.entities.dao.ProcessDaoImpl;
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
@DataEnabled(topic="processServiceImpl", publish=PublishMode.ON_SUCCESS)
//@Named("spitterServiceImpl")
//@RemoteDestination(id ="spitterServiceImpl")
public class ProcessServiceImpl implements ProcessService {
	
    @Inject
	private ProcessDaoImpl processDaoImpl;
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addProcess(MainProcess mainProcess) {
		processDaoImpl.addProcess(mainProcess);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public MainProcess updateProcess(MainProcess mainProcess) {
		return processDaoImpl.updateProcess(mainProcess);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteProcess(MainProcess mainProcess) {
		processDaoImpl.deleteProcess(mainProcess);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public MainProcess getProcessById(Long processId) {
		return processDaoImpl.getProcessById(processId);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly=true)
	public List<MainProcess> getProcesses() {
		return processDaoImpl.getProcesses();
	}	
}