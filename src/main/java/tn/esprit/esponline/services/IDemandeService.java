package tn.esprit.esponline.services;

import java.util.List;
import tn.esprit.esponline.entities.Demande;
import tn.esprit.esponline.entities.Formulaire;


public interface IDemandeService {

	public Demande addDemande(long userid,int idjardin);
	public List<Demande>afficherReputation(long userid);
	public void reponseFormulaire(long userid,Formulaire f,int idjardin);
}
