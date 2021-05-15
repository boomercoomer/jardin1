package tn.esprit.esponline.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Activity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idactivity")
    private int idActivity;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @ManyToOne
    private Jardin_enfant jardin;

    public Activity(int idActivitie, String type, String description,  Jardin_enfant jardin) {
        this.idActivity = idActivitie;
        this.type = type;
        this.description = description;
        this.jardin = jardin;
    }

    public Activity() {
    }


	public Activity(String type, String description, Jardin_enfant jardin) {
		super();
		this.type = type;
		this.description = description;
		this.jardin = jardin;
	}

	public int getIdActivitie() {
        return idActivity;
    }

    public void setIdActivitie(int idActivitie) {
        this.idActivity = idActivitie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Jardin_enfant getJardin() {
        return jardin;
    }

    public void setJardin(Jardin_enfant jardin) {
        this.jardin = jardin;
    }

}
