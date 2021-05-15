package tn.esprit.esponline.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.esponline.entities.Demande;
import tn.esprit.esponline.entities.Formulaire;
import tn.esprit.esponline.entities.Jardin_enfant;
import tn.esprit.esponline.entities.Reponses;
import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.repository.IDemandeRepository;
import tn.esprit.esponline.repository.IFormulaireRepository;
import tn.esprit.esponline.repository.IJardinRepository;
import tn.esprit.esponline.repository.UserRepository;

@Service
public class DemandeService implements IDemandeService {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	IJardinRepository  jardinRepo;
	@Autowired
	IDemandeRepository demandeRepo;
	@Autowired
	IFormulaireRepository formuRepo;
	@Override
	public Demande addDemande(long userid, int idjardin) {
	User u = userRepo.findById(userid).orElse(null);
	Jardin_enfant j=jardinRepo.findById(idjardin).orElse(null);
	Demande d= new Demande();
	d.setUsers(u);		;
	d.setReputation(j.getReputation());
	d.setTestjardin(j.getName());
	return demandeRepo.save(d);
}

@Override
public List<Demande> afficherReputation(long userid) {
	User u =userRepo.findById(userid).orElse(null);
	List<Demande> d=u.getDemandes()	;
	List<Demande> x= new ArrayList<>();
	boolean state=true;
	for(Demande list:d) {
		if(state=list.getState()) {
			x.add(list);	
		}
	}
	return x;
}

	@Override
	public void reponseFormulaire(long userid,Formulaire f,int idjardin) {
	User u= userRepo.findById(userid).orElse(null);
	Jardin_enfant j= jardinRepo.findById(idjardin).orElse(null);
	Formulaire form=new Formulaire();
	int x = 0;int y=0;int z=0;int w=0;int r=0,moy=0;
	form.setJardin_enfant(j);
	
	form.setQ1(u.getFormulaire().getQ1());
	form.setQ2(u.getFormulaire().getQ2());
	form.setQ3(u.getFormulaire().getQ3());
	form.setQ4(u.getFormulaire().getQ4());
	form.setQ5(u.getFormulaire().getQ5());
	form.setReponse1(f.getReponse1());
	if(f.getReponse1().equals(Reponses.bonne)) {
		 x=3;
	}else if (f.getReponse1().equals(Reponses.très_bonne)) {
		x=4;
	}else if (f.getReponse1().equals(Reponses.moyenne)) {
		x=2;
	}else if (f.getReponse1().equals(Reponses.pas_bonne)) {
		x=1;
	};
	form.setReponse2(f.getReponse2());
	if(f.getReponse2().equals(Reponses.bonne)) {
		 y=3;
	}else if (f.getReponse2().equals(Reponses.très_bonne)) {
		y=4;
	}else if (f.getReponse2().equals(Reponses.moyenne)) {
		y=2;
	}else if (f.getReponse2().equals(Reponses.pas_bonne)) {
		y=1;
	};
	form.setReponse3(f.getReponse3());
	if(f.getReponse3().equals(Reponses.bonne)) {
		 z=3;
	}else if (f.getReponse3().equals(Reponses.très_bonne)) {
		z=4;
	}else if (f.getReponse3().equals(Reponses.moyenne)) {
		z=2;
	}else if (f.getReponse3().equals(Reponses.pas_bonne)) {
		z=1;
	};
	form.setReponse4(f.getReponse4());
	if(f.getReponse4().equals(Reponses.bonne)) {
		 w=3;
	}else if (f.getReponse4().equals(Reponses.très_bonne)) {
		w=4;
	}else if (f.getReponse4().equals(Reponses.moyenne)) {
		w=2;
	}else if (f.getReponse4().equals(Reponses.pas_bonne)) {
		w=1;
	};
	form.setReponse5(f.getReponse5());
	if(f.getReponse5().equals(Reponses.bonne)) {
		 r=3;
	}else if (f.getReponse5().equals(Reponses.très_bonne)) {
		r=4;
	}else if (f.getReponse5().equals(Reponses.moyenne)) {
		r=2;
	}else if (f.getReponse5().equals(Reponses.pas_bonne)) {
		r=1;
	};
			
	formuRepo.save(form);
	 moy=x+y+z+w+r;
	j.setSomme(j.getSomme()+moy);
	j.setNumForm(j.getNumForm()+1);
	j.setMoyenne_satisfaction_actuelle(j.getSomme()/j.getNumForm());;
	jardinRepo.save(j);
	//List<Formulaire>formulaires=formuRepo.findAll();
	/*for(Formulaire ff:formulaires) {
		int id=ff.getJardin_enfant().getId();
		if (id==idjardin){	
		}
	}
	//adhiya bich kan parent 3endou 7a9 3amer kan formulaire
	/*u.setFormulaire(null);*/
	userRepo.save(u);
}


}
