package com.SpringBoot.GestionProduits.service;

import java.util.List;

import com.SpringBoot.GestionProduits.entities.Categorie;
import com.SpringBoot.GestionProduits.entities.Produit;

public interface IgestionCategorie {

	public void addCategorie(Categorie c); 
	public List<Categorie> getAllCategories();
	public Categorie getCategorie(int id);
	public void deleteCategorie(int id);
	public List<Produit> getProductsByCategorie(int idc);
}
