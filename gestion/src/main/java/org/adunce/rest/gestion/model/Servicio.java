package org.adunce.rest.gestion.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servicio {

	@Id
	private String codigo;
	
	private String nombre;
	
	private String descripcion;
	
	private byte[] imagen;

	public Servicio() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
}
