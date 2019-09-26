package org.greta.web;

import java.nio.file.Files;

import java.nio.file.Paths;

import org.greta.dao.ProduitRepository;
import org.greta.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;

	public ProduitController(ProduitRepository produitRepository) {
		this.produitRepository = produitRepository;
	}

	@GetMapping(path="/photoProduit/{idProduit}",produces=MediaType.IMAGE_PNG_VALUE)
	public byte[] getPhoto(@PathVariable("idProduit")Long idProduit) throws Exception{
		 Produit p= produitRepository.findById(idProduit).get();
		 System.out.println(p);
		 return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/produits/"+p.getPhoto()));
	}

	@PostMapping(path="/uploadPhoto/{idProduit}")
	public void uploadPhoto(MultipartFile file,@PathVariable("idProduit") Long idProduit) throws  Exception{
            Produit p=produitRepository.findById((idProduit)).get();
            System.out.println(p);
            System.out.println(p);
            p.setPhoto(idProduit+".png");
            Files.write(Paths.get(System.getProperty("user.home")+"/ecom/produits/"+p.getPhoto()),file.getBytes());
            produitRepository.save(p);
            
	}
	

}
