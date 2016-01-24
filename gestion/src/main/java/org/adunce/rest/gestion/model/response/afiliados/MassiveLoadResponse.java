package org.adunce.rest.gestion.model.response.afiliados;

import java.util.List;
import java.util.Map;

import org.adunce.rest.gestion.model.Afiliado;
import org.adunce.rest.gestion.model.ErrorNotification;

public class MassiveLoadResponse {

	List<Afiliado> afiliadosAgregados;
	
	Map<Afiliado,ErrorNotification> afiliadosConError;

	public MassiveLoadResponse() {
		super();
	}

	public MassiveLoadResponse(List<Afiliado> afiliadosAgregados,
			Map<Afiliado, ErrorNotification> afiliadosConError) {
		super();
		this.afiliadosAgregados = afiliadosAgregados;
		this.afiliadosConError = afiliadosConError;
	}

	public List<Afiliado> getAfiliadosAgregados() {
		return afiliadosAgregados;
	}

	public void setAfiliadosAgregados(List<Afiliado> afiliadosAgregados) {
		this.afiliadosAgregados = afiliadosAgregados;
	}

	public Map<Afiliado, ErrorNotification> getAfiliadosConError() {
		return afiliadosConError;
	}

	public void setAfiliadosConError(
			Map<Afiliado, ErrorNotification> afiliadosConError) {
		this.afiliadosConError = afiliadosConError;
	}
	
}
