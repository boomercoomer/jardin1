package tn.esprit.esponline.services;

import java.util.List;

import tn.esprit.esponline.entities.Bus;

public interface IBusService {
	
	List<Bus> getAllBus(); 
	public Bus getBusById(Long  matricule);
	public Bus addBus(Bus B);
	public void deleteBus(Long  matricule);
	Bus updateBus(Long  matricule, Bus B);
	public int getSeatCapacity();
	
	public double trajet(Long  matricule);
	//public Bus trajet(Long  matricule);

}
