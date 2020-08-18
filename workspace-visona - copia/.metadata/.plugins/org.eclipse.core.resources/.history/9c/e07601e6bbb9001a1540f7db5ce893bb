package cl.inacap.microservicioingreso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.inacap.microservicio.ingreso.entity.Ingreso;
import cl.inacap.microservicioingreso.repository.IngresoRepository;



@Service
public class IngresoServiceImpl implements IngresoService {

	
	@Autowired
	private IngresoRepository repository;
	@Override
	@Transactional(readOnly=true)
	public Iterable<Ingreso> finAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Ingreso> findbyId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
		
	}

	@Override
	@Transactional
	public Ingreso save(Ingreso ingreso) {
		// TODO Auto-generated method stub
		return repository.save(ingreso);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

}
