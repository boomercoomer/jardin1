package tn.esprit.esponline.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Claim implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id 
	private int id ; 
	private String contnu ;
	private Categorie categorie ;
	
	@JsonIgnore
	@ManyToOne
	private User user ;
	@JsonIgnore
	@ManyToOne
	private Jardin_enfant jardin_enfant;
	
	
	public Claim(int id, String contnu, Categorie categorie, User user, Jardin_enfant jardin_enfant) {
		super();
		this.id = id;
		this.contnu = contnu;
		this.categorie = categorie;
		this.user = user;
		this.jardin_enfant = jardin_enfant;
	}

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public String getContnu() {
		return contnu;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public User getUser() {
		return user;
	}
	public Jardin_enfant getJardin_enfant() {
		return jardin_enfant;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setContnu(String contnu) {
		this.contnu = contnu;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setJardin_enfant(Jardin_enfant jardin_enfant) {
		this.jardin_enfant = jardin_enfant;
	}
	

}
