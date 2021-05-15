package tn.esprit.esponline.services;

import java.util.List;
import tn.esprit.esponline.entities.Post;

import org.springframework.stereotype.Service;


@Service
public interface IPostService {
	
	 Post addpost(Post post);
	 Post addPost(Post post,long userid);
	 Post updatePost(Post post);
	 void affecterPostAUser(long postId,long userId);
	 void deletePost(long id) ;
	 List<Post> myy();
	 Post findbyid(long id);
	 List<Post> post();
	 Post test(String photo , String description);
	  Post listbytitle(String title);
	  List<Post> findbyPhoto(String photo);
	  List<Post> findbyType(String type);
	  List<Long> notcommented() ;
	  void autodeletePost() ;
	  void addrate(int value,long id);
	  int maxrate(long id) ;
	  int minrate(long id);
	  List<Post> postevaluated();

}
