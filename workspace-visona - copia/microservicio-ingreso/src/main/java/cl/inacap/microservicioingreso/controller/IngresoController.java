package cl.inacap.microservicioingreso.controller;

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

import cl.inacap.microservicio.ingreso.entity.Ingreso;
import cl.inacap.microservicioingreso.services.IngresoService;

@RestController
public class IngresoController {

	@Autowired
	private IngresoService service;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.finAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {

		Optional<Ingreso> b = service.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(b.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Ingreso ingreso) {
		Ingreso ingresoDb = service.save(ingreso);
		return ResponseEntity.status(HttpStatus.CREATED).body(ingresoDb);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Ingreso ingreso, @PathVariable Long id) {

		Optional<Ingreso> b = service.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Ingreso ingresoBd = b.get();
		ingresoBd.setNumero_guia(ingreso.getNumero_guia());
		ingresoBd.setCantidad(ingreso.getCantidad());
		ingresoBd.setFecha_ingreso(ingreso.getFecha_ingreso());
		ingresoBd.setUsuario(ingreso.getUsuario());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(ingresoBd));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.notFound().build();

	}

}
