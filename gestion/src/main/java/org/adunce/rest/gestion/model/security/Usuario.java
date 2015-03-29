package org.adunce.rest.gestion.model.security;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails{
	/**
	 * Nombre de usuario
	 */
	@Id
	private String usuario;
	
	/**
	 * Contraseña de acceso al sistema
	 * Hash
	 */
	private String contrasenia;
	
	/**
	 * Ultima fecha de acceso
	 */
	private Date acceso;
	
	/**
	 * Email
	 */
	private String email;
	
	/**
	 * Rol del usuario
	 */
	@Enumerated(EnumType.STRING)
	private Rol rol;
	
	public Usuario() {
	}

	public Usuario(String usuario, String contrasenia, Date acceso, String email) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.acceso = acceso;
		this.email=email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Date getAcceso() {
		return acceso;
	}

	public void setAcceso(Date acceso) {
		this.acceso = acceso;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return getContrasenia();
	}

	@Override
	public String getUsername() {
		return getUsuario();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}