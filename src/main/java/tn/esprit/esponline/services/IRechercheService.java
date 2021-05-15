package tn.esprit.esponline.services;

import java.util.List;

import tn.esprit.esponline.entities.Recherche;
import tn.esprit.esponline.entities.User;

public interface IRechercheService {
	
	Recherche addSearch(Recherche rech,User u);
	String extractt(long id_user) ;
	List<User> searchUser(String userame,String firstname);

}
