package cl.inacap.microservicioexistencias.services;

import java.util.Optional;


import cl.inacap.microservicioexistencias.entity.Existencias;

public interface ExistenciasService {
	
	
	public Iterable<Existencias>finAll();
	
	public Optional<Existencias>findbyId(Long id);
	
	public Existencias save(Existencias xistencias);
	
	public void deleteById(Long id);

}
