package tn.esprit.esponline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.esponline.entities.Comment;
import tn.esprit.esponline.entities.Post;
import tn.esprit.esponline.entities.User;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long>{

	//list of comments
		 @Query("select s from Comment s where s.post=:post")
		 public List<Comment> list(@Param("post") Post post);
		 
		 
		 //list of user's comments of the subject
		 @Query("select s from Comment s where s.user=:user")
		 public List<Comment> mylist(@Param("user") User user);
		 
}
