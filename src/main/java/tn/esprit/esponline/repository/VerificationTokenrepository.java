package tn.esprit.esponline.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.esponline.entities.VerificationToken;

public interface VerificationTokenrepository extends CrudRepository<VerificationToken,Long>{
	VerificationToken findByToken(String token); 
}
