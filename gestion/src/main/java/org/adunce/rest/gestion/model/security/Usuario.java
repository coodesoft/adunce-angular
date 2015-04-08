package org.adunce.rest.gestion.model.security;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario implements UserDetails{
	/**
	 * Nombre de usuario
	 */
	@Id
	private String username;
	
	private Boolean enabled;
	
	/**
	 * Contraseña de acceso al sistema
	 * Hash
	 */
	private String password;
	
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
	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private Rol rol;
	
	/**
	 * Foto
	 */
	private byte[] foto;
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Usuario() {
	}

	public Usuario(String usuario, String contrasenia, Date acceso, String email) {
		this.username = usuario;
		this.password = contrasenia;
		this.acceso = acceso;
		this.email=email;
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
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}