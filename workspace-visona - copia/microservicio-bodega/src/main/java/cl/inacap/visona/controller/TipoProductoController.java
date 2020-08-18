package cl.inacap.visona.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import cl.inacap.visona.entity.TipoProducto;
import cl.inacap.visona.services.TipoProductoService;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("/tipo-producto")
public class TipoProductoController {

	@Autowired
	private TipoProductoService ingresoService;

	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(ingresoService.finAll());
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {

		Optional<TipoProducto> b = ingresoService.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(b.get());
	}

	
	@PostMapping("/producto")
	public ResponseEntity<?> crear(@RequestBody TipoProducto tipoproducto) {
		TipoProducto tipoproductoDb = ingresoService.save(tipoproducto);
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoproductoDb);
	}

	@PutMapping("/modificar/{id}")
	public ResponseEntity<?> editar(@RequestBody TipoProducto tipoproducto, @PathVariable Long id) {

		Optional<TipoProducto> b = ingresoService.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		TipoProducto tipoproductoDb = b.get();
		tipoproductoDb.setMedidaEstandar(tipoproducto.getMedidaEstandar());
		tipoproductoDb.setNombreTipoProducto(tipoproducto.getNombreTipoProducto());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ingresoService.save(tipoproductoDb));
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		ingresoService.deleteById(id);
		return ResponseEntity.notFound().build();

	}

}
