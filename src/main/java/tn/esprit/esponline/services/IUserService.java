package tn.esprit.esponline.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.entities.UserDTO;

@Service
public interface IUserService {
	
	
	
	List<User> mylist();
	User addUser(UserDTO user);
	User findbyid(long id);
	void deleteUser(long id) ;
	User authenticatejsf(String username , String email);
	User findUserByUsername(String username);
	UserDetails loadUserByUsername(String username);
	User authenticate(String username , String email);

}
