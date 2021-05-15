package tn.esprit.esponline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.esponline.entities.Event;

@Repository
public interface EventRepo extends JpaRepository<Event,Long> {
	
	    Optional<Event> findByType(String type);
	    Optional<Event> findByJardinId(int id);
	    Optional<Event> findByUserId(long id);
	    

}
