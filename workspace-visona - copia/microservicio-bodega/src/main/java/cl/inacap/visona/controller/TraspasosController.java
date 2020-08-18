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

import cl.inacap.visona.entity.Traspasos;
import cl.inacap.visona.services.TraspasosService;



@RestController
@CrossOrigin(origins="*")
@RequestMapping("/traspaso")
public class TraspasosController {

	@Autowired
	private TraspasosService service;

	@GetMapping("/listar")
		public ResponseEntity<?> listar(Pageable pageable) {
			return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {

		Optional<Traspasos> b = service.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(b.get());
	}

	@PostMapping("/producto")
	public ResponseEntity<?> crear(@RequestBody Traspasos traspasos) {
		Traspasos traspasosDb = service.save(traspasos);
		return ResponseEntity.status(HttpStatus.CREATED).body(traspasosDb);
	}

	@PutMapping("/modificar/{id}")
	public ResponseEntity<?> editar(@RequestBody Traspasos traspasos, @PathVariable Long id) {

		Optional<Traspasos> b = service.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Traspasos traspasosBd = b.get();
		traspasosBd.setFechaTraspaso(traspasos.getFechaTraspaso());
		traspasosBd.setBodegaEntrante(traspasos.getBodegaEntrante());
		traspasosBd.setBodegaSaliente(traspasos.getBodegaSaliente());
		traspasosBd.setMedidaEstandar(traspasos.getMedidaEstandar());
		traspasos.setCantidad(traspasos.getCantidad());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(traspasosBd));
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		
		boolean isDeleted=service.deleteById(id);
		if(isDeleted) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();

	}

}
