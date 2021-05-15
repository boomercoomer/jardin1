package tn.esprit.esponline.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.esponline.entities.Activity;

public interface IActivityService {
	
	    Activity addActivity (Activity activity,int idjardin)	;
	    Activity save(Activity entity);
	    List<Activity> findAll();
	    Long count();
	    void delete(Activity entity);
	    void deleteAll();
	    Optional<Activity> findById(int id);
	    List<Activity> saveAll(List<Activity> list);
	    Optional<Activity> findByType(String type);
	    Optional<Activity> findByJardinId(int id);
	    void deleteByIdActivity(int id);

}
