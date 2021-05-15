package tn.esprit.esponline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.esponline.entities.Demande;
import tn.esprit.esponline.entities.Formulaire;
import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.repository.IDemandeRepository;
import tn.esprit.esponline.repository.IFormulaireRepository;
import tn.esprit.esponline.repository.UserRepository;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	IDemandeRepository demandeRepository;
	@Autowired
	IFormulaireRepository  formRepos;
	@Autowired 
	UserRepository userRepos;
	@Override
	public List<Demande> getAllDemande() {
		
		return demandeRepository.findAll();
	}

	@Override
	public void accepteDemande(int id_demande) {
		Demande d=demandeRepository.findById(id_demande).orElse(null);
		d.setState(true);
		demandeRepository.save(d);
		
	}

	@Override
	public void AddFrmulaire(Formulaire f) {
		formRepos.save(f);
		Formulaire form=formRepos.findById(f.getId()).orElse(null);
		List<User> u= userRepos.findAll();
		for(User user:u) {
			
			user.setFormulaire(form);
			userRepos.save(user);
		}
		
	}
	

}
