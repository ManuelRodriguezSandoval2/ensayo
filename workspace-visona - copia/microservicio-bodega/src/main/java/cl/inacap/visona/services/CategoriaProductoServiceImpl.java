package cl.inacap.visona.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.inacap.visona.entity.CategoriaProducto;
import cl.inacap.visona.repository.CategoriaProductoRepository;







@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

	
	@Autowired
	private CategoriaProductoRepository repository;
	@Override
	@Transactional(readOnly=true)
	public Iterable<CategoriaProducto> findAll(Pageable pageable){
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
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

	@Override
	@Transactional(readOnly=true )
	public List<CategoriaProducto> findByNombreCategoria(String term) {
		// TODO Auto-generated method stub
		return repository.findByNombreCategoria(term);
	}

}
