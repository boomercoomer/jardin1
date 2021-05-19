package tn.esprit.esponline.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.esponline.entities.Event;
import tn.esprit.esponline.services.IEventService;

@RestController
public class EventController {
	
	@Autowired
    private IEventService eventService;
	
	
    //http://localhost:8081/springMVC/servlet/events/add/{jardin-id}/{user-id}
    //2/1
    @PostMapping("/events/add/{jardin-id}/{user-id}")
    public Event addEvent(@RequestBody Event Event,@PathVariable("jardin-id")int idjardin,@PathVariable("user-id")long userid) {
    	return eventService.save(Event,idjardin,userid);}
	
	 //http://localhost:8081/springMVC/servlet/events
    @GetMapping("/events")
    public List<Event> findAll() {
        return this.eventService.findAll();
    }

    //http://localhost:8081/springMVC/servlet/events/count
    @GetMapping ("/events/count")
    public Long count() {
        return eventService.count();
    }

    //http://localhost:8081/springMVC/servlet/events/search/kindergarten/{id}
    @GetMapping("/events/search/kindergarten/{id}")
    public Optional<Event> findbyKinderId(@PathVariable int id) {
        return this.eventService.findByJardin(id);
    }
    
    //http://localhost:8081/springMVC/servlet/events/delete/{id}
    @DeleteMapping("/events/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") int id ) {
        if (!eventService.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
  //http://localhost:8081/springMVC/servlet/events/search/user/{id}
@GetMapping("/events/search/user/{id}")
public Optional<Event> findbyUserId(@PathVariable long id) {
    return this.eventService.findByUserId(id);
}

//http://localhost:8081/springMVC/servlet/events/saveall
    @PostMapping("/events/saveall")
    public List<Event> saveAll(@RequestBody List<Event> Eventlist) {
        return eventService.saveAll(Eventlist);
    }
    
    //http://localhost:8081/springMVC/servlet/updateEvent
   @PutMapping("/updateEvent")       
      public ResponseEntity<String> updateEvent(@RequestBody Event event) {
        	eventService.updateEvent(event); 
		     return new ResponseEntity<>("Event have been modified!", HttpStatus.OK);
		}
    
    //http://localhost:8081/springMVC/servlet/events/deleteall
    @DeleteMapping("/events/deleteall")
    public String deleteAll(){eventService.deleteAll();
    return "All events are deleted";}
    
    //http://localhost:8081/springMVC/servlet/events/search/{id}
    @GetMapping("/events/search/{id}")
    public Optional<Event> getEvent(@PathVariable int id) {return eventService.findById(id);}
    


}
