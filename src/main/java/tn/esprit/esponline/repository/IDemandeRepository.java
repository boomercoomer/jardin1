package tn.esprit.esponline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.esponline.entities.Demande;

public interface IDemandeRepository extends JpaRepository<Demande, Integer> {
	
	@Query("select u from Demande u where u.state=false")
	public List<Demande> findByIdAndState();

}
