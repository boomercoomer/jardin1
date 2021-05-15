package tn.esprit.esponline.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	@Enumerated(EnumType.STRING)
	private EventCategory category;
	private String name;
	private String description;
	private String type;
	
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="event")
	private List<Notification> notification;
	
	@JsonIgnore
    @ManyToOne
    private Jardin_enfant jardin;
	
	@ManyToOne
    private User user;


	public void setId(long id) {
		this.id = id;
	}
	

	public Long getId() {
		return id;
	}




	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public EventCategory getCategory() {
		return category;
	}


	public void setCategory(EventCategory category) {
		this.category = category;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Notification> getNotification() {
		return notification;
	}


	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Jardin_enfant getJardin() {
		return jardin;
	}


	public void setJardin(Jardin_enfant jardin) {
		this.jardin = jardin;
	}

	

	public Event(long id, String description, String type) {
		super();
		this.id = id;
		this.description = description;
		this.type = type;
	}


	public Event(long id, String name, String description, String type) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
	}


	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
