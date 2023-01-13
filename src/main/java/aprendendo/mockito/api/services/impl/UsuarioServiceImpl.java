package aprendendo.mockito.api.services.impl;

import aprendendo.mockito.api.domain.Usuario;
import aprendendo.mockito.api.repository.UsuarioRepository;
import aprendendo.mockito.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;
    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> obj = userRepository.findById(id);
        return obj.orElse(null);
    }
}
