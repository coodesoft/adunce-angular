package org.adunce.rest.gestion.model;

public enum Sexo {
	FEMENINO("femenino"),
	MASCULINO("masculino"),
	DESCONOCIDO("desconocido");
	
	private String sexo;
	
	private Sexo(String sexo){
		this.sexo=sexo;
	}
	
}
