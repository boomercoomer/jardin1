package tn.esprit.esponline.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.esponline.model.User;

import java.util.List;

@Repository
public interface Userrepository2 extends CrudRepository<User,Long>{
	User findByUserName(String username);

    List<User> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String firstName, String lastName, String email);


}
