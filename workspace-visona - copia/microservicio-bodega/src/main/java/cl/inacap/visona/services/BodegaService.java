package cl.inacap.visona.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import cl.inacap.visona.entity.Bodega;

public interface BodegaService {
	
	
	
	
	
	public Iterable<Bodega>findAll(Pageable pageable);
	
	public Optional<Bodega>findbyId(Long id);
	
	public Bodega save(Bodega bodega);
	
	public boolean deleteById(Long id);

	public List<Bodega> findByNombre();

}
