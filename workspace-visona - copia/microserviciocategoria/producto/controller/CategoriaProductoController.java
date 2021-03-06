package cl.inacap.microserviciocategoria.producto.controller;

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

import cl.inacap.microserviciocategoria.entity.CategoriaProducto;
import cl.inacap.microserviciocategoria.producto.services.CategoriaProductoService;


@RestController
public class CategoriaProductoController {

	@Autowired
	private CategoriaProductoService service;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.finAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {

		Optional<CategoriaProducto> b = service.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(b.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody CategoriaProducto categoriaProducto) {
		CategoriaProducto categoriaProductoDb = service.save(categoriaProducto);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaProductoDb);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody CategoriaProducto categoriaProducto, @PathVariable Long id) {

		Optional<CategoriaProducto> b = service.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		CategoriaProducto categoriaProductoDb = b.get();
		categoriaProductoDb.setNombreCategoria(categoriaProducto.getNombreCategoria());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoriaProducto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.notFound().build();

	}

}
