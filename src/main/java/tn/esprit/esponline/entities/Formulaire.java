package tn.esprit.esponline.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Formulaire implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private  String q1;
	private Reponses reponse1;
	private  String q2;
	private Reponses reponse2;
	private  String q3;
	private Reponses reponse3;
	private  String q4;
	private Reponses reponse4;
	private  String q5;
	private Reponses reponse5;
	@ManyToOne
	private Jardin_enfant jardin_enfant;
	public Formulaire(String q1, Reponses reponse1, String q2, Reponses reponse2, String q3, Reponses reponse3, String q4,
			Reponses reponse4, String q5, Reponses reponse5) {
		super();
		this.q1 = q1;
		this.reponse1 = reponse1;
		this.q2 = q2;
		this.reponse2 = reponse2;
		this.q3 = q3;
		this.reponse3 = reponse3;
		this.q4 = q4;
		this.reponse4 = reponse4;
		this.q5 = q5;
		this.reponse5 = reponse5;
	}
	public int getId() {
		return id;
	}
	public String getQ1() {
		return q1;
	}
	public Reponses getReponse1() {
		return reponse1;
	}
	public String getQ2() {
		return q2;
	}
	public Reponses getReponse2() {
		return reponse2;
	}
	public String getQ3() {
		return q3;
	}
	public Reponses getReponse3() {
		return reponse3;
	}
	public String getQ4() {
		return q4;
	}
	public Reponses getReponse4() {
		return reponse4;
	}
	public String getQ5() {
		return q5;
	}
	public Reponses getReponse5() {
		return reponse5;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setQ1(String q1) {
		this.q1 = q1;
	}
	public void setReponse1(Reponses reponse1) {
		this.reponse1 = reponse1;
	}
	public void setQ2(String q2) {
		this.q2 = q2;
	}
	public void setReponse2(Reponses reponse2) {
		this.reponse2 = reponse2;
	}
	public void setQ3(String q3) {
		this.q3 = q3;
	}
	public void setReponse3(Reponses reponse3) {
		this.reponse3 = reponse3;
	}
	public void setQ4(String q4) {
		this.q4 = q4;
	}
	public void setReponse4(Reponses reponse4) {
		this.reponse4 = reponse4;
	}
	public void setQ5(String q5) {
		this.q5 = q5;
	}
	public void setReponse5(Reponses reponse5) {
		this.reponse5 = reponse5;
	}
	public Formulaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jardin_enfant getJardin_enfant() {
		return jardin_enfant;
	}
	public void setJardin_enfant(Jardin_enfant jardin_enfant) {
		this.jardin_enfant = jardin_enfant;
	}
	public void setQi(String q12) {
		// TODO Auto-generated method stub
		
	}

}
