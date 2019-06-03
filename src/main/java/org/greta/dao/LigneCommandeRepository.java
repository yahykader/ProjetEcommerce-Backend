package org.greta.dao;

import org.greta.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
@RepositoryRestController
public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long>{

}
