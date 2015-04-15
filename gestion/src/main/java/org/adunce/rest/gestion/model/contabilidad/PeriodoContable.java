package org.adunce.rest.gestion.model.contabilidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class PeriodoContable {

	@Id
	@GeneratedValue
	public Long id;
	
	public String nombre;
	
	@ManyToOne
	private Ejercicio ejercicio;
	
}
