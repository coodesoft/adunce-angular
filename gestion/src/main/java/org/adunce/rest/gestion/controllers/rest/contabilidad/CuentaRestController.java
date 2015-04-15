package org.adunce.rest.gestion.controllers.rest.contabilidad;

import java.util.List;

import org.adunce.rest.gestion.model.contabilidad.Cuenta;
import org.adunce.rest.gestion.repositories.CuentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contabilidad/cuentas")
public class CuentaRestController {
	
	@Autowired
	private CuentasRepository ctaRepo;
	
	@ApiOperation(value="Retorna las cuentas contables.", notes="Retorna una lista completa de las cuentas contables del gremio.",response=Cuenta[].class)
	@RequestMapping(method=RequestMethod.GET)
	public List<Cuenta> get(){
		return ctaRepo.findAll();
	}
	@ApiOperation(value="Guarda los datos modificados de la cuenta.", notes="Retorna verdadero si los datos se guardaron correctamente.",response=Boolean.class)
	@RequestMapping(method=RequestMethod.PUT)
	public Boolean save(@RequestBody Cuenta cuenta){
		return true;
	}
	
	@ApiOperation(value="Agrega una nueva cuenta.", notes="Retorna verdadero si los datos se guardaron correctamente.",response=Boolean.class)
	@RequestMapping(method=RequestMethod.POST)
	public Boolean add(@RequestBody Cuenta cuenta){
		return true;
	}
	
	
	
}
