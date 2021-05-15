package tn.esprit.esponline.services;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.esponline.entities.Post;
import tn.esprit.esponline.entities.Post_evaluation;
import tn.esprit.esponline.entities.User;
import tn.esprit.esponline.repository.PostRepository;
import tn.esprit.esponline.repository.Post_evaluationRepository;
import tn.esprit.esponline.repository.UserRepository;
import tn.esprit.esponline.services.IPostService;


@Service
public class PostService implements IPostService {
	
	@Autowired
	private PostRepository var;

	@Autowired
	private Post_evaluationRepository var2;
	
	@Autowired
	UserRepository urep;



	private static final Logger logger = LogManager.getLogger(PostService.class);
	
	@Override
	 public Post addpost(Post post){
			
	      //User u=urep.findById(userid).get();
	     //  post.setUser(u);
	      var.save(post) ;
	       return post;
	
	}
	@Override	
	public Post addPost(Post post,long userid){
	
	        User u=urep.findById(userid).orElse(null);
	        post.setUser(u);
			var.save(post) ;
			return post;
			
		}
	@Override
	public void affecterPostAUser(long postId,long userId)
	{
		Post p=var.findById(postId).orElse(null);
		User u=urep.findById(userId).orElse(null);
		
		p.setUser(u);
		var.save(p);
	}

	@Override
	public Post findbyid(long id){
		
			return var.findById(id).get() ;
		}

	@Override
	public List<Post> myy(){
		
		return (List<Post>)var.findAll();
			
		}

	@Override	
	public void deletePost(long id){
		    //Post p= var.findById(id).orElse(null);
		    var.deleteById(id);
		  
		
		}
	
	
	@Override	
	public Post updatePost(Post post2){
		
		Post post1 =var.findById(post2.getId()).get(); 
		post1.setPhoto(post2.getPhoto());
		post1.setDescription(post2.getDescription());
		post1.setCreation_date(post2.getCreation_date());
		post1.setTitle(post2.getTitle());
			
			var.save(post1);
			return post1;
		
		}
	@Override	
	public Post test(String photo , String description){
		Post u = var.findByPhotoAndDescription(photo, description);
			return u;
	}

	@Override	
	public List<Post> post(){
		Double mydate = (double) 3;
		return var.post(mydate);
		
		
	}

	@Override
	public Post listbytitle(String title){
		
		return var.findByTitle(title);
		
	}
	@Override
	public List<Post> findbyPhoto(String photo){
		
			return var.findByPhoto(photo);
		}
	@Override
	public List<Post> findbyType(String type){
		
			return var.findByPhoto(type);
		}


	/////////post sans interaction//////////

	@Override
	public List<Long> notcommented() {
		 List<Long> mylist = var.list1() ; //1
		 Double a = (double) 10;
		 List<Long> mylist1 = var.posts(a);  //1 2 3
		for(Long i : mylist) {
			
			if(mylist1.contains(i)) {
				mylist1.remove(i);
				
			}
		}
		
	 return mylist1 ;
	 
		  
	}

	/////////////supp auto post sans interaction///////////
	//@Scheduled(cron = "* * * * * ?")
	@Override
	 public void autodeletePost() {
		
		for(Long i : notcommented()) {
			
			var.deleteById(i);
			
		}
		
		
	}
	/////////////////////post rating /////////////////////
	public void addrate(int value,long id) {
		
		Post s = var.findById(id).get();
		Post_evaluation e = new Post_evaluation();
		e.setValue(value);
		e.setPost(s);
		var2.save(e);
		
		
	}
	/////////////////////affichage post rating /////////////////////	
	@Override
	public int maxrate(long id) {
	Post s = var.findById(id).get();
	return var2.maxrate(s);


	}
	@Override
	public int minrate(long id) {
	Post s = var.findById(id).get();
	return var2.minrate(s);


	}

	@Override
	public List<Post> postevaluated() {
		return var2.Listpostev();


	}



}
