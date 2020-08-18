package cl.inacap.visona.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.inacap.visona.entity.Bodega;
import cl.inacap.visona.entity.Producto;
import cl.inacap.visona.entity.TipoProducto;
import cl.inacap.visona.repository.ProductoRepository;



@Service
public class ProductoServiceImpl implements ProductoService {

	
	@Autowired
	private ProductoRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public Page<Producto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Producto> finAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	
	
	
	

	@Override
	@Transactional(readOnly=true)
	public Optional<Producto> findbyId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
		
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return repository.save(producto);
	}

	@Override
	@Transactional
	public boolean deleteById(Long id) {

		Optional<Producto> productoOP = this.repository.findById(id);

		if (productoOP.isPresent()) {
			
			repository.deleteById(id);
			return true;
		}
		return false;

	}


	@Override
	@Transactional(readOnly=true)
	public List<Producto> findByNombreAndId() {
		// TODO Auto-generated method stub
		return repository.findByNombreAndId();
	}

}
