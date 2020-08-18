package cl.inacap.visona.services;

import java.util.Optional;

import org.springframework.data.domain.Pageable;


import cl.inacap.visona.entity.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario>findAll(Pageable pageable);
	
	public Optional<Usuario>findbyId(Long id);
	
	public Usuario save(Usuario usuario);
	
	public boolean deleteById(Long id);


}
