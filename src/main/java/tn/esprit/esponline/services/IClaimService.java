package tn.esprit.esponline.services;

import java.util.List;

import tn.esprit.esponline.entities.Claim;

public interface IClaimService {
	
	public Claim addClaim(long iduser,int idjardin,Claim c);
	public void deleteClaim(int id);
	public List<Claim>getAllClaimByUserId(long userid);
	public Claim updateClaim(Claim claim);
	List<Claim> getAllClaims();
	void deleteALLclaims();
	public Claim changerCatregory(int id,Claim claim);

}
