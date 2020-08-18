package cl.inacap.visona.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.inacap.visona.entity.Bodega;
import cl.inacap.visona.repository.BodegaRepository;


@Service
public class BodegaServiceImpl implements BodegaService {

	
	@Autowired
	private BodegaRepository repository;
	@Transactional(readOnly=true)
	@Override
	public Iterable<Bodega> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Bodega> findByNombre() {
		// TODO Auto-generated method stub
		return repository.findByNombre();
	}

	

	@Override
	@Transactional(readOnly=true)
	public Optional<Bodega> findbyId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
		
	}

	@Override
	@Transactional
	public Bodega save(Bodega bodega) {
		// TODO Auto-generated method stub
		
		Bodega bodegaCod = this.repository.findBodegaById(bodega.getId());
		
		if (bodegaCod==null) {
			return repository.save(bodega);
			
		}
		return null;
		
	}

	@Override
	@Transactional
	public boolean deleteById(Long id) {

		Optional<Bodega> bodegaOP = this.repository.findById(id);

		if (bodegaOP.isPresent()) {
			
			repository.deleteById(id);
			return true;
		}
		return false;

	}

}


	
	

	


