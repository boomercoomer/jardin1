package tn.esprit.esponline.frontcontroller;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import tn.esprit.esponline.entities.Comment;
import tn.esprit.esponline.entities.Comment_evaluation;
import tn.esprit.esponline.entities.Post;
import tn.esprit.esponline.entities.Post_evaluation;
import tn.esprit.esponline.services.CommentServiceImpl;
import tn.esprit.esponline.services.IPostService;

@Scope(value = "session")
@Controller(value = "postFController")
@ELBeanName(value = "postFController")
@Join(path = "/welcomea", to = "/welcomea.jsf")
public class PostJsfControl {
	
	@Autowired
	IPostService ipService;
	
	@Autowired
	CommentServiceImpl commentService ;
	
	@Autowired
	UserController userJsfControl;
	
	
	
	private long userid;
	private String typesearched;
	private String photo;
	private String title;
	private String description;
	private Date creation_date;
	private long postIdToBeUpdated;
	private List<Post> posts;
	private List<Post> list ;
	private List<Post> list1 ;
	private List<Post> list2 ;
	private List<Comment> mylist ;
	private List<Comment> allcomm ;
	private List<Comment> pertcomm ;
	private List<Post> postevaluated =  Collections.EMPTY_LIST ;
	
	
	private long pidselected ;
	private List<Comment> comments;
	private List<Post_evaluation> ratings;
	///comment///
	private String mot;
	private long commentIdToBeUpdated;
	//comment evaluation 
	

	private String LImageURL = "/resources/images/L.png";
	private String DImageURL = "/resources/images/D.jpg";
	private String HImageURL = "/resources/images/H.jpg";
	private String SImageURL = "/resources/images/S.jpg";
	private String MImageURL = "/resources/images/M.png";
	private String RImageURL = "/resources/images/R.jpg";


	
	//rating///
	private int rating1;   

	
	
	
	//getters and setters 
	
	
	public String getPhoto() {
		return photo;
	}
	
	



	public String getRImageURL() {
		return RImageURL;
	}

	public void setRImageURL(String rImageURL) {
		RImageURL = rImageURL;
	}

	public String getLImageURL() {
		return LImageURL;
	}

	public void setLImageURL(String lImageURL) {
		LImageURL = lImageURL;
	}

	public String getDImageURL() {
		return DImageURL;
	}

	public void setDImageURL(String dImageURL) {
		DImageURL = dImageURL;
	}

	public String getHImageURL() {
		return HImageURL;
	}

	public void setHImageURL(String hImageURL) {
		HImageURL = hImageURL;
	}

	public String getSImageURL() {
		return SImageURL;
	}

	public void setSImageURL(String sImageURL) {
		SImageURL = sImageURL;
	}

	public String getMImageURL() {
		return MImageURL;
	}

	public void setMImageURL(String mImageURL) {
		MImageURL = mImageURL;
	}

	public int getRating1() {
		return rating1;
	}
	public void setRating1(int rating1) {
		this.rating1 = rating1;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	
	
	public IPostService getIpService() {
		return ipService;
	}





	public void setIpService(IPostService ipService) {
		this.ipService = ipService;
	}





	public CommentServiceImpl getCommentService() {
		return commentService;
	}





	public void setCommentService(CommentServiceImpl commentService) {
		this.commentService = commentService;
	}





	public UserController getUserJsfControl() {
		return userJsfControl;
	}





	public void setUserJsfControl(UserController userJsfControl) {
		this.userJsfControl = userJsfControl;
	}




	public long getUserid() {
		return userid;
	}





	public void setUserid(long userid) {
		this.userid = userid;
	}





	public List<Post> getList1() {
		return list1;
	}



	public void setList1(List<Post> list1) {
		this.list1 = list1;
	}



	public List<Post> getList2() {
		return list2;
	}





	public void setList2(List<Post> list2) {
		this.list2 = list2;
	}





	public List<Comment> getPertcomm() {
		return pertcomm;
	}





	public void setPertcomm(List<Comment> pertcomm) {
		this.pertcomm = pertcomm;
	}





	public List<Comment> getMylist() {
		return mylist;
	}





	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}





	public void setList(List<Post> list) {
		this.list = list;
	}





	public void setAllcomm(List<Comment> allcomm) {
		this.allcomm = allcomm;
	}





	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}





	public String getTypesearched() {
		return typesearched;
	}
	public void setTypesearched(String typesearched) {
		this.typesearched = typesearched;
	}
	public long getPostIdToBeUpdated() {
		return postIdToBeUpdated;
	}
	public void setPostIdToBeUpdated(long postIdToBeUpdated) {
		this.postIdToBeUpdated = postIdToBeUpdated;
	}
	public PostJsfControl( String title, String description,String photo,
			Date creation_date, List<Comment> comments, List<Post_evaluation> ratings) {
		super();
		
		this.photo = photo;
		this.title = title;
		this.description = description;
		this.creation_date = creation_date;
		this.comments = comments;
		this.ratings = ratings;
	}
	public PostJsfControl() {
		super();
	}
	
	
	
	public long getCommentIdToBeUpdated() {
		return commentIdToBeUpdated;
	}
	public void setCommentIdToBeUpdated(long commentIdToBeUpdated) {
		this.commentIdToBeUpdated = commentIdToBeUpdated;
	}
	public List<Comment> getComments() {
		
		return comments;
	}
	public List<Comment> getLMylist() {
		return mylist;
	}
	public void setMylist(List<Comment> mylist) {
		this.mylist = mylist;
	}

	


	public String getMot() {
		return mot;
	}
	public void setMot(String mot) {
		this.mot = mot;
	}
	public long getPidselected() {
		return pidselected;
	}
	public void setPidselected(long pidselected) {
		this.pidselected = pidselected;
	}
	public IPostService getIpostService() {
		return ipService;
	}
	public void setIPostService(IPostService ipService) {
		this.ipService = ipService;
	}
	/**************************************************************************************************
	  *****************                  CRUD Post                    ********************
	 ***************************************************************************************************/
	public void handleException (Throwable exception){
	    String message="";
	    if (exception instanceof ApplicationError){
	        message = ""+ exception.getMessage();
	    }
	    
	    
	    FacesMessage facesMessage = new FacesMessage(message);
	    FacesContext.getCurrentInstance().addMessage(null,  facesMessage);
	}	
	

public void ajouterPost(){
Post p = new Post(title, description,photo, creation_date) ;
Post subexists = ipService.test(p.getPhoto(), p.getDescription());


if (subexists != null) {
	try{	
	throw new ApplicationError("This subject exists already ");
    } catch (Throwable t){
        handleException(t);
    }
    }
          
else {
	ipService.addPost(p, userid);
	 
}
}


public List<Post> getPosts() {
	posts = ipService.myy();
	return posts;
}

public void deletePost(long postId)
{
	ipService.deletePost(postId);
}

public void modifier(Post post)
{
this.setPostIdToBeUpdated(post.getId());
this.setTitle(post.getTitle());
this.setPhoto(post.getPhoto());
this.setDescription(post.getDescription());
this.setCreation_date(post.getCreation_date());

}

public void mettreAjourPost(){
	Post e = new Post(postIdToBeUpdated, title, description,photo, creation_date) ;

	ipService.addpost(e);
}

/**************************sub à la une**********************************************/
	
public List<Post> getList() {
	 list = ipService.post();
return list;
}

	

/**************************************************************************************************
 *****************      CRUD COMMENTS      ********************
***************************************************************************************************/
	
public List<Comment> showlist(long postId) {
mylist = commentService.list(postId);
comments=mylist;
if (mylist.size()==0) {
	
	try{	
		throw new ApplicationError("There's no comment related to this post ! ");
	    } catch (Throwable t){
	        handleException(t);
	    }
}
return mylist ;
}


//////////////////Dictionnaire mots interdits///////////////////////

public void addComment(long postId) {
	Comment u = new Comment(mot);
	String msg = commentService.addComment(u,userJsfControl.getAuthenticatedUser().getId(),postId);

	try{	
		throw new ApplicationError(msg);
	    } catch (Throwable t){
	        handleException(t);
	    }
	
    }

public void deleteComment( long commentId) {
	commentService.deleteComment(commentId);

}
////all my comments////
public List<Comment> getAllcomm() {
allcomm = commentService.mylist(userJsfControl.getAuthenticatedUser().getId());
return allcomm ;

}

public void modifiercomm(Comment comment)
{
this.setCommentIdToBeUpdated(comment.getId());
this.setMot(comment.getMot());

}

public void mettreAjourcomment(){
	Comment e = new Comment(commentIdToBeUpdated, mot);
long id = commentService.findbyid(commentIdToBeUpdated).getPost().getId();
	commentService.addComment(e,userJsfControl.getAuthenticatedUser().getId(),id);
}


/*************************************Post Rating***************************************************/
	
public void Rate(long postId) {
	ipService.addrate(rating1, postId);
	if(true) {
	try{	
		throw new ApplicationError("You rated:" + rating1);
	    } catch (Throwable t){
	        handleException(t);
	    }
	}
   }

public int maxrate(long id) {

	return ipService.maxrate(id) ; 
	
	
}

public int minrate(long id) {
	
	return ipService.minrate(id) ; 
	
	
}
	

public List<Post> getPostevaluated() {
	postevaluated = ipService.postevaluated();
	if (postevaluated.size()==0) {
		
		try{	
			throw new ApplicationError("There's no comment related to this post ! ");
		    } catch (Throwable t){
		        handleException(t);
		    }
	
	
}
	return postevaluated;
}


public void setPostevaluated(List<Post> postevaluated) {
	this.postevaluated = postevaluated;
}





/*************************************comment evaluation***************************************************/
	
//Like : 
public void addLevaluation(Long commentId) {
	Comment_evaluation u = new Comment_evaluation();

	u.setL(1);
	commentService.addEv(u, commentId);
	if(true) {
		try{	
			throw new ApplicationError("You gived a like !");
		    } catch (Throwable t){
		        handleException(t);
		    }
	}
    }

//Dislike:
public void addDevaluation(long commentId) {
	Comment_evaluation v = new Comment_evaluation();

	v.setD(1);
	commentService.addEv(v, commentId);
	if(true) {
		try{	
			throw new ApplicationError("You gived a dislike !");
		    } catch (Throwable t){
		        handleException(t);
		    }
	}
  }

//Happy : 
public void addHevaluation(long commentId) {
	Comment_evaluation u1 = new Comment_evaluation();

	u1.setH(1);
	commentService.addEv(u1, commentId);
	if(true) {
		try{	
			throw new ApplicationError("evaluation saved : Happy ");
		    } catch (Throwable t){
		        handleException(t);
		    }
	}
  }
//Sad : 
public void addSevaluation(long commentId) {
	Comment_evaluation v1 = new Comment_evaluation();

	v1.setS(1);
	commentService.addEv(v1, commentId);
	if(true) {
		try{	
			throw new ApplicationError("evaluation saved : Sad ");
		    } catch (Throwable t){
		        handleException(t);
		    }
	}
  }
//Medium : 
public void addMevaluation(long commentId) {
	Comment_evaluation v2 = new Comment_evaluation();

	v2.setM(1);
	commentService.addEv(v2, commentId);
	if(true) {
		try{	
			throw new ApplicationError("evaluation saved : Medium ");
		    } catch (Throwable t){
		        handleException(t);
		    }
	}
  }
  
/*************************************get evaluations***************************************************/


public String getLike(long commentId) {
	Comment_evaluation c = commentService.Evaluation(commentId) ;
if (c == null) {
	
	return "0";
	}
else {
	return String.valueOf(c.getL()) ;
			 
}
  }

public String getDislike(long commentId) {
	
	Comment_evaluation c = commentService.Evaluation(commentId) ;
if (c == null) {
	
	return "0";
	}
else {
	return String.valueOf(c.getD()) ;
			 
}
  }
public String getHappy(long commentId) {
	
	Comment_evaluation c = commentService.Evaluation(commentId) ;
if (c == null) {
	
	return "0";
	}
else {
	return String.valueOf(c.getH()) ;
			 
}
  }
public String getSad(long commentId) {
	
	Comment_evaluation c = commentService.Evaluation(commentId) ;
if (c == null) {
	
	return "0";
	}
else {
	return String.valueOf(c.getS()) ;
			 
}
  }
public String getMedium(long commentId) {
	
	Comment_evaluation c = commentService.Evaluation(commentId) ;
if (c == null) {
	
	return "0";
	}
else {
	return String.valueOf(c.getM()) ;
			 
}
  }


/*************************************comments most pertinent ***************************************************/
	
public List<Comment> getpertcomm() {
pertcomm = commentService.Bestcomments();
return pertcomm ;

}



/**************************redirection*********************************************/
public String ToSubMan() {
	String navigateTo = "null";
	
	navigateTo = "/pages/forum/admin/gererSujet.xhtml?faces-redirect=true";
	return navigateTo;
}
public String ToSub() {
	String navigateTo = "null";
	
	navigateTo = "/welcomec.xhtml?faces-redirect=true";
	return navigateTo;
}
public String ToRech() {
	String navigateTo = "null";
	
	navigateTo = "/recherche.xhtml?faces-redirect=true";
	return navigateTo;
}
public String ToLaUne() {
	String navigateTo = "null";
	
	navigateTo = "/ALaUne.xhtml?faces-redirect=true";
	return navigateTo;
}
public String ToInterest() {
	String navigateTo = "null";
	
	navigateTo = "/findInterested.xhtml?faces-redirect=true";
	return navigateTo;
}
public String ToAll() {
	String navigateTo = "null";
	
	navigateTo = "/allPosts.xhtml?faces-redirect=true";
	return navigateTo;
}
public String MyComm() {
	String navigateTo = "null";
	
	navigateTo = "/myComments.xhtml?faces-redirect=true";
	return navigateTo;
}

public String PertComm() {
	String navigateTo = "null";
	
	navigateTo = "/pertinentComments.xhtml?faces-redirect=true";
	return navigateTo;
}
public String ToRatings() {
	String navigateTo = "null";
	
	navigateTo = "/ratings.xhtml?faces-redirect=true";
	return navigateTo;
}




}
