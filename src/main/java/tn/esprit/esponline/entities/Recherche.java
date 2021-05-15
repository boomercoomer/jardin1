package tn.esprit.esponline.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recherche implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	@Column
	private String type;
	@Column
	private Long nbr;
	@JsonIgnore 
    @ManyToOne(cascade=CascadeType.MERGE)
    private User user;
	
	public Recherche() {
		super();
	}


	public Recherche(long id, String type, Long nbr, User user) {
		super();
		this.id = id;
		this.type = type;
		this.nbr = nbr;
		this.user = user;
	}

	public Long getNbr() {
		return nbr;
	}

	public void setNbr(Long nbr) {
		this.nbr = nbr;
	}

	public Recherche( String type) {
		super();
		this.type = type;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
