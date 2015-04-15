package org.adunce.rest.gestion.model.contabilidad;

public enum TipoCuenta {

	ACTIVO("activo"), 
	PASIVO("pasivo"), 
	REG_ACTIVO("reg_activo"), 
	REG_PASIVO("reg_pasivo"), 
	PATRIMONIO("patrimonio");
	
	
	private String tipo;
	
	private TipoCuenta(String tipo){
		this.tipo=tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
