package tn.esprit.esponline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.esponline.entities.Jardin_enfant;

@Repository
public interface IJardinRepository extends JpaRepository<Jardin_enfant, Integer> {
	
	Optional<Jardin_enfant> findByName(String name);	

}
