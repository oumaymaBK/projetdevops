package com.SpringBoot.GestionProduits.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.GestionProduits.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
