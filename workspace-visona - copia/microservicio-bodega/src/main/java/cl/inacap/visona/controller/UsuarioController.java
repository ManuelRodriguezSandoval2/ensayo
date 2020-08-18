package cl.inacap.visona.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import cl.inacap.visona.entity.Usuario;
import cl.inacap.visona.services.UsuarioService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/usuario")


public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(usuarioService.findAll(pageable));
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {

		Optional<Usuario> b = usuarioService.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(b.get());
	}

	@PostMapping("/ingresar")
	public ResponseEntity<?> crear(@RequestBody Usuario usuario) {
		Usuario usuarioDb = usuarioService.save(usuario);
		if(usuarioDb==null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDb);
	}
	
	@PutMapping("/modificar/{id}")
	public ResponseEntity<?> editar(@RequestBody Usuario usuario, @PathVariable Long id) {

		Optional<Usuario> b = usuarioService.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Usuario usuarioDb = b.get();
		usuarioDb.setRut(usuario.getRut());
		usuarioDb.setNombre(usuario.getNombre());
		usuarioDb.setApellido(usuario.getApellido());
		usuarioDb.setEmail(usuario.getEmail());
		usuarioDb.setContrasena(usuario.getContrasena());
		usuarioDb.setPermisos(usuario.getPermisos());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioDb));
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		
		boolean isDeleted=usuarioService.deleteById(id);
		if(isDeleted) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();

	}
}
