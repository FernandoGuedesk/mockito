package aprendendo.mockito.api.services;

import aprendendo.mockito.api.domain.DTO.UsuarioDTO;
import aprendendo.mockito.api.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario findById(Integer id);
    List<Usuario> findAll();
    Usuario create(UsuarioDTO obj);
    Usuario update(UsuarioDTO obj);
    void delete(Integer id);
}
