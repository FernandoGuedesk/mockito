package aprendendo.mockito.api.services;

import aprendendo.mockito.api.domain.DTO.UsuarioDTO;
import aprendendo.mockito.api.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario findById(Long id);
    List<Usuario> findAll();
    Usuario create(UsuarioDTO obj);
}
