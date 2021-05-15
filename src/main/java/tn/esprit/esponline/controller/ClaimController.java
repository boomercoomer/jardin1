package tn.esprit.esponline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.esponline.entities.Claim;
import tn.esprit.esponline.services.IClaimService;

@RestController
public class ClaimController {
	
	@Autowired 
	IClaimService claimSer;
	
	//http://localhost:8081/springMVC/servlet/addclaim/2/1
	@PostMapping("/addclaim/{user_id}/{jardin_id}")
	public ResponseEntity<?> addclaim(@PathVariable("user_id") long id,@PathVariable("jardin_id")int idjardin ,@RequestBody Claim claim){
		Claim c = claimSer.addClaim(id,idjardin,claim);
		return new ResponseEntity<> (c, HttpStatus.OK);
	}
	//http://localhost:8081/springMVC/servlet/deleteClaim/7
	@DeleteMapping("/deleteClaim/{claim_id}")
	public ResponseEntity<?>deleleallclaim(@PathVariable("claim_id") int id){
		claimSer.deleteClaim(id);;
		return new ResponseEntity<>(HttpStatus.OK);
	}
	//http://localhost:8081/springMVC/servlet/changeclaim/{claim_id}
	@PostMapping("/changeclaim/{claim_id}")
	public ResponseEntity<Claim> changeCategorieclaim(@PathVariable("claim_id") int id, @RequestBody Claim c){
		Claim claim = claimSer.changerCatregory(id, c);
		return new ResponseEntity<Claim>(claim, HttpStatus.CREATED);
	}
	//http://localhost:8081/springMVC/servlet/allclaims
		@GetMapping("/allclaims")
		public ResponseEntity<List<Claim>> getAllClaims(){
			List<Claim> c= claimSer.getAllClaims();
			return new ResponseEntity<List<Claim>>(c,HttpStatus.OK);
			
		}
		//http://localhost:8081/springMVC/servlet/deleteAllClaim
		@DeleteMapping("/deleteAllClaim")
		public ResponseEntity<?>deleleallclaim(){
			claimSer.deleteALLclaims();
			return new ResponseEntity<>(HttpStatus.OK);
		}

}
