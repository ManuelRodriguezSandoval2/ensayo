package cl.inacap.visona.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.inacap.visona.entity.Traspasos;
import cl.inacap.visona.entity.Usuario;
import cl.inacap.visona.repository.TraspasosRepository;




@Service
public class TraspasosServiceImpl implements TraspasosService {

	
	@Autowired
	private TraspasosRepository repository;
	@Override
	@Transactional(readOnly=true)
	public Iterable<Traspasos> findAll(Pageable pageable){
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Traspasos> findbyId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
		
	}

	@Override
	@Transactional
	public Traspasos save(Traspasos traspasos) {
		// TODO Auto-generated method stub
		return repository.save(traspasos);
	}

	@Override
	@Transactional
	public boolean deleteById(Long id) {

		Optional<Traspasos> traspasoOP = this.repository.findById(id);

		if (traspasoOP.isPresent()) {
			
			repository.deleteById(id);
			return true;
		}
		return false;

	}

}
