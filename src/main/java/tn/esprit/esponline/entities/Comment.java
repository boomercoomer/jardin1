package tn.esprit.esponline.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String mot;
	
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    @ManyToOne
    //@JoinColumn(name="idPost",referencedColumnName="id")
    private Post post;
    
    @ManyToOne
    //@JoinColumn(name="idUser",referencedColumnName="id")
    private User user;
    
    @OneToMany(mappedBy="comment")
	private List<Comment_evaluation> ratings;
	
	//@OneToOne(mappedBy="comment")
	//private Notification notif;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Comment(String mot, Post post, User user) {
		super();
		this.mot = mot;
		this.post = post;
		this.user = user;
	}



	public Comment(String mot) {
		super();
		this.mot = mot;
	}



	public List<Comment_evaluation> getRatings() {
		return ratings;
	}



	public void setRatings(List<Comment_evaluation> ratings) {
		this.ratings = ratings;
	}



	public Comment(Long id, String mot, Post post, User user) {
		super();
		this.id = id;
		this.mot = mot;
		this.post = post;
		this.user = user;
	}
	



	public Comment(Long id, String mot) {
		super();
		this.id = id;
		this.mot = mot;
	}



	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMot() {
		return mot;
	}


	public void setMot(String mot) {
		this.mot = mot;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", mot=" + mot + ", post=" + post + ", user=" + user + "]";

	}

}
