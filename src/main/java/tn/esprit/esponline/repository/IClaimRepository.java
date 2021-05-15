package tn.esprit.esponline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.esponline.entities.Claim;

@Repository
public interface IClaimRepository extends JpaRepository<Claim, Integer> {

}
