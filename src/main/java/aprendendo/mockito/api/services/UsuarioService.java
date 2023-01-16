package aprendendo.mockito.api.services;

import aprendendo.mockito.api.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario findById(Long id);
    List<Usuario> findAll();
}
