package tn.esprit.esponline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.esponline.entities.Post;

@Repository
public interface PostRepository extends CrudRepository<Post,Long>{
	
	 Post findByPhotoAndDescription(String photo,String description);
	 @Query("select s from Post s where CURRENT_DATE - s.creation_date <=:mydate")
	 public List<Post> post(@Param("mydate") Double mydate);
	 
	 Post findByTitle(String title);
	 
	 List<Post> findByPhoto(String photo);
	
	 /////////supp auto post//////////
	 @Query("select s.id from Post s where CURRENT_DATE - s.creation_date >=:mydate ")
	 public List<Long> posts(@Param("mydate") Double mydate);
	 
	//list of id_post in class comment
	 @Query("select s.id from Post s join s.comments c where c.post=s")
	 public List<Long> list1();

	
}
