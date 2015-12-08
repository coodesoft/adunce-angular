package org.adunce.rest.gestion.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.adunce.rest.gestion.model.security.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Afiliado extends Usuario{

	@ManyToOne(optional=true)
	@JsonIgnore
	private Grupo grupo;
	
	private String nombre;
	
	private String apellido;
	
	private Date fechaAfiliacion;
	
	private String correoElectronico;
	
	private Boolean familiarACargo;
	
	private Boolean tieneVehiculo;
	
	private String cuil;
	
	private String legajo;
	
	@OneToMany
	private List<Hijo> hijos;
	
	public Afiliado() {
		super();
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
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

	public Date getFechaAfiliacion() {
		return fechaAfiliacion;
	}

	public void setFechaAfiliacion(Date fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Boolean getFamiliarACargo() {
		return familiarACargo;
	}

	public void setFamiliarACargo(Boolean familiarACargo) {
		this.familiarACargo = familiarACargo;
	}

	public Boolean getTieneVehiculo() {
		return tieneVehiculo;
	}

	public void setTieneVehiculo(Boolean tieneVehiculo) {
		this.tieneVehiculo = tieneVehiculo;
	}

	public List<Hijo> getHijos() {
		return hijos;
	}

	public void setHijos(List<Hijo> hijos) {
		this.hijos = hijos;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	
	
}
