package tn.esprit.esponline.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Demande implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int id;
	private  int reputation;
	@JsonIgnore
	@ManyToOne
	private User user;
	private String testjardin;

	private boolean state=false ;
	public Demande( int reputation, User user, String testjardin, boolean state) {
		super();

		this.reputation = reputation;
		this.user = user;
		this.testjardin = testjardin;
		
		this.state = state;
	}
	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public int getReputation() {
		return reputation;
	}
	public User getUser() {
		return user;
	}
	public String getTestjardin() {
		return testjardin;
	}


	public void setId(int id) {
		this.id = id;
	}
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}
	public void setUsers(User user) {
		this.user = user;
	}
	public void setTestjardin(String testjardin) {
		this.testjardin = testjardin;
	}

	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}

}
