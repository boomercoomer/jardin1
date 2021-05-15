package tn.esprit.esponline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.esponline.entities.Categorie;
import tn.esprit.esponline.entities.Claim;
import tn.esprit.esponline.entities.Jardin_enfant;
import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.repository.IClaimRepository;
import tn.esprit.esponline.repository.IJardinRepository;
import tn.esprit.esponline.repository.UserRepository;

@Service
public class ClaimService implements IClaimService {
	
	@Autowired
	IClaimRepository claimResp;
    @Autowired
	UserRepository userResp;
	@Autowired
	IJardinRepository jardinResp;
	
	
	@Override
	public Claim addClaim(long userid,int idjardin ,Claim c) {
	User u= userResp.findById(userid).orElse(null);
	Jardin_enfant j= jardinResp.findById(idjardin).orElse(null);
	c.setJardin_enfant(j);
	c.setUser(u);;
	int n= j.getNum_reclamation()+1;
	j.setNum_reclamation(n);
	jardinResp.save(j);
	return claimResp.save(c);
}

	@Override
	public void deleteClaim(int id) {
	Claim c= claimResp.findById(id).orElse(null);
	Jardin_enfant j= jardinResp.findById(c.getJardin_enfant().getId()).orElse(null);
	int n= j.getNum_reclamation()-1;
	j.setNum_reclamation(n);
	jardinResp.save(j);
	claimResp.deleteById(id);
	
}

	@Override
	public List<Claim> getAllClaimByUserId(long userid) {
	List<Claim> claims= userResp.findById(userid).orElse(null).getClaims();
	return claims;
}

@Override
public Claim updateClaim(Claim claim) {
	// TODO Auto-generated method stub
	return claimResp.save(claim);
}
@Override
public List<Claim>getAllClaims(){
	return claimResp.findAll();
} 

@Override
public void deleteALLclaims() {
	claimResp.deleteAll();
}

@Override
public Claim changerCatregory(int id,Claim claim) {
	Claim c= claimResp.findById(id).orElse(null);
	Categorie categorie1= claim.getCategorie();
	c.setCategorie(categorie1);
	return claimResp.save(c);
}

}
