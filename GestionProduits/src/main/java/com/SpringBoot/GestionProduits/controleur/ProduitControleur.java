package com.SpringBoot.GestionProduits.controleur;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.SpringBoot.GestionProduits.dao.CategorieRepository;
import com.SpringBoot.GestionProduits.entities.Produit;
import com.SpringBoot.GestionProduits.service.ServiceCategorie;
import com.SpringBoot.GestionProduits.service.ServiceProduit;


@Controller
@RequestMapping("/apiproduit")
public class ProduitControleur {
	
	@Autowired
	ServiceProduit sp;
	@Autowired
	ServiceCategorie sc;
	@Autowired
	CategorieRepository cr ;
	
	
	/**************    Get All  **************/
	@GetMapping("/all")
	public String getAllProduits(Model m) {
		List<Produit>liste=sp.getAllProducts();
		m.addAttribute("liste", liste);
		m.addAttribute("categories",cr.findAll());
		//m.addAttribute("categories", sc.getAllCategories());
		m.addAttribute("categorie", "Toutes les categories");
		return "produits";
	}
	/**************    Find BMC  **************/
	@GetMapping("/produitmc")
	public String getProductBMC(@RequestParam String mc,Model m)
	{
		List<Produit>liste=sp.getProductsBMC(mc);
		m.addAttribute("liste",liste);
		return "produits";
	}
	/**************    Delelte  
	 * @throws IOException **************/
	@GetMapping("/supprimerproduit/{id}")
	public String deleteProduct( @PathVariable int id ) throws IOException 
	{
		sp.deleteProduct(id);
		return "redirect:/apiproduit/all";
	}
	/**************    ADD  **************/
	@GetMapping("/ajouterproduit")
	public String ajouterProduit(Model m)
	{
		m.addAttribute("categories", sc.getAllCategories());
		return "ajouterproduit";
	}
	/**************    Save  **************/
	@PostMapping("/saveproduit")
	public String saveProduit(@ModelAttribute Produit p,@RequestParam("file") MultipartFile mf,Model m) throws IOException
	{
		Integer id=p.getId();
		sp.saveProduit(p, mf);
		if (id!=null)//modification
		{
			return "redirect:/apiproduit/all";

		}
		else //ajout
		{
			m.addAttribute("message","Ajout Avec Succes");
			m.addAttribute("categories", sc.getAllCategories());
			return "ajouterproduit";
		}
	}
	
	/**************    Update  **************/
	@GetMapping("/modifierproduit/{id}")
	public String modifierProduit(Model m, @PathVariable("id") int id) 
	{
		m.addAttribute("categories", sc.getAllCategories());
		m.addAttribute("produit", sp.getProduct(id));
		return "ajouterproduit";
	}

	
	/**************    Get Product By Category  **************/

	@GetMapping("/produitParCategorie")
	public String getProductsByMc(@RequestParam("categorie") int idc,Model m) {
		m.addAttribute("categories", sc.getAllCategories());
		if (idc == 0) {
			m.addAttribute("liste", sp.getAllProducts());
			return "redirect:/apiproduit/all";
		}
		else {
			m.addAttribute("liste", sc.getProductsByCategorie(idc));
			m.addAttribute("categorie", cr.getById(idc).getNom());
			return "produits";
		}
	}
	
}
