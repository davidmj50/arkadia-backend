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

import co.com.personalsoft.Springpractica.DTO.UsuarioDTO;
import co.com.personalsoft.Springpractica.modelo.Usuario;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController

public class ControlUsuario {

	@Autowired
    private UsuarioDTO usuarioDTO;

    @GetMapping("/usuario")
    public List<Usuario> buscarUsuario() {
        List<Usuario> usuario = usuarioDTO.findAll();
        return usuario;
    }

    @PostMapping("/usuario")
    public void newUsuario(@RequestBody Usuario u) {
        usuarioDTO.save(u);
    }

    @GetMapping("/usuario/{id_usuario}")
    public Optional<Usuario> Usuarioid(@PathVariable("id_usuario") int idusuario) {
        Optional<Usuario> usuario = usuarioDTO.findById(idusuario);
        return usuario;
    }

    @PutMapping("/usuario/{id_usuario}")
    public Usuario editUsuario(@RequestBody Usuario u, @PathVariable("id_usuario") int idusuario) {
        Usuario usuario = usuarioDTO.save(u);
        return usuario;
    }

    @DeleteMapping("/usuario/{id_usuario}")
    public void deleteUsuario(@PathVariable("id_usuario") int idusuario) {
        usuarioDTO.deleteById(idusuario);
    }
	
}
