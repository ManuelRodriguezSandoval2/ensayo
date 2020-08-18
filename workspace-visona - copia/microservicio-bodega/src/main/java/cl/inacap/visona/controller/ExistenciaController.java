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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.inacap.visona.entity.Existencias;
import cl.inacap.visona.services.ExistenciasService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/existencia")
public class ExistenciaController {

	@Autowired
	private ExistenciasService service;

	@GetMapping("/listar")
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {

		Optional<Existencias> b = service.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(b.get());
	}

	@PostMapping("/ingresar")
	public ResponseEntity<?> crear(@RequestBody Existencias existencias) {
		Existencias existenciasDB = service.save(existencias);
	
		return ResponseEntity.status(HttpStatus.CREATED).body(existenciasDB);
	}

//	@PutMapping("/modificar/{id}")
//	public ResponseEntity<?> editar(@RequestBody Existencias existencias, @PathVariable Long id) {
//
//		Optional<Existencias> b = service.findbyId(id);
//		if (b.isEmpty()) {
//			return ResponseEntity.notFound().build();
//		}
//
//		Existencias existenciasDB = b.get();
//		existenciasDB.setFechaIngreso(existencias.getFechaIngreso());
//		existenciasDB.setNumeroGuia(existencias.getNumeroGuia());
//		existenciasDB.setStock(existencias.getStock());
//		existenciasDB.setUsuario(existencias.getUsuario());
//		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(existenciasDB));
//	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		
		boolean isDeleted=service.deleteById(id);
		if(isDeleted) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();

	}

}
