package cl.inacap.visona.services;

import java.util.Optional;

import org.springframework.data.domain.Pageable;

import cl.inacap.visona.entity.Traspasos;









public interface TraspasosService {
	
	
	public Iterable<Traspasos>findAll(Pageable pageable);
	
	
	public Optional<Traspasos>findbyId(Long id);
	
	
	
	public Traspasos save(Traspasos traspasos);
	
	
	
	public boolean deleteById(Long id);
	
	

}
