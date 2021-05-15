package tn.esprit.esponline.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.esponline.entities.Event;
import tn.esprit.esponline.entities.Jardin_enfant;
import tn.esprit.esponline.entities.Post;
import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.repository.EventRepo;
import tn.esprit.esponline.repository.IJardinRepository;
import tn.esprit.esponline.repository.UserRepository;

@Service
public class EventServiceImpl implements IEventService {
	
	@Autowired
    EventRepo eventRepo;
	
	@Autowired
	UserRepository var1;

	@Autowired
	private IJardinRepository jardrep;
	
	
    @Override
    public List<Event> findAll() {
        return eventRepo.findAll();
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public void delete(Event event) {
        eventRepo.deleteById(event.getId());
    }

    @Override
    public void deleteAll() {
        eventRepo.deleteAll();
    }

    @Override
    public Optional<Event> findById(long id) {
        return eventRepo.findById(id);
    }

    @Override
    public Event save(Event entity,int idjardin,long userid) {
    	
    	User u = var1.findById(userid).get();
        Jardin_enfant jardin = jardrep.findById(idjardin).get();
		
		entity.setUser(u);
		entity.setJardin(jardin);;
        return eventRepo.save(entity);
    }

    @Override
    public List<Event> saveAll(List<Event> list) {
        return eventRepo.saveAll(list);
    }

    @Override
    public Optional<Event> findByType(String type) {
        return eventRepo.findByType(type);
    }

    @Override
    public Optional<Event> findByJardin(int id) {
        return eventRepo.findByJardinId(id);
    }

    @Override
    public Optional<Event> findByUserId(long id) {
        return eventRepo.findByUserId(id);
    }

    @Override
    public void deleteById(long id){
        eventRepo.deleteById(id);
    }
    
	
	@Override	
	public Event updateEvent(Event event2){
		
		Event event1 =eventRepo.findById(event2.getId()).get(); 
		event1.setCategory(event2.getCategory());
		event1.setDescription(event2.getDescription());
		event1.setName(event2.getName());
		event1.setType(event2.getType());
			
		eventRepo.save(event1);
			return event1;
		
		}



}
