package org.adunce.rest.gestion.controllers.rest;

import java.util.ArrayList;
import java.util.List;

import org.adunce.rest.gestion.model.Mensaje;
import org.adunce.rest.gestion.model.security.Usuario;
import org.adunce.rest.gestion.model.security.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

@Api(value="Mensajes",description="Controlador REST de Mensajes")
@RequestMapping("/mensajes")
@RestController
public class MensajeRestController {

	@Autowired
	private MensajeRepository msjRepo;
	
	@Autowired
	private UsuarioRepository usRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Mensaje> list(){
		return msjRepo.findAll();
	}
	
	@RequestMapping(value="/{msjId}",method=RequestMethod.GET)
	public Mensaje get(@PathVariable Long msjId){
		if(msjRepo.exists(msjId)){
			return msjRepo.findOne(msjId);
		}
		return null;
	}
	
	@RequestMapping(value="/{msjId}",method=RequestMethod.DELETE)
	public Boolean delete(@PathVariable Long msjId){
		if(msjRepo.exists(msjId)){
			msjRepo.delete(msjId);
			return true;
		}
		return false;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Boolean save(@RequestBody Mensaje mensaje){
		if(msjRepo.exists(mensaje.getMsjId())){
			msjRepo.save(mensaje);
			return true;
		}
		return false;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Boolean add(@RequestBody Mensaje mensaje, 
						@RequestBody String username,
						@RequestBody List<String> usuarios){
		if(!msjRepo.exists(mensaje.getMsjId())&&usRepo.exists(username)){
			List<Usuario> lUsuarios = new ArrayList<Usuario>();
			for(String usuario:usuarios){
				if (!usRepo.exists(usuario))
					return false;
				else
					lUsuarios.add(usRepo.findOne(usuario));
			}
			mensaje.setDestinatarios(lUsuarios);
			mensaje.setRemitente(usRepo.findOne(username));
			msjRepo.save(mensaje);
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="/{msjId}/remitente",method=RequestMethod.GET)
	public Boolean getRemitente(@PathVariable Long msjId){
		if(msjRepo.exists(msjId)){
			msjRepo.delete(msjId);
			return true;
		}
		return false;
	}
}
