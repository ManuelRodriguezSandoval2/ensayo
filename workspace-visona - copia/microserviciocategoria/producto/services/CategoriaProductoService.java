package cl.inacap.microserviciocategoria.producto.services;

import java.util.Optional;

import cl.inacap.microserviciocategoria.entity.CategoriaProducto;





public interface CategoriaProductoService {
	
	
	public Iterable<CategoriaProducto>finAll();
	
	
	public Optional<CategoriaProducto>findbyId(Long id);
	
	
	
	public CategoriaProducto save(CategoriaProducto categoriaProducto);
	
	
	
	public void deleteById(Long id);
	
	

}
