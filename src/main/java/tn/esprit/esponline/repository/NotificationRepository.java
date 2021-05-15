package tn.esprit.esponline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.esponline.entities.Notification;
import tn.esprit.esponline.entities.User;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long>,JpaRepository<Notification, Long>{

	
	@Query("SELECT n FROM Notification n WHERE n.user=:userid")
	List<Notification> myNotifications(@Param("userid") User userid);
	
	@Query("select n.Body from Notification n order by created_at desc ")
	public List<String> getAllNotifTrieJPQL();
	
	
	
	@Query("select count(n) from Notification n where Seen=1 and user_id=1")
	public long getnombreNotification();
}
