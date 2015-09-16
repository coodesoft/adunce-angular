package org.adunce.rest.gestion.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hijo {

	@Id
	private String dni;
	
	private Afiliado pariente;
	
	private Parentesco parentesco;
	
	private Date fechaNacimiento;
	
	private Sexo sexo;

	public Hijo() {
		super();
	}

	public String getId() {
		return dni;
	}

	public void setId(String id) {
		this.dni = id;
	}

	public Afiliado getPariente() {
		return pariente;
	}

	public void setPariente(Afiliado pariente) {
		this.pariente = pariente;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
}
