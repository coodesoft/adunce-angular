package org.adunce.rest.gestion.services;

import org.adunce.rest.gestion.model.security.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CurrentUserDetailsService implements UserDetailsService {

	private final UserService userService;
	
	@Autowired
	public CurrentUserDetailsService(UserService userService){
		this.userService = userService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Usuario user = userService.getUserByUsuario(username).get();
		if (user==null){
			throw new UsernameNotFoundException(String.format("Usuario %s no existe.", username));
		}
		return user;
	}

}
