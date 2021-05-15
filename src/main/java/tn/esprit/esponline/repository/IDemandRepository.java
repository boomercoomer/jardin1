package tn.esprit.esponline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.esponline.entities.Demande;

@Repository
public interface IDemandRepository  extends JpaRepository<Demande, Integer>{

}
