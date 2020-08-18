package cl.inacap.visona.services;

import java.util.Optional;

import cl.inacap.visona.entity.TipoProducto;








public interface TipoProductoService {
	
	
	public Iterable<TipoProducto>finAll();
	
	
	public Optional<TipoProducto>findbyId(Long id);
	
	
	
	public TipoProducto save(TipoProducto tipoProducto);
	
	
	
	public void deleteById(Long id);
	
	

}
