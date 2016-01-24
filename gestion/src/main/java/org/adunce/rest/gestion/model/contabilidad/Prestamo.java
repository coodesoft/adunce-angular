package org.adunce.rest.gestion.model.contabilidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.adunce.rest.gestion.model.Afiliado;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Prestamo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Afiliado afiliado;
	
	private Byte cuotas;
	
	private Byte mes;
	
	private Byte anio;
	
	private Double monto;
	
	public Prestamo(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Afiliado getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}

	public Byte getCuotas() {
		return cuotas;
	}

	public void setCuotas(Byte cuotas) {
		this.cuotas = cuotas;
	}

	public Byte getMes() {
		return mes;
	}

	public void setMes(Byte mes) {
		this.mes = mes;
	}

	public Byte getAnio() {
		return anio;
	}

	public void setAnio(Byte anio) {
		this.anio = anio;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
}
