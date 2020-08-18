package cl.inacap.visona.controller;

import java.util.List;
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

import cl.inacap.visona.entity.Bodega;
import cl.inacap.visona.entity.Existencias;
import cl.inacap.visona.services.BodegaService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/bodega")
public class BodegaController {

	@Autowired
	private BodegaService bodegaService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(bodegaService.findAll(pageable));
	
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {

		Optional<Bodega> b = bodegaService.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(b.get());
	}
	
	@GetMapping("/filtrar")
	public ResponseEntity<?> filtrar() {

		return ResponseEntity.ok(bodegaService.findByNombre());
	
	}

	@PostMapping("/ingresar")
	public ResponseEntity<?> crear(@RequestBody Bodega bodega) {
		Bodega bodegaDb = bodegaService.save(bodega);
		if(bodegaDb==null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(bodegaDb);
	}
	
	@PutMapping("/modificar/{id}")
	public ResponseEntity<?> editar(@RequestBody Bodega bodega, @PathVariable Long id) {

		Optional<Bodega> b = bodegaService.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Bodega bodegaDb = b.get();
		bodegaDb.setId(bodega.getId());
		bodegaDb.setCiudad(bodega.getCiudad());
		bodegaDb.setDireccion(bodega.getDireccion());
		bodegaDb.setNombreBodega(bodega.getNombreBodega());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bodegaService.save(bodegaDb));
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		
		boolean isDeleted=bodegaService.deleteById(id);
		if(isDeleted) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();

	}

	
	
	@PutMapping("/asignar-existencia/{id}")
	public ResponseEntity<?> asignarExistencia(@RequestBody List<Existencias> existencia, @PathVariable Long id) {
		Optional<Bodega> o = this.bodegaService.findbyId(id);
		if (!o.isPresent()) {

			return ResponseEntity.notFound().build();

		}
		Bodega bodegaDb = o.get();
		existencia.forEach(a -> {
			bodegaDb.addExistencias(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.bodegaService.save(bodegaDb));
	}



}
