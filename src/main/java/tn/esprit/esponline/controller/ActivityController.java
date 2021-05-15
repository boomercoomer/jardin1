package tn.esprit.esponline.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.esponline.entities.Activity;
import tn.esprit.esponline.services.IActivityService;


@RestController
public class ActivityController {
	
	@Autowired
    private IActivityService iactivityrep;
	
	
	//http://localhost:8081/springMVC/servlet/ajouteractivity/{jardinId}    
    @PostMapping("/ajouteractivity/{jardinId}")
    @ResponseBody
	public Activity addActivity(@RequestBody Activity activity,@PathVariable("jardinId") int idjardin) {
    	   iactivityrep.addActivity(activity,idjardin);     
	           return activity;
	}

    @GetMapping("/activities")
    public List<Activity> findAll() {
        return this.iactivityrep.findAll();
    }


  //http://localhost:8081/springMVC/servlet/activities/count
    @GetMapping ("/activities/count")
    public Long count() {
        return iactivityrep.count();
    }
  //http://localhost:8081/springMVC/servlet/activities/search/jardin/{id_jardin}
    @GetMapping("/activities/search/jardin/{id_jardin}")
    public Optional<Activity> findbyJardinId(@PathVariable int id) {
        return this.iactivityrep.findByJardinId(id);
    }
  //http://localhost:8081/springMVC/servlet/activities/delete/{id}
    @DeleteMapping("/activities/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") int id ) {
        if (!iactivityrep.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        iactivityrep.deleteByIdActivity(id);
        return ResponseEntity.noContent().build();
    }
    
  //http://localhost:8081/springMVC/servlet/activities/saveall
    @PostMapping("/activities/saveall")
    public List<Activity> saveAll(@RequestBody List<Activity> Activitylist) {
        return iactivityrep.saveAll(Activitylist);
    }
    
  //http://localhost:8081/springMVC/servlet/activities/edit/save
    @PutMapping("/activities/edit/save")
    public Activity save(@RequestBody Activity Activity) {
        return iactivityrep.save(Activity);
    }
    
  //http://localhost:8081/springMVC/servlet/activities/search/{id}
    @GetMapping("/activities/search/{id}")
    public Optional<Activity> getActivity(@PathVariable int id) {
    	return iactivityrep.findById(id);}
    
  //http://localhost:8081/springMVC/servlet/activities/add  
    @PostMapping("/activities/add")
    public Activity addActivity(@RequestBody Activity Activity) {
    	return iactivityrep.save(Activity);}

}
