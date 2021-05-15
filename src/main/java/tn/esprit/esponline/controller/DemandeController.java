package tn.esprit.esponline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.esponline.entities.Demande;
import tn.esprit.esponline.entities.Formulaire;
import tn.esprit.esponline.services.DemandeService;
import tn.esprit.esponline.services.UserServiceImpl;

@RestController
public class DemandeController {
	
	@Autowired 
	UserServiceImpl userService;
	
	@Autowired 
	DemandeService demandeService;
	
	
	//http://localhost:8081/springMVC/servlet/adddemande/2/1
	@PostMapping("/adddemande/{user_id}/{jardin_id}")
	public ResponseEntity<Demande> adddemande(@PathVariable("user_id") long id,@PathVariable("jardin_id")int idjardin ){
		Demande d= demandeService.addDemande(id, idjardin);
		return new ResponseEntity<Demande>(d, HttpStatus.CREATED);
	}
	//http://localhost:8081/springMVC/servlet/reputation/2
	@GetMapping("/reputation/{user_id}")
	public ResponseEntity<List<Demande>>afficherReputation(@PathVariable("user_id") long id){
		List<Demande> i= demandeService.afficherReputation(id);
		return new ResponseEntity<>(i, HttpStatus.OK);
	}
	//http://localhost:8081/springMVC/servlet/reponseFormulaire/
	@PostMapping("/reponseFormulaire/{user_id}/{jardin_id}")
	public ResponseEntity<?>reponseFormulaire(@PathVariable("user_id") long id,@RequestBody Formulaire f,@PathVariable("jardin_id")int idjardin){
		demandeService.reponseFormulaire(id,f,idjardin);
		return new ResponseEntity<>( HttpStatus.CREATED);
	}
	

}
