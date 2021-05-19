package tn.esprit.esponline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.entities.UserDet;
import tn.esprit.esponline.repository.Userrepository2;

@Service
public class UserDetService implements UserDetailsService {
	
	
	@Autowired
	private Userrepository2 userRepository;
		
	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		 User user = this.userRepository.findByUsername(userName);
		 UserDet userDet = new UserDet(user); 

		 
		 return userDet ; 
	}
}
