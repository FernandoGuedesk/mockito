package aprendendo.mockito.api.controller;

import aprendendo.mockito.api.domain.DTO.UsuarioDTO;
import aprendendo.mockito.api.domain.Usuario;
import aprendendo.mockito.api.repository.UsuarioRepository;
import aprendendo.mockito.api.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(modelMapper.map(usuarioService.findById(id),UsuarioDTO.class));

    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return ResponseEntity.ok().body(usuarioService.findAll()
                .stream().map(x -> modelMapper.map(x, UsuarioDTO.class)).collect(Collectors.toList()));
    }

}
