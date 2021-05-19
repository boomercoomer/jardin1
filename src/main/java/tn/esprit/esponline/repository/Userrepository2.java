package tn.esprit.esponline.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.esponline.entities.User;

import java.util.List;

@Repository
public interface Userrepository2 extends CrudRepository<User,Long>{
	User findByUsername(String username);

    List<User> findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrEmailContainingIgnoreCase(String firstName, String lastName, String email);


}
