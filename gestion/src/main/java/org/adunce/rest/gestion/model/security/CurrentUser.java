package org.adunce.rest.gestion.model.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {

	private Usuario user;
	
	public CurrentUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities,Usuario user) {
		super(username, password, authorities);
		this.user=user;
	}
	
	public Usuario getUser(){
		return user;
	}
	
	public String getId(){
		return user.getUsuario();
	}
	
	public Rol getRole(){
		return user.getRol();
	}

}
