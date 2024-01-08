package com.SpringBoot.GestionProduits.RestControleur;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SpringBoot.GestionProduits.entities.Produit;
import com.SpringBoot.GestionProduits.service.IgestionProduit;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController

@RequestMapping("/restapiproduit")
public class ProduitRestController {
	@Autowired
	IgestionProduit sp;


@GetMapping("/all")
public List<Produit> getAllProducts() {
	return sp.getAllProducts();
}

@GetMapping("/getProduct/{id}")
public Produit getProduct(@PathVariable("id") Integer id) {
	return sp.getProduct(id);
}


@GetMapping("/chercherByMC/{mc}") 
	public List<Produit> getProducts(@PathVariable("mc") String mot){
	return sp.getProductsBMC(mot);
}

@GetMapping(path = "/getImage/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
public byte[] getImage(@PathVariable("id") int id) throws IOException {
	return sp.getImage(id);
}

@PostMapping("/add")
public void saveProduct(@RequestParam("produit") String p, @RequestParam("file") MultipartFile mf) throws IOException {
	Produit pp = new ObjectMapper().readValue(p, Produit.class);
	sp.saveProduit(pp, mf);
}

@DeleteMapping("/delete/{id}")
public void deleteProduct(@PathVariable int id) throws IOException {
	System.out.println("okkkkkkkkkkkkkkkkkkkkkkkk");
	sp.deleteProduct(id);
}


@PutMapping("/update")
public void update(@RequestParam("produit") String p, @RequestParam("file") MultipartFile mf) throws IOException {
    saveProduct(p, mf);
}


}