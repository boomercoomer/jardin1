package tn.esprit.esponline.services;

import java.util.List;

import tn.esprit.esponline.entities.Demande;
import tn.esprit.esponline.entities.Formulaire;

public interface IAdminService {
	
	public List<Demande>getAllDemande();
	public void accepteDemande(int id_demande);
	public void AddFrmulaire(Formulaire f);

}
