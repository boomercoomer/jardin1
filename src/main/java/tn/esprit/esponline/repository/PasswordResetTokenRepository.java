package tn.esprit.esponline.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.esponline.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken,Long> {
	PasswordResetToken findByToken(String token);
}
