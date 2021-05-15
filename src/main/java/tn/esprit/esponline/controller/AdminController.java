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
import tn.esprit.esponline.services.IAdminService;

@RestController
public class AdminController {

	
	@Autowired
	IAdminService adminSer;
	
	//http://localhost:8081/springMVC/servlet/acceptedemande/14
	@PostMapping("/acceptedemande/{id_demande}")
	public ResponseEntity<?>acceptedemande(@PathVariable("id_demande") int id){
		adminSer.accepteDemande(id);
		return new ResponseEntity<>( HttpStatus.CREATED);
	}
	//http://localhost:8081/springMVC/servlet/alldemande
	@GetMapping("/alldemande")
			public ResponseEntity<List<Demande>>getAllClaims(){
				List<Demande> c= adminSer.getAllDemande();
				return new ResponseEntity<List<Demande>>(c,HttpStatus.OK);	
			}
	//http://localhost:8081/springMVC/servlet/addform
	@PostMapping("/addform")
	public ResponseEntity<?>addform(@RequestBody Formulaire f){
		adminSer.AddFrmulaire(f);
		return new ResponseEntity<>( HttpStatus.CREATED);
	}
}
