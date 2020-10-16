package co.com.personalsoft.Springpractica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.personalsoft.Springpractica.DTO.RolDTO;
import co.com.personalsoft.Springpractica.modelo.Rol;

@CrossOrigin(origins= "http://localhost:4200", maxAge=3600)
@RestController
public class ControlRol {

	@Autowired
	private RolDTO rolDTO;
	
	@GetMapping("/roles")
    public List<Rol> listarRoles(){
        List<Rol> roles = rolDTO.findAll();
        return roles;
    }
    
    @PostMapping("/roles")
    public void newRol(@RequestBody Rol rol) {
      rolDTO.save(rol);
    }
    
    @GetMapping("/roles/{id_rol}")
    public Optional<Rol> rolId(@PathVariable("id_rol") int idRol){
        Optional<Rol> roles = rolDTO.findById(idRol);
        return roles;
    }
    
    @PutMapping("/roles/{id_rol}")
    public Rol editRol(@RequestBody Rol r, @PathVariable("id_rol") int idRol ) {
    	Optional<Rol> o = rolDTO.findById(idRol);
    	Rol rol = o.get();
    	r.setId_rol(rol.getId_rol());
    	rolDTO.save(r);
    	return rol;
    }
    
    @DeleteMapping("/roles/{id_rol}")
	public void deleteRol(@PathVariable("id_rol") int idRol) {
		rolDTO.deleteById(idRol);
		
	}

	
	
}
