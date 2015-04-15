package org.adunce.rest.gestion.controllers.rest.contabilidad;

import java.util.List;

import org.adunce.rest.gestion.model.contabilidad.Cuenta;
import org.adunce.rest.gestion.repositories.CuentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@Api(value="Cuentas Contables",description="Controlador REST de las Cuentas Contables")
@RequestMapping("/REST/contabilidad/cuentas")
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
		if(ctaRepo.exists(cuenta.getId())){
			Cuenta r = ctaRepo.save(cuenta);
			return r!=null;
		}
		return false;
	}
	
	@ApiOperation(value="Agrega una nueva cuenta.", notes="Retorna verdadero si los datos se guardaron correctamente.",response=Boolean.class)
	@RequestMapping(method=RequestMethod.POST)
	public Boolean add(@RequestBody Cuenta cuenta){
		if(!ctaRepo.exists(cuenta.getId())){
			Cuenta r = ctaRepo.save(cuenta);
			return r!=null;
		}
		return false;
	}
	
	@ApiOperation(value="Obtiene una cuenta.", notes="Retorna los datos de una cuenta específica.",response=Cuenta.class)
	@RequestMapping(value="/{cuentaId}",method=RequestMethod.GET)
	public Cuenta getCuenta(@PathVariable String cuentaId){
		return ctaRepo.findOne(cuentaId);
	}
	
	
	@ApiOperation(value="Borra una cuenta.", notes="Retorna verdadero si esa cuenta existía y se pudo borrar, de lo contrario retorna falso.",response=Boolean.class)
	@RequestMapping(value="/{cuentaId}",method=RequestMethod.DELETE)
	public Boolean delete(@PathVariable String cuentaId){
		if(ctaRepo.exists(cuentaId)){
			ctaRepo.delete(cuentaId);
			return true;
		}
		return false;
	}
	
	
}
