package cl.inacap.visona.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import cl.inacap.visona.entity.CategoriaProducto;




public interface CategoriaProductoService {
	
	
	
	public List<CategoriaProducto>findByNombreCategoria(String term);
	
	public Iterable<CategoriaProducto>findAll(Pageable pageable);
	
	
	public Optional<CategoriaProducto>findbyId(Long id);
	
	
	
	public CategoriaProducto save(CategoriaProducto categoriaProducto);
	
	
	
	public void deleteById(Long id);
	
	

}
