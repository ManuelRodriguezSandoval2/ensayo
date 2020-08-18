package cl.inacap.visona.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import cl.inacap.visona.entity.CategoriaProducto;
import cl.inacap.visona.entity.Producto;
import cl.inacap.visona.repository.ProductoRepository;
import cl.inacap.visona.repository.ProveedorRepository;
import cl.inacap.visona.repository.TipoProductoRepository;
import cl.inacap.visona.repository.TraspasosRepository;
import cl.inacap.visona.services.ProductoService;


@RestController
@RequestMapping("/producto")
@CrossOrigin(origins="*")
public class ProductoController {

	@Autowired
	private ProductoService service;

	@Autowired
	TraspasosRepository traspasosRepository;

	@Autowired
	ProveedorRepository proveedorRepository;

	@Autowired
	TipoProductoRepository tipoProductoRepository;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping("/listado")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.finAll());
	}
//
//	@GetMapping("/listar")
//	public ResponseEntity<?> listar(Pageable pageable) {
//		return ResponseEntity.ok().body(service.findAll(pageable));
//	}


	@GetMapping("/listar")
	public Page<Producto> listar(Pageable pageable) {
		return service.findAll(pageable);
	}
	
	/*@GetMapping("/tipo-producto/{tipoProductoId}/producto")
	public Page<Producto> getTesisByTesistaId(@PathVariable(value = "tipoProductoId") Long tipoProductoId,
			Pageable pageable) {
		return productoRepository.findByTipoProductoId(tipoProductoId, pageable);
	}*/
	
	@GetMapping("/filtrar")
	public ResponseEntity<?> filtrar() {

		return ResponseEntity.ok(service.findByNombreAndId());
	
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {

		Optional<Producto> b = service.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(b.get());
	}

	@PostMapping("/ingresar")
	public ResponseEntity<?> crear(@RequestBody Producto producto) {
		Producto productoDb = service.save(producto);
		if(productoDb==null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(productoDb);
	}

	@PutMapping("/modificar/{id}")
	public ResponseEntity<?> editar(@RequestBody Producto producto, @PathVariable Long id) {

		Optional<Producto> b = service.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Producto productoDb = b.get();
		productoDb.setNombreProducto(producto.getNombreProducto());
		productoDb.setMarcaProducto(producto.getMarcaProducto());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productoDb));
	}



	@PutMapping("/asignar-categoria/{id}")
	public ResponseEntity<?> asignarCategoria(@RequestBody List<CategoriaProducto> categoriaProducto,
			@PathVariable Long id) {

		Optional<Producto> b = this.service.findbyId(id);
		if (!b.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Producto productoDb = b.get();

		/*
		 * categoriaProducto.forEach(a-> { productoDb.addCategoriaProducto(a); });
		 */
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productoDb));

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
