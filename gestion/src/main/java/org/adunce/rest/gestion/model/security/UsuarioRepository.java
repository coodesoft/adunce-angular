package org.adunce.rest.gestion.model.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	List<Usuario> findByUsuario(String userName);
	
	Usuario findOneByEmail(String email);
	
}
