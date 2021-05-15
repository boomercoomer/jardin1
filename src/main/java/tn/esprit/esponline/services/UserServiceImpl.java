package tn.esprit.esponline.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.entities.UserDTO;
import tn.esprit.esponline.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepo;
	
	
	
	public User addUser(UserDTO user) {
		User newuser = new User();
		newuser.setUsername(user.getUsername());
		newuser.setPassword(user.getPassword());
		newuser.setFirstname(user.getFirstname());
		newuser.setLastname(user.getLastname());
		newuser.setEmail(user.getEmail());
		
		return userRepo.save(newuser);
	}

	public User findUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	//NEW ONE 
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = userRepo.findByUsername(username);
			if (user == null) {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					new ArrayList<>());
		}
	


	public User findbyid(long id) {

		return userRepo.findById(id).get();
	}


	public List<User> mylist() {

		return (List<User>) userRepo.findAll();
	}

	public void deleteUser(long id) {

		userRepo.deleteById(id);

	}
	
	public User authenticate(String username, String email) {
		User u = userRepo.findByUsernameAndEmail(username, email);
		return u;
	}
	public User authenticatejsf(String username, String password) {
		User u = userRepo.findByUsernameAndPassword(username, password);
		return u;
	}
	
}
