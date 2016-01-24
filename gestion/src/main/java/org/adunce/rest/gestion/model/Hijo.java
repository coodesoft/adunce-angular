package org.adunce.rest.gestion.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Hijo {

	@Id
	@GeneratedValue
	private Long id;
	
	private String dni;
	
	@JsonIgnore
	@ManyToOne
	private Afiliado pariente;
	
	//private Parentesco parentesco;
	
	private Date fechaNacimiento;
	
	private Sexo sexo;

	public Hijo() {
		super();
	}

	public Afiliado getPariente() {
		return pariente;
	}

	public void setPariente(Afiliado pariente) {
		this.pariente = pariente;
	}

	//public Parentesco getParentesco() {
	//	return parentesco;
	//}

	//public void setParentesco(Parentesco parentesco) {
	//	this.parentesco = parentesco;
	//}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	
	
}
