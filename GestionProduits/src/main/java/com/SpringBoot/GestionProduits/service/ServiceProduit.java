package com.SpringBoot.GestionProduits.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SpringBoot.GestionProduits.dao.CategorieRepository;
import com.SpringBoot.GestionProduits.dao.ProduitRepository;
import com.SpringBoot.GestionProduits.entities.Produit;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceProduit implements IgestionProduit {
	@Autowired
	ProduitRepository pr;
	CategorieRepository cr;

	@Override
	public List<Produit> getAllProducts() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Produit getProduct(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public List<Produit> getProductsBMC(String mc) {
		// TODO Auto-generated method stub
		return pr.findByNomContains(mc);
	}

	@Override
	public void deleteProduct(Integer id) throws IOException {
		if(pr.getById(id).getPhoto()!=null) {
			supprimerImage(id);
		}
		pr.deleteById(id);
	}

	@Override
	public void updateProduct(Produit p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String saveImage(MultipartFile mf) throws IOException {

		String nameFile =mf.getOriginalFilename();
		String tab[] = nameFile.split("\\.");
		String fileModif = tab[0] + "_" + System.currentTimeMillis() + "." + tab[1];
		String chemin = System.getProperty("user.dir") + "/src/main/webapp/imagesdata/";
		Path p = Paths.get(chemin, fileModif);
		Files.write(p, mf.getBytes());
		return fileModif;
	}

	@Override
	public void saveProduit(Produit p, MultipartFile mf) throws IOException {
	    String photo;
		if (!mf.getOriginalFilename().equals("")) {
			photo = saveImage(mf);
			p.setPhoto(photo);
			}
		pr.save(p);
		}
	
	@Override
	public void supprimerImage(Integer idProduit) throws IOException {
		Produit produit = pr.getById(idProduit);
		
		String chemin = System.getProperty("user.dir") + "/src/main/webapp/imagesdata/";
		Path p = Paths.get(chemin, produit.getPhoto());
		Files.delete(p);
	}

	@Override
	public byte[] getImage(int id) throws IOException {
		String nomImage=pr.findById(id).get().getPhoto();
		Path p=Paths.get(System.getProperty("user.dir") + "/src/main/webapp/imagesdata/",nomImage);
		return Files.readAllBytes(p);
	}



	
	}


