package tn.esprit.esponline.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Notification implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String Body;
	private String date;
	private String status;
	private String Link ;
	private String NotifType ;
	
	

	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	@ManyToOne
	@JsonIgnore
	private Event event;
	
	
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Notification(String Body, String date, String status, String link, String notifType) {
		super();
		this.Body = Body;
		this.date = date;
		this.status = status;
		Link = link;
		NotifType = notifType;
		
	}


	public Notification(Long id, String Body, String date, String status, User user, Event event) {
		super();
		this.id = id;
		this.Body = Body;
		this.date = date;
		this.status = status;
		this.user = user;
		this.event = event;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String Body) {
		this.Body = Body;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Link == null) ? 0 : Link.hashCode());
		result = prime * result + ((NotifType == null) ? 0 : NotifType.hashCode());
		result = prime * result + ((Body == null) ? 0 : Body.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notification other = (Notification) obj;
		if (Link == null) {
			if (other.Link != null)
				return false;
		} else if (!Link.equals(other.Link))
			return false;
		if (NotifType == null) {
			if (other.NotifType != null)
				return false;
		} else if (!NotifType.equals(other.NotifType))
			return false;
		if (Body == null) {
			if (other.Body != null)
				return false;
		} else if (!Body.equals(other.Body))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", Body=" + Body + ", date=" + date + ", status=" + status + ", user=" + user
				+ ", event=" + event ;
	}

	public String getLink() {
		return Link;
	}

	public void setLink(String link) {
		Link = link;
	}

	public String getNotifType() {
		return NotifType;
	}

	public void setNotifType(String notifType) {
		NotifType = notifType;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(long id) {
		this.id = id;
	}
	
 

	

}
