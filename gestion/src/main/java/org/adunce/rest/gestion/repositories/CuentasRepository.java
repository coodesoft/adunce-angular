package org.adunce.rest.gestion.repositories;

import org.adunce.rest.gestion.model.contabilidad.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentasRepository extends JpaRepository<Cuenta, String> {

}
