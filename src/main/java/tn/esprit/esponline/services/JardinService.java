package tn.esprit.esponline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.esponline.entities.Jardin_enfant;
import tn.esprit.esponline.repository.IClaimRepository;
import tn.esprit.esponline.repository.IJardinRepository;
import tn.esprit.esponline.repository.UserRepository;

@Service
public class JardinService  implements IJardinService{
	
	@Autowired
	IJardinRepository jardinResp;
	@Autowired
	UserRepository userResp;
	
	 @Override
	    public Jardin_enfant save(Jardin_enfant jardin) {
	        return jardinResp.save(jardin);
	    }
	
	@Override
	public List<Jardin_enfant> findAllJardin() {
		return jardinResp.findAll();
	}

	@Override
	public void DeleteJardin(int id) {
		jardinResp.deleteById(id);
		
	}

	@Override
	public void reputation(int x, int y, int z) {
		List<Jardin_enfant>listj=jardinResp.findAll();
		for(Jardin_enfant list: listj) {
			int a=((list.getMoyenne_satisfaction_actuelle()*x)+(list.getNum_like()*y)+(list.getNum_dislike()*z));		
		Jardin_enfant j=jardinResp.findById(list.getId()).orElse(null);
		j.setReputation(a);
		jardinResp.save(j);
		}
			
	}

	/*@Override
	public int demendereputation(int id,int jardin_id) {
		Parent p= parentResp.findById(id).orElse(null);
		Jardin_enfant j=jardinResp.findById(jardin_id).orElse(null);
		
		if(j.getState()==true && p.getDemande()==true) {
			return j.getReputation();
		}else if (p.getDemande()==false) {
			p.setDemande(true);
			parentResp.save(p);
			return 1;
		} 
		return 0;
	}*/

	
	

}
