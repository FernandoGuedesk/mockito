package aprendendo.mockito.api.controller;

import aprendendo.mockito.api.domain.Usuario;
import aprendendo.mockito.api.repository.UsuarioRepository;
import aprendendo.mockito.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;
    private UsuarioRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {

        return ResponseEntity.ok().body(userService.findById(id));

    }

}