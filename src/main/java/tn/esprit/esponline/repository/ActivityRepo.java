package tn.esprit.esponline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.esponline.entities.Activity;

@Repository
public interface ActivityRepo extends JpaRepository<Activity,Integer> {
	
	 Optional<Activity> findByType(String type);
	 Optional<Activity> findByJardinId(int id);

}
