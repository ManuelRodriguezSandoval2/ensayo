package cl.inacap.visona.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.inacap.visona.entity.TipoProducto;
import cl.inacap.visona.repository.TipoProductoRepository;







@Service
public class TipoProductoServiceImpl implements TipoProductoService {

	
	@Autowired
	private TipoProductoRepository repository;
	@Override
	@Transactional(readOnly=true)
	public Iterable<TipoProducto> finAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<TipoProducto> findbyId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
		
	}

	@Override
	@Transactional
	public TipoProducto save(TipoProducto tipoProducto) {
		// TODO Auto-generated method stub
		return repository.save(tipoProducto);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

}
