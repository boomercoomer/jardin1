package tn.esprit.esponline.services;

import tn.esprit.esponline.entities.User;

import java.util.List;

public interface UserService {

	public void addAdmin(User user);
	public void addParent(User user);
	
	
	
	public void verifyAccount(String token);
	
	public List<User> getAllUsers();
	
	public User findById(long id) ;
	
	public long getUserId(User user);
	
	public String DeleteAccount(long id) ;
	
	public User UpdateUser(User user);
	
	public void changeUserPassword(User user, String password);
	
	//public List<User> listAll(String keyword);
	public List<User> findByFirstNameLikeOrLastNameLikeOrEmailLike(String keyword);
	

}
