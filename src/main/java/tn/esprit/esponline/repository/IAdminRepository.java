package tn.esprit.esponline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.esponline.entities.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer>{

}
