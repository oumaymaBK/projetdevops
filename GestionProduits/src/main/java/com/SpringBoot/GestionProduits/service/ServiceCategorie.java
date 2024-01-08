package com.SpringBoot.GestionProduits.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBoot.GestionProduits.dao.CategorieRepository;
import com.SpringBoot.GestionProduits.entities.Categorie;
import com.SpringBoot.GestionProduits.entities.Produit;

@Service
public class ServiceCategorie implements IgestionCategorie {

	private CategorieRepository cr ;
	
	public ServiceCategorie(CategorieRepository cr) {
		this.cr = cr;
	}

	@Override
	public void addCategorie(Categorie c) {
		cr.save(c);
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Categorie getCategorie(int id) {
		// TODO Auto-generated method stub
		return cr.findById(id).get();
	}

	@Override
	public void deleteCategorie(int id) {
		cr.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Produit> getProductsByCategorie(int idc) {
		// TODO Auto-generated method stub
		return cr.getById(idc).getListe();
	}



}
