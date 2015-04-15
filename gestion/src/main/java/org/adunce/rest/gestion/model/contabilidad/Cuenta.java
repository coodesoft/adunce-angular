package org.adunce.rest.gestion.model.contabilidad;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cuenta {

	@Id
	private String id;
	
	private TipoCuenta tipoCuenta;

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
	
}
