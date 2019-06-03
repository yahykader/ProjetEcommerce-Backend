package org.greta.dao;

import org.greta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
@RepositoryRestController
public interface ClientRepository extends JpaRepository<User,Long>{

}
