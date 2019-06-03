package org.greta.dao;


import org.greta.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
@RepositoryRestController
public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
