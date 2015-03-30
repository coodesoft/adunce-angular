package org.adunce.rest.gestion.controllers.rest;

import org.adunce.rest.gestion.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
	
}
