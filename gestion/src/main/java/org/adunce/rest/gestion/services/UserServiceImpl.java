package org.adunce.rest.gestion.services;

import java.util.Collection;

import org.adunce.rest.gestion.model.security.Usuario;
import org.adunce.rest.gestion.model.security.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

@Service("userService")
public class UserServiceImpl implements UserService{

	private final UsuarioRepository repo;
	
	@Autowired
	public UserServiceImpl(UsuarioRepository repo){
		this.repo=repo;
	}
	
	@Override
	public Optional<Usuario> getUserByUsuario(String usuario) {
		return Optional.fromNullable(repo.findOne(usuario));
	}

	@Override
	public Optional<Usuario> getUserByEmail(String email) {
		return Optional.of(repo.findOneByEmail(email));
	}

	@Override
	public Collection<Usuario> getAllUsuarios() {
		return repo.findAll(new Sort("email"));
	}

}
