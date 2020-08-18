package cl.inacap.microservicioingreso.services;

import java.util.Optional;

import cl.inacap.microservicio.ingreso.entity.Ingreso;



public interface IngresoService {
	
	
	public Iterable<Ingreso>finAll();
	
	
	public Optional<Ingreso>findbyId(Long id);
	
	
	
	public Ingreso save(Ingreso ingreso);
	
	
	
	public void deleteById(Long id);
	
	

}
