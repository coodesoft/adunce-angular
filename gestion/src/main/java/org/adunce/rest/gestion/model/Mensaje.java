package org.adunce.rest.gestion.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.adunce.rest.gestion.model.security.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Mensaje {

	@Id
	@GeneratedValue
	private Long msjId;
	
	@ManyToOne
	@JsonIgnore
	private Usuario remitente;
	
	@OneToMany
	@JsonIgnore
	private List<Usuario> destinatarios;
	
	private Date fecha;
	
	private String cuerpo;
	
	private String asunto;

	private Boolean leido;

	public Mensaje() {
		super();
	}
	
	public Boolean getLeido() {
		return leido;
	}

	public void setLeido(Boolean leido) {
		this.leido = leido;
	}


	public Long getMsjId() {
		return msjId;
	}

	public void setMsjId(Long msjId) {
		this.msjId = msjId;
	}

	public Usuario getRemitente() {
		return remitente;
	}

	public void setRemitente(Usuario remitente) {
		this.remitente = remitente;
	}

	public List<Usuario> getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(List<Usuario> destinatarios) {
		this.destinatarios = destinatarios;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
}
