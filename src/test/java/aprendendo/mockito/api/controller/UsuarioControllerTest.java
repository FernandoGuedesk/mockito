package aprendendo.mockito.api.controller;

import aprendendo.mockito.api.domain.DTO.UsuarioDTO;
import aprendendo.mockito.api.domain.Usuario;
import aprendendo.mockito.api.services.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class UsuarioControllerTest {

    private static final Integer ID = 1;
    private static final String NAME = "Valdir";
    private static final String EMAIL = "valdir@email.com";
    private static final String SENHA = "123";
    private static final int INDEX = 0;

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;

    @InjectMocks
    private UsuarioController controller;

    @Mock
    private UsuarioServiceImpl service;

    @Mock
    private ModelMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUsuario();
    }

    @Test
    void whenFindByIdThenReturnSuccess() {
        Mockito.when(service.findById(Mockito.anyInt())).thenReturn(usuario);
        Mockito.when(mapper.map(any(), Mockito.any())).thenReturn(usuarioDTO);

        ResponseEntity<UsuarioDTO> response = controller.findById(ID);

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(ResponseEntity.class, response.getClass());
        Assertions.assertEquals(UsuarioDTO.class, response.getBody().getClass());

        Assertions.assertEquals(ID, response.getBody().getId());
        Assertions.assertEquals(NAME, response.getBody().getName());
        Assertions.assertEquals(EMAIL, response.getBody().getEmail());
        Assertions.assertEquals(SENHA, response.getBody().getSenha());
    }

    @Test
    void whenFindAllThenReturnAlistOfUsuarioDTO() {
        Mockito.when(service.findAll()).thenReturn(List.of(usuario));
        Mockito.when(mapper.map(any(), any())).thenReturn(usuarioDTO);

        ResponseEntity<List<UsuarioDTO>> response = controller.findAll();

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(ResponseEntity.class, response.getClass());
        Assertions.assertEquals(ArrayList.class, response.getBody().getClass());
        Assertions.assertEquals(UsuarioDTO.class, response.getBody().get(INDEX).getClass());

        Assertions.assertEquals(ID, response.getBody().get(INDEX).getId());
        Assertions.assertEquals(NAME, response.getBody().get(INDEX).getName());
        Assertions.assertEquals(EMAIL, response.getBody().get(INDEX).getEmail());
        Assertions.assertEquals(SENHA, response.getBody().get(INDEX).getSenha());
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUsuario() {
        usuario = new Usuario(ID, NAME, EMAIL, SENHA);
        usuarioDTO = new UsuarioDTO(ID, NAME, EMAIL, SENHA);
    }
}