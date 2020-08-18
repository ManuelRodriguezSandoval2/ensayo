package cl.inacap.microservicioexistencias.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.inacap.microservicioexistencias.entity.Existencias;
import cl.inacap.microservicioexistencias.repository.ExistenciasRepository;


@Service
public class ExistenciasServiceImpl implements ExistenciasService {

	
	@Autowired
	private ExistenciasRepository repository;
	@Override
	@Transactional(readOnly=true)
	public Iterable<Existencias> finAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Existencias> findbyId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
		
	}

	@Override
	@Transactional
	public Existencias save(Existencias bodega) {
		// TODO Auto-generated method stub
		return repository.save(bodega);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

}
