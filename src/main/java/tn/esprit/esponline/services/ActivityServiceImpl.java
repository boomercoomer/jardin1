package tn.esprit.esponline.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.esponline.entities.Activity;
import tn.esprit.esponline.entities.Jardin_enfant;
import tn.esprit.esponline.repository.ActivityRepo;
import tn.esprit.esponline.repository.IJardinRepository;

@Service
public class ActivityServiceImpl implements  IActivityService{
	
	    @Autowired
	    ActivityRepo activityRepo;
	    @Autowired
	    IJardinRepository jardrep;
	    
	    @Override
	    public List<Activity> findAll() {
	        return activityRepo.findAll();
	    }

	    @Override
	    public Long count() {
	        return null;
	    }

	    @Override
	    public void delete(Activity Activity) {
	        activityRepo.deleteById(Activity.getIdActivitie());
	    }

	    @Override
	    public void deleteAll() {
	        activityRepo.deleteAll();
	    }

	    @Override
	    public Optional<Activity> findById(int id) {
	        return activityRepo.findById(id);
	    }

	    @Override
	    public Activity addActivity(Activity activity,int idjardin) {
	      
		    Jardin_enfant jardin=jardrep.findById(idjardin).orElse(null);
	        activity.setJardin(jardin);
	        activityRepo.save(activity);
			return activity;
	    }
	    
	    @Override
	    public Activity save(Activity Activity) {
	        return activityRepo.save(Activity);
	    }
	    
	    @Override
	    public List<Activity> saveAll(List<Activity> list) {
	        return activityRepo.saveAll(list);
	    }

	    @Override
	    public Optional<Activity> findByType(String type) {
	        return activityRepo.findByType(type);
	    }

	    @Override
	    public Optional<Activity> findByJardinId(int id) {
	        return activityRepo.findByJardinId(id);
	    }

	    @Override
	    public void deleteByIdActivity(int id) {
	        activityRepo.deleteById(id);
	    }

}
