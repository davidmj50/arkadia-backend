package co.com.personalsoft.Springpractica.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	@PersistenceContext
	private EntityManager em;

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
    
    @GetMapping("/login/{username}/{password}")
    public boolean Usuarioid(@PathVariable("username") String username, @PathVariable("password") String password) {
        List<Usuario>Usuarios=(List<Usuario>) usuarioDTO.validateUsername(username, password);
        return Usuarios.isEmpty()==false;
    }
    
    @GetMapping("/usuariouser/{user_name}")
	public boolean puntosUsuario(@PathVariable("user_name") String userName){
		int registros = 0;
    	String sql = "SELECT Id_Usuario FROM tbl_usuarios WHERE Username = " + "'" + userName + "'";
		Query query = em.createNativeQuery(sql);
		try {
			registros = (int) query.getSingleResult();
		}catch (Exception e){
			registros = 0;
		}
		if (registros != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
