package tn.esprit.esponline.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Post implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String photo;
	@Column
	private String type;	
	@Column
	private String description;
	@Column
	private String title;
	
	@Temporal (TemporalType.DATE)
	private Date creation_date;
	
	@ManyToOne
	private User user;

	/*@ManyToOne
	private kindergarten kindergarten;*/
	
	@OneToMany(mappedBy="post",cascade=CascadeType.REMOVE)
	private List<Comment> comments;
	
	@OneToMany(mappedBy="post")
    private List<Post_evaluation> ratings;

	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    public Post(Long id, String photo, String description, String title, Date creation_date) {
		super();
		this.id = id;
		this.photo = photo;
		this.description = description;
		this.title = title;
		this.creation_date = creation_date;
	}


	public Post( String description, String title,String photo, Date creation_date) {
		super();
		this.photo = photo;
		this.description = description;
		this.title = title;
		this.creation_date = creation_date;
	}


	@Lob
    @Column(columnDefinition="MEDIUMBlob")
	public String getPhoto() {
		return photo;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getCreation_date() {
		return creation_date;
	}



	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}



	public List<Post_evaluation> getRatings() {
		return ratings;
	}



	public void setRatings(List<Post_evaluation> ratings) {
		this.ratings = ratings;
	}



	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	/*public kindergarten getKindergarten() {
		return kindergarten;
	}


	public void setKindergarten(kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}*/


	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", photo=" + photo + ", description=" + description + ", creation_date="
				+ creation_date  +  "]";
	}
	
	
	
	

}
