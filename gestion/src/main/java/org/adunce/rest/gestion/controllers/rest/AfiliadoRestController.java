package org.adunce.rest.gestion.controllers.rest;

import java.util.ArrayList;
import java.util.List;

import org.adunce.rest.gestion.model.Afiliado;
import org.adunce.rest.gestion.model.Grupo;
import org.adunce.rest.gestion.model.Hijo;
import org.adunce.rest.gestion.model.security.Rol;
import org.adunce.rest.gestion.repositories.AfiliadosRepository;
import org.adunce.rest.gestion.repositories.GrupoRepository;
import org.adunce.rest.gestion.repositories.HijosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value="Afiliados",description="Controlador REST de Afiliados")
@RestController
@RequestMapping("/REST/afiliados")
public class AfiliadoRestController {

	@Autowired
	private AfiliadosRepository afRepo;
	
	@Autowired
	private GrupoRepository grRepo;
	
	@Autowired
	private HijosRepository sonRepo;
	
	@RequestMapping(value="/loadData",method=RequestMethod.GET)
	public void loadData(){
		for (int i=0; i< 10; i++){
			Afiliado af = new Afiliado();
			af.setUsername("Af"+i);
			af.setEnabled(true);
			af.setPassword("Ps"+i);
			af.setRol(Rol.ADMIN);
			afRepo.save(af);
		}
	}
	
	@ApiOperation(value="Retorna a los afiliados.", notes="Retorna una lista completa de todos los afiliados del gremio.",response=Afiliado[].class)
	@RequestMapping(method=RequestMethod.GET)
	public List<Afiliado> list(){
		return afRepo.findAll();
	}
	
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public Afiliado get(@PathVariable String username){
		if (afRepo.exists(username))
			return afRepo.getOne(username);
		return null;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Boolean save(@RequestBody Afiliado af){
		if(afRepo.exists(af.getUsername())){
			afRepo.save(af);
			return true;
		}
		return false;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Boolean add(@RequestBody Afiliado afiliado){
		System.out.println("Estoy agregando un afiliado");
		if((afiliado.getUsername()==null)||(!afRepo.exists(afiliado.getUsername()))){
			afiliado.setEnabled(false);
			//Iterator<Hijo> hijos = afiliado.getHijos().iterator();
			List<Hijo> hijos = afiliado.getHijos();
			afiliado.setHijos(null);
			afRepo.save(afiliado);
			Afiliado full = afRepo.getOne(afiliado.getUsername());
			List<Hijo> afHijos = new ArrayList<Hijo>();
			for (Hijo hijo : hijos){
				hijo.setPariente(full);
				afHijos.add(sonRepo.save(hijo));
			}
			full.setHijos(afHijos);
			afRepo.flush();
			
			System.out.println("Hijos: " + afiliado.getHijos());
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="/{username}",method=RequestMethod.DELETE)
	public Boolean delete(@PathVariable String username){
		if(afRepo.exists(username)){
			Afiliado afiliado = afRepo.findOne(username);
			for(Hijo hijo : afiliado.getHijos()){
				sonRepo.delete(hijo);
			}
			afRepo.delete(afiliado);
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="/{username}/grupo",method=RequestMethod.GET)
	public Grupo getGrupo(@PathVariable String username){
		if(afRepo.exists(username)){
			return afRepo.findOne(username).getGrupo();
		}
		return null;
	}
	
	@RequestMapping(value="/{username}/{grupo}",method=RequestMethod.PUT)
	public Boolean setGrupo(@PathVariable String username, @PathVariable String grupo){
		if(afRepo.exists(username)&&grRepo.exists(grupo)){
			Grupo afGrupo = grRepo.findOne(grupo);
			Afiliado afiliado = afRepo.findOne(username);
			afiliado.setGrupo(afGrupo);
			afRepo.save(afiliado);
			return true;
		}
		return false;
	}
}
