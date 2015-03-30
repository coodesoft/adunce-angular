package org.adunce.rest.gestion.controllers.rest;

import java.util.ArrayList;
import java.util.List;

import org.adunce.rest.gestion.model.Mensaje;
import org.adunce.rest.gestion.model.security.Usuario;
import org.adunce.rest.gestion.model.security.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public Mensaje get(@PathVariable String msjId){
		if(msjRepo.exists(msjId)){
			return msjRepo.findOne(msjId);
		}
		return null;
	}
	
	@RequestMapping(value="/{msjId}",method=RequestMethod.DELETE)
	public Boolean delete(@PathVariable String msjId){
		if(msjRepo.exists(msjId)){
			msjRepo.delete(msjId);
			return true;
		}
		return false;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Boolean save(@RequestParam("mensaje") Mensaje mensaje){
		if(msjRepo.exists(mensaje.getId())){
			msjRepo.save(mensaje);
			return true;
		}
		return false;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Boolean add(@RequestParam("mensaje") Mensaje mensaje, 
						@RequestParam("remitente") String username,
						@RequestParam("destinatarios") List<String> usuarios){
		if(!msjRepo.exists(mensaje.getId())&&usRepo.exists(username)){
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
	public Boolean getRemitente(@PathVariable String msjId){
		if(msjRepo.exists(msjId)){
			msjRepo.delete(msjId);
			return true;
		}
		return false;
	}
}
