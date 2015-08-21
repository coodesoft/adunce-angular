package org.adunce.rest.gestion.model.contabilidad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Cuenta {

	@Id
	private String id;
	
	@Enumerated(EnumType.STRING)
	private TipoCuenta tipoCuenta;

	private String nombre;
	
	@ManyToOne
	@JsonIgnore
	private Cuenta padre;
	
	@OneToMany
	@JsonIgnore
	private List<Cuenta> hijos;
	
	public Cuenta() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cuenta getPadre() {
		return padre;
	}

	public void setPadre(Cuenta padre) {
		this.padre = padre;
	}

	public List<Cuenta> getHijos() {
		return hijos;
	}

	public void setHijos(List<Cuenta> hijos) {
		this.hijos = hijos;
	}
	
}
