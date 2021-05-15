package tn.esprit.esponline.services;

import java.util.List;

import tn.esprit.esponline.entities.Event;
import tn.esprit.esponline.entities.Notification;

public interface INotificationService {
	
	public void notifyAllUser(Event ev);
	public List<Notification> myNotifications(); 
	//public Long ajouterNotification(Notification notification);
		public List<Notification> listnotif();
		public void deleteNotifById(long ide);
		//public void affecterMessageAUser(Long id , Long user_id);
		public long ajouterNotif(Notification notification);
		public void mettreAjourBodyByNotifId(String Body, long id);
		public List<String> getAllNotifTrieJPQL();
		public Long getNombreNotification() ;

}
