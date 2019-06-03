package org.greta.dao;

import org.greta.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.lang.String;
import java.util.List;
@RepositoryRestController
@CrossOrigin("*")
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
	@RestResource(path="/cherchermotCle")
	@Query("select p from Produit p where p.nom like :x or p.description like :x")
	public List<Produit> findProduitByNomContains(@Param("x")String mc);
	
	
	
	@RestResource(path="/produitbyCat")
	@Query("select p from Produit p where p.categorie.idCategorie = :x")
	public List<Produit> findProduitsByCategorie(@Param("x")Long idCategorie);
	
	@RestResource(path="/selectedProduit")
	@Query("select p from Produit p where p.selected=true")
	public List<Produit> findProduitBySelected();
	
	@RestResource(path="/promotionProduit")
	@Query("select p from Produit p where p.promotion=true")
	public List<Produit> findByProduitPromotion();
	
	@RestResource(path="/disponibleProduit")
	@Query("select p from Produit p where p.disponible=true")
	public List<Produit> findByProduitDisponible();
	
	
	

}
