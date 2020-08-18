package cl.inacap.microserviciocategoria.producto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.inacap.microserviciocategoria.entity.CategoriaProducto;
import cl.inacap.microserviciocategoria.producto.repository.CategoriaProductoRepository;



@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

	
	@Autowired
	private CategoriaProductoRepository repository;
	@Override
	@Transactional(readOnly=true)
	public Iterable<CategoriaProducto> finAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<CategoriaProducto> findbyId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
		
	}

	@Override
	@Transactional
	public CategoriaProducto save(CategoriaProducto categoriaProducto) {
		// TODO Auto-generated method stub
		return repository.save(categoriaProducto);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

}
