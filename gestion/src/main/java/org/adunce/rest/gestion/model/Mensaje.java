package org.adunce.rest.gestion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.adunce.rest.gestion.model.security.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Mensaje {

	@Id
	@GeneratedValue
	private String id;
	
	@ManyToOne
	@JsonIgnore
	private Usuario remitente;
	
	@ManyToOne
	@JsonIgnore
	private Usuario destinatario;
	
}
