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

import cl.inacap.visona.entity.Proveedor;
import cl.inacap.visona.services.ProveedorService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	private ProveedorService service;

	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {

		Optional<Proveedor> b = service.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(b.get());
	}
	
	@GetMapping("/filtrar")
	public ResponseEntity<?> filtrar() {

		return ResponseEntity.ok(service.findByNombre());
	
	}

	@PostMapping("/ingresar")
	public ResponseEntity<?> crear(@RequestBody Proveedor proveedor) {
		Proveedor proveedorDb = service.save(proveedor);
		if(proveedorDb==null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorDb);
	}

	@PutMapping("/modificar/{id}")
	public ResponseEntity<?> editar(@RequestBody Proveedor proveedor, @PathVariable Long id) {

		Optional<Proveedor> b = service.findbyId(id);
		if (b.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Proveedor proveedorBd = b.get();
		proveedorBd.setCiudad(proveedor.getCiudad());
		proveedorBd.setDireccion(proveedor.getDireccion());
		proveedorBd.setEmail(proveedor.getEmail());
		proveedorBd.setGiro(proveedor.getGiro());
		proveedorBd.setRazonSocial(proveedor.getRazonSocial());
		proveedorBd.setRut(proveedor.getRut());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(proveedorBd));
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
