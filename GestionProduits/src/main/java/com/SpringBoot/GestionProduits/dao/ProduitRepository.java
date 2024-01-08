package com.SpringBoot.GestionProduits.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.SpringBoot.GestionProduits.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

	List<Produit> findByNomContains(String mc);
	
	//@Query("select p from Produit p where p.categorie.id = :id")
	//List<Produit> rechercheParCategorie(@Param("idc") int id);
}
