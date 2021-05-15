package tn.esprit.esponline.services;

import java.util.List;

import tn.esprit.esponline.entities.Jardin_enfant;

public interface IJardinService {
	
	Jardin_enfant save(Jardin_enfant jardin);
	public List<Jardin_enfant> findAllJardin();
	public void DeleteJardin(int id);
	public  void reputation(int x,int y ,int z);
	//public int demendereputation(int id,int jardin_id);

}
