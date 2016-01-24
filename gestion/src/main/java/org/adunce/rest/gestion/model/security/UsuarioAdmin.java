package org.adunce.rest.gestion.model.security;

import java.util.Date;

public class UsuarioAdmin extends Usuario {

	private String nombre;
	
	private String apellido;
	
	private String secretaria;
	
	public UsuarioAdmin(String nombre, String apellido, String secretaria) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.secretaria = secretaria;
	}

	public UsuarioAdmin() {
		super();
	}

	public UsuarioAdmin(String usuario, String contrasenia, Date acceso,
			String email) {
		super(usuario, contrasenia, acceso, email);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(String secretaria) {
		this.secretaria = secretaria;
	}
	
}
