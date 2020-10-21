package co.com.personalsoft.Springpractica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.personalsoft.Springpractica.DTO.UsuarioDTO;
import co.com.personalsoft.Springpractica.modelo.Cuenta;
import co.com.personalsoft.Springpractica.modelo.Usuario;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController

public class ControlUsuario {

	@Autowired
    private UsuarioDTO usuarioDTO;
	@Autowired
	private ControlCuenta controlCuenta;

    @GetMapping("/usuario")
    public List<Usuario> buscarUsuario() {
        List<Usuario> usuario = usuarioDTO.findAll();
        return usuario;
    }

    @PostMapping("/usuario")
    public void newUsuario(@RequestBody Usuario u) {
        usuarioDTO.save(u);
        Cuenta cuenta = new Cuenta();
        cuenta.setUsuario(u);
        cuenta.setCantidad_Puntos(2000);
        controlCuenta.newCuenta(cuenta);
    }

    @GetMapping("/usuario/{id_usuario}")
    public Optional<Usuario> Usuarioid(@PathVariable("id_usuario") int idusuario) {
        Optional<Usuario> usuario = usuarioDTO.findById(idusuario);
        return usuario;
    }

    @PutMapping("/usuario/{id_usuario}")
    public Usuario editUsuario(@RequestBody Usuario u, @PathVariable("id_usuario") int idusuario) {
        Optional<Usuario> o = usuarioDTO.findById(idusuario);
        Usuario usuario = o.get();
        u.setId_Usuario(usuario.getId_Usuario());
        usuarioDTO.save(u);
    	return usuario;
    }

    @DeleteMapping("/usuario/{id_usuario}")
    public void deleteUsuario(@PathVariable("id_usuario") int idusuario) {
        usuarioDTO.deleteById(idusuario);
    }
    
    @GetMapping("/usuario/login/{username}/{password}")
    public ResponseEntity<?> Usuarioid(@PathVariable("username") String username, @PathVariable("password") String password) {
        List<Usuario>Usuarios=(List<Usuario>) usuarioDTO.validateUsername(username, password);
        if(Usuarios.isEmpty()) {
        	return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Usuarios.get(0));
    }
    
    @GetMapping("/usuariouser/{user_name}")
	public boolean userUsuario(@PathVariable("user_name") String userName){
    	List<Usuario>Usuarios=(List<Usuario>) usuarioDTO.verificaUsername(userName);
    	return Usuarios.isEmpty()==false;
	}
	
}
