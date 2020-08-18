package cl.inacap.visona.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.inacap.visona.entity.Usuario;
import cl.inacap.visona.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Transactional(readOnly = true)
	@Override
	public Iterable<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findbyId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);

	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		
		Usuario usuarioRut = this.repository.findUsuarioByRut(usuario.getRut());
		
		if (usuarioRut==null) {
			return repository.save(usuario);
			
		}
		return null;
		
	}

	@Override
	@Transactional
	public boolean deleteById(Long id) {

		Optional<Usuario> usuarioOP = this.repository.findById(id);

		if (usuarioOP.isPresent()) {
			
			repository.deleteById(id);
			return true;
		}
		return false;

	}

}
