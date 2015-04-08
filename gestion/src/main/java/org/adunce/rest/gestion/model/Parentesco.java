package org.adunce.rest.gestion.model;

public enum Parentesco {
	PADRE("padre"),
	MADRE("madre");
	
	private String parentesco;
	
	private Parentesco(String parentesco){
		this.parentesco=parentesco;
	}

	public String getParentesco() {
		return parentesco;
	}
	
}
