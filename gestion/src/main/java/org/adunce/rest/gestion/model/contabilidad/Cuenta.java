package org.adunce.rest.gestion.model.contabilidad;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cuenta {

	@Id
	private String id;
	
	private TipoCuenta tipoCuenta;
	
}
