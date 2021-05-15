package tn.esprit.esponline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.esponline.entities.Post;
import tn.esprit.esponline.entities.Post_evaluation;

public interface Post_evaluationRepository extends CrudRepository<Post_evaluation,Long>{
	
	@Query("select max(s.value) from Post_evaluation s where s.post=:varpost")
	 public int maxrate(@Param("varpost") Post varpost);
	
	@Query("select min(s.value) from Post_evaluation s where s.post=:varpost")
	 public int minrate(@Param("varpost") Post varpost);
	
	@Query("select distinct(s.post) from Post_evaluation s")
	 public List<Post> Listpostev();

}
