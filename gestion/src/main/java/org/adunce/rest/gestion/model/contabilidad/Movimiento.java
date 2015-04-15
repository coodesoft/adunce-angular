package org.adunce.rest.gestion.model.contabilidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Movimiento {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Cuenta debe;
	
	@ManyToOne
	private Cuenta haber;
	
	private Double monto;
	
	
}
