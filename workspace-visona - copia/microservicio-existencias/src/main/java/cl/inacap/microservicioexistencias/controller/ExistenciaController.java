package cl.inacap.microservicioexistencias.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.inacap.microservicioexistencias.entity.Existencias;
import cl.inacap.microservicioexistencias.services.ExistenciasService;

@RestController
public class ExistenciaController {

	@Autowired
	private ExistenciasService service;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.finAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {

		Optional<Existencias> b = service.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(b.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Existencias existencias) {
		Existencias bodegaDb = service.save(existencias);
		return ResponseEntity.status(HttpStatus.CREATED).body(bodegaDb);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Existencias existencias, @PathVariable Long id) {

		Optional<Existencias> b = service.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Existencias existenciasDB = b.get();
		existenciasDB.setStock(existencias.getStock());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(existenciasDB));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.notFound().build();

	}

}
