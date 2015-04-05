package org.adunce.rest.gestion.controllers.rest;

import java.util.List;

import org.adunce.rest.gestion.model.Servicio;
import org.adunce.rest.gestion.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

@Api(value="Servicios",description="Controlador REST de Servicios")
@RequestMapping("/servicios")
@RestController
public class ServicioRestController {
	
	@Autowired
	private ServicioRepository srvRepo;

	@RequestMapping(method=RequestMethod.GET)
	public List<Servicio> list(){
		return srvRepo.findAll();
	}
	
	@RequestMapping(value="/{servicio}",method=RequestMethod.GET)
	public Servicio get(@PathVariable String codigo){
		if(srvRepo.exists(codigo)){
			return srvRepo.getOne(codigo);
		}
		return null;
	}
	
	@RequestMapping(value="/{servicio}",method=RequestMethod.DELETE)
	public Boolean delete(@PathVariable String codigo){
		if(srvRepo.exists(codigo)){
			srvRepo.delete(codigo);
			return true;
		}
		return false;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Boolean save(@RequestBody Servicio servicio){
		if(srvRepo.exists(servicio.getCodigo())){
			srvRepo.save(servicio);
			return true;
		}
		return false;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Boolean add(@RequestBody Servicio servicio){
		if(!srvRepo.exists(servicio.getCodigo())){
			srvRepo.save(servicio);
			return true;
		}
		return false;
	}
	
}
