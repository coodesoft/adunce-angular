package org.adunce.rest.gestion.model.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	List<Usuario> findByUsername(String userName);
	
	Usuario findOneByEmail(String email);
	
}
