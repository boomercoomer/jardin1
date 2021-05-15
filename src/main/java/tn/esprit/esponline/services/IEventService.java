package tn.esprit.esponline.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.esponline.entities.Event;

public interface IEventService {
	
	Event updateEvent(Event event);
	List<Event> findAll();
    Long count();
    void delete(Event event);
    void deleteAll();
    Optional<Event> findById(long id);
    Event save(Event entity,int idjardin,long userid);
    List<Event> saveAll(List<Event> list);
    Optional<Event> findByType(String type);
    Optional<Event> findByJardin(int id);
    Optional<Event> findByUserId(long id);
    void deleteById(long id);

}
