package cl.inacap.visona.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;


import cl.inacap.visona.entity.Proveedor;

public interface ProveedorService {
	
	
	public Iterable<Proveedor>findAll(Pageable pageable);
	
	public Optional<Proveedor>findbyId(Long id);
	
	public Proveedor save(Proveedor proveedor);
	
	public boolean deleteById(Long id);
	
	public List<Proveedor> findByNombre();

}
