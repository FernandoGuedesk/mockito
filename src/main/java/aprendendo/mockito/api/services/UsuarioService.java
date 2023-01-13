package aprendendo.mockito.api.services;

import aprendendo.mockito.api.domain.Usuario;

public interface UsuarioService {

    Usuario findById(Long id);
}
