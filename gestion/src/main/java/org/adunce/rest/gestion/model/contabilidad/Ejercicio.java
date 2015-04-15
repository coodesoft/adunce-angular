package org.adunce.rest.gestion.model.contabilidad;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ejercicio {

	@Id
	private String id;
	
	private String descripcion;
	
}
