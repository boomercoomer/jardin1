package tn.esprit.esponline.services;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.esponline.controller.UserController;
import tn.esprit.esponline.entities.Event;
import tn.esprit.esponline.entities.Notification;
import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.repository.NotificationRepository;
import tn.esprit.esponline.repository.UserRepository;

@Service
public class NotificationService implements INotificationService {
	
	@Autowired
	UserServiceImpl US;
	@Autowired
	NotificationRepository NR;
	@Autowired
	UserRepository UR;

	/**********************************Admin**********************************/
	//Send Notifications to all users for contribution
	@Override
	public void notifyAllUser(Event ev) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		
		List<User> allUsers = UR.findAll();
		
		for(User u : allUsers) {
			Notification n = new Notification();
			n.setEvent(ev);
			n.setUser(u);
			n.setBody("Dear "+u.getLastname()+" "+u.getFirstname()+", we invite you to contribute by an amount of money to the event "+
					  ev.getName()+" for "+ev.getDescription()+".Thank you.");
			n.setDate(dateFormat.format(date));
			n.setStatus("Not Seen Yet");
			NR.save(n);
		}		
	}

	/**********************************User**********************************/
	//retrieve my own notifications
	@Override
	public List<Notification> myNotifications() {
		List<Notification> list = NR.myNotifications(UserController.USERCONNECTED);
		return list;
	}
	
	
	/*@Override
	public void ajouterNotification(Notification notification) {

		 NotR.save(notification);

	}*/
	@Override
	public long ajouterNotif(Notification notification) {

		return NR.save(notification).getId();

	}


	@Override
	public List<Notification> listnotif() {
		return (List<Notification>) NR.findAll();

	}
	
	@Override
	public void deleteNotifById(long ide) {
		Notification n= NR.findById(ide).get();
		NR.delete(n);		
	}


	@Override
	public void mettreAjourBodyByNotifId(String Body, long id) {
		Notification notif = NR.findById(id).get();

		notif.setBody(Body);

		NR.save(notif);		
	}
	@Override
	public List<String> getAllNotifTrieJPQL() {
		return NR.getAllNotifTrieJPQL();
	}


	@Override
	public Long getNombreNotification() {
		// TODO Auto-generated method stub
		return NR.getnombreNotification();
	}

}
