package com.SpringBoot.GestionProduits.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.SpringBoot.GestionProduits.entities.Produit;

public interface IgestionProduit {

	void saveProduit(Produit p, MultipartFile mf) throws IOException;
	List<Produit> getAllProducts();
	Produit getProduct(int id);
	List<Produit> getProductsBMC(String mc);
	void deleteProduct(Integer id) throws IOException;
	void updateProduct(Produit p);
	String saveImage(MultipartFile mf)throws IOException ;
	void supprimerImage(Integer idProduit) throws IOException;
	byte[] getImage(int id) throws IOException;
    


}
