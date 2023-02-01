package aprendendo.mockito.api.controller.exceptions;

import aprendendo.mockito.api.services.exceptions.DataIntegratvViolationException;
import aprendendo.mockito.api.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.time.LocalDateTime;

class ResourceEcxeptionHandlerTest {

    private static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";
    private static final String E_MAIL_JA_CADASTRADO = "E-mail já cadastrado";
    @InjectMocks
    private ResourceEcxeptionHandler ecxeptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenObjectNotFoundExceptionThenReturnAResponseEntity() {
        ResponseEntity<StandartError> response = ecxeptionHandler
                .objectNotFound(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO),
                        new MockHttpServletRequest());

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertEquals(ResponseEntity.class, response.getClass());
        Assertions.assertEquals(StandartError.class, response.getBody().getClass());
        Assertions.assertEquals(OBJETO_NAO_ENCONTRADO, response.getBody().getError());
        Assertions.assertEquals(404, response.getBody().getStatus());
        Assertions.assertNotEquals("/usuario/2", response.getBody().getPath());
        Assertions.assertNotEquals(LocalDateTime.now(), response.getBody().getTimestamp());


    }

    @Test
    void dataIntegrityViolationException() {
        ResponseEntity<StandartError> response = ecxeptionHandler
                .dataIntegratvViolationException(
                        new DataIntegratvViolationException(E_MAIL_JA_CADASTRADO),
                        new MockHttpServletRequest());

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assertions.assertEquals(ResponseEntity.class, response.getClass());
        Assertions.assertEquals(StandartError.class, response.getBody().getClass());
        Assertions.assertEquals(E_MAIL_JA_CADASTRADO, response.getBody().getError());
        Assertions.assertEquals(400, response.getBody().getStatus());

    }
}