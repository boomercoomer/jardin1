package tn.esprit.esponline.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="user")
public class User implements Serializable{
	private static final long serialVersionUID = -6236517548335858347L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private boolean demande=false;
    @Enumerated(EnumType.STRING)
	private Adresse adresse;

	
	
	@OneToMany(mappedBy="user",cascade=CascadeType.REFRESH)
	private List<Comment> comments=new ArrayList<>();
	
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	private List<Post> posts;//=new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Jardin_enfant jardin_enfant;
	
	@OneToMany(mappedBy = "user")
	private List<Claim> claims;
	
	@OneToMany(mappedBy = "user")
	private List<Demande> demandes;
	
	@ManyToOne 
	private Formulaire formulaire;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="user" , cascade=CascadeType.MERGE)
    private List<Recherche> recherches;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private List<Notification> notification;
	
	@OneToMany()
    private List<Event> events;
	
	@JsonIgnore
    @OneToMany(mappedBy = "sender")
    private List<Message> messages;
	
	/*@ManyToOne
	private kindergarten kindergarten;
	
	@ManyToOne
	private Admin admin;*/
	
    

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}


	public User(String username, String password, String firstname, String lastname, String email, String role) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
	}


	public User(Long id, String username, String password, String firstname, String lastname, String email,
			Adresse adresse) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.adresse = adresse;
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	


	public User(String username, String password, String firstname, String lastname, String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Post> getPosts() {
		return posts;
	}


	


	public boolean isDemande() {
		return demande;
	}


	public void setDemande(boolean demande) {
		this.demande = demande;
	}


	public Jardin_enfant getJardin_enfant() {
		return jardin_enfant;
	}


	public void setJardin_enfant(Jardin_enfant jardin_enfant) {
		this.jardin_enfant = jardin_enfant;
	}


	public List<Claim> getClaims() {
		return claims;
	}


	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}


	public List<Demande> getDemandes() {
		return demandes;
	}


	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}


	public Formulaire getFormulaire() {
		return formulaire;
	}


	public void setFormulaire(Formulaire formulaire) {
		this.formulaire = formulaire;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/*public kindergarten getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}*/
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		//result = prime * result + ((kindergarten == null) ? 0 : kindergarten.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	public List<Recherche> getRecherches() {
		return recherches;
	}


	public void setRecherches(List<Recherche> recherches) {
		this.recherches = recherches;
	}


	public List<Notification> getNotification() {
		return notification;
	}


	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}


	public List<Event> getEvents() {
		return events;
	}


	public void setEvents(List<Event> events) {
		this.events = events;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		/*if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;*/
		
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		/*if (kindergarten == null) {
			if (other.kindergarten != null)
				return false;
		} else if (!kindergarten.equals(other.kindergarten))
			return false;*/
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
	
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email ;	}


	public List<Message> getMessages() {
		return messages;
	}


	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Role> getRoleList(){

		List<Role> list = new ArrayList<>();
		List<Role> l =  Arrays.asList(Role.values());
		list.addAll(l);
		return list;
	}





}
