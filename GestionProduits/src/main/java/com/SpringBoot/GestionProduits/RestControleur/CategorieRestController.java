package com.SpringBoot.GestionProduits.RestControleur;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.SpringBoot.GestionProduits.entities.Categorie;
import com.SpringBoot.GestionProduits.entities.Produit;
import com.SpringBoot.GestionProduits.service.IgestionCategorie;

@CrossOrigin("*")
@RestController
@RequestMapping("/restapicategorie")
public class CategorieRestController {

/*	@Autowired
	IgestionCategorie sc;
	
	@GetMapping("/all")
	public List<Categorie> getAllCategories() {
		return sc.getAllCategories();
	}
	
	@GetMapping("/getcategorie/{id}")
	public Categorie getCategorie(@PathVariable int id) {
		return sc.getCategorie(id);
	}
	
	@PostMapping("/add")
	public void addCategorie(Categorie c) {
	sc.addCategorie(c);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCategorie(@PathVariable int id) throws IOException {
		sc.deleteCategorie(id);
	}
	
	@GetMapping("/all")
	public List<Produit> getProductsByCategorie(int idc) {
		return sc.getProductsByCategorie(idc);
	}
	*/
	
	
}
