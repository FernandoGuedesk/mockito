package aprendendo.mockito.api.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioDTO {

    private Integer id;
    private String name;
    private String email;
    private String senha;
}
