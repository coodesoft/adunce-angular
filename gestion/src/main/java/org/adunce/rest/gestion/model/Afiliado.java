package org.adunce.rest.gestion.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.adunce.rest.gestion.model.security.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Afiliado extends Usuario{

	@ManyToOne(optional=true)
	@JsonIgnore
	private Grupo grupo;

	private Boolean activo;
	
	public Afiliado() {
		super();
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}
