package tn.esprit.esponline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DictionaryRepository extends CrudRepository<tn.esprit.esponline.entities.Dictionary,String> {

	@Query("select d.mot from Dictionary d")
	 public List<String> dictionaryList();
	
}
