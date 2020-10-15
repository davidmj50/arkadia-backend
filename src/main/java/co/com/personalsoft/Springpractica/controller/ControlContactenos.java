package co.com.personalsoft.Springpractica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.personalsoft.Springpractica.DTO.ContactenosDTO;
import co.com.personalsoft.Springpractica.modelo.Contactenos;

@CrossOrigin(origins= "http://localhost:4200", maxAge=3600)
@RestController

public class ControlContactenos {

	@Autowired
	private ContactenosDTO contactenosDTO;
	
	@GetMapping("/contactenos")
	public List<Contactenos> listarContactenos(){
		List<Contactenos> contactenos = contactenosDTO.findAll();
		return contactenos;
	}
	
	@PostMapping("/contactenos")
	public void newContactenos(@RequestBody Contactenos contactenos) {
		contactenosDTO.save(contactenos);
	}
	
	@GetMapping("/contactenos/{id}")
	Optional<Contactenos> contactenosId(@PathVariable("id") int idContactenos){
		Optional<Contactenos> contactenos = contactenosDTO.findById(idContactenos);
		return contactenos;
	}
	
}
