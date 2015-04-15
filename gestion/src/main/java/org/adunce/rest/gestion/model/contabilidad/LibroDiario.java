package org.adunce.rest.gestion.model.contabilidad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LibroDiario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;

	@OneToMany
	List<AsientoDiario> asientos;
	
}
