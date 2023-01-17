package aprendendo.mockito.api.services.impl;

import aprendendo.mockito.api.domain.DTO.UsuarioDTO;
import aprendendo.mockito.api.domain.Usuario;
import aprendendo.mockito.api.repository.UsuarioRepository;
import aprendendo.mockito.api.services.UsuarioService;
import aprendendo.mockito.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario create(UsuarioDTO obj) {
        return usuarioRepository.save(modelMapper.map(obj, Usuario.class));
    }
}
