package tn.esprit.esponline.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.esponline.entities.Recherche;
import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.repository.RechercheRepository;
import tn.esprit.esponline.repository.UserRepository;


@Service
public class RechercheService implements IRechercheService {
	
	@Autowired
	private RechercheRepository var;
	
	@Autowired
	private UserRepository userep;
	
	
	@Override
	public String extractt(long id_user){
		 
		Long max = var.lemax(id_user);
		String type = var.extract(max);
	
		 return type;
		
	}
	
	@Override
	public List<User> searchUser(String username,String firstname){		
		List<User> 	users=userep.findAll();
		boolean containsUse=true;
		boolean containsNam=true;
		List<User> 	result=  new ArrayList<>();
		if ((username==null)||(username=="")) containsUse=false;
		if ((firstname==null)||(firstname=="")) containsNam=false;
		if (!containsUse && !containsNam) return result;
		int nbUsers=users.size();	
		User user=new User();	
		
		if (!containsUse) {
			for(int index = 0; index < nbUsers; index++){
				user=users.get(index);
				containsNam=true;
				if ((user.getFirstname()==null)||(user.getFirstname()=="")) {containsNam=false;}
				else {containsNam=user.getUsername().contains(firstname);}
				if (containsNam){
					result.add(user);
				}
			}
		}
		
		else if (!containsNam) {
			for(int index = 0; index < nbUsers; index++){
				user=users.get(index);
				containsUse=true;
				if((user.getUsername()==null)||(user.getUsername()=="")) {containsUse=false;}
				else {containsUse=user.getUsername().contains(username);}
				if ( containsUse){
					result.add(user);
				}
			}
		}
		
		else {
			for(int index = 0; index < nbUsers; index++){
				user=users.get(index);
				containsUse=true;
				containsNam=true;
				if ((user.getUsername()==null)||(user.getUsername()=="")) {containsUse=false;}
				else {containsUse=user.getUsername().contains(username);}
				if((user.getFirstname()==null)||(user.getFirstname()=="")) {containsNam=false;}
				else {containsNam=user.getFirstname().contains(firstname);}
				if ( containsUse || containsNam){
					result.add(user);
				}
			}
		}		
		return result;		
	}
	
	
	
	
	@Override	
	@Transactional
	public Recherche addSearch(Recherche rech,User u){
		
		//le type introduit :
		String t = rech.getType();
		//la recherche sur ce type :
		Recherche r = var.findByTypeAndUser(t, u);
		
		long a = 1L;
		///si la recherche sur ce type n'existe pas : 
		if(r==null) {
			
			rech.setUser(u);
			rech.setNbr(a);
			var.save(rech);
		}
		else {
			
			//get nbr from recherche et incrémenter nbr 
			long count = r.getNbr()+a;
			
			//modifier le recherche et enregistrer
			r.setNbr(count);
			rech=r;
			var.save(rech);
		}
	return rech;
			
		}

	

}
