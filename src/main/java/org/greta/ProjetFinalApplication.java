package org.greta;

import java.util.Random;
import java.util.stream.Stream;

import org.greta.dao.CategorieRepository;
import org.greta.dao.ProduitRepository;
import org.greta.entities.Categorie;
import org.greta.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class ProjetFinalApplication implements CommandLineRunner{
	
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ProjetFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		repositoryRestConfiguration.exposeIdsFor(Produit.class,Categorie.class);
	
		categorieRepository.save(new Categorie(null,"Smartphone","nouveau smartaphone",null));
		categorieRepository.save(new Categorie(null,"Electroménager","nouveau electromenager",null));
		categorieRepository.save(new Categorie(null,"Cuisine Cuisson","nouveau cuisine",null));
		categorieRepository.save(new Categorie(null,"Informatique Tablette","nouveau informatique",null));
		categorieRepository.save(new Categorie(null,"Meuble","nouveau smartaphone",null));
		categorieRepository.save(new Categorie(null,"Décoration","nouveau electromenager",null));
		categorieRepository.save(new Categorie(null,"Litterie","nouveau cuisine",null));
		categorieRepository.save(new Categorie(null,"Sport","nouveau informatique",null));
		categorieRepository.save(new Categorie(null,"Jeux Vidéo","nouveau electromenager",null));
		categorieRepository.save(new Categorie(null,"Bébé","nouveau cuisine",null));
		categorieRepository.save(new Categorie(null,"Mode Bagage","nouveau informatique",null));
		
		
		Random rnd=new Random();
		categorieRepository.findAll().forEach(c->{
			
			for (int i = 0; i <3; i++) {
				
				Produit p=new Produit();
				p.setNom(RandomString.make(5));
				p.setPrix(100+rnd.nextInt(1000));
				p.setQuantite(100+rnd.nextInt(1000));
				p.setDescription(RandomString.make(25));
				p.setDisponible(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setPhoto("p10.png");
				p.setCategorie(c);
				produitRepository.save(p);
			}
		});

	}

}
