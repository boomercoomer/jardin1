package tn.esprit.esponline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.esponline.entities.Formulaire;

@Repository
public interface IFormulaireRepository extends JpaRepository<Formulaire, Integer> {

}
