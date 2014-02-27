package org.example.services;

import java.util.List;
import org.example.entities.Spitter;
import org.granite.messaging.service.annotations.RemoteDestination;


@RemoteDestination
public interface SpitterService {

    public void addSpitter(Spitter spitter);
    
    public Spitter getSpitterById(Long spitterId);
    
    public List<Spitter> getTop10Spitters();
}
