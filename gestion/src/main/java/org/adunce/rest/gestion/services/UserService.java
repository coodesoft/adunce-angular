package org.adunce.rest.gestion.services;

import java.util.Collection;

import org.adunce.rest.gestion.model.security.Usuario;

import com.google.common.base.Optional;

public interface UserService {

	Optional<Usuario> getUserByUsuario(String usuario);
	
	Optional<Usuario> getUserByEmail(String email);
	
	Collection<Usuario> getAllUsuarios();
	
}
