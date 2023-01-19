package application.dto;

import application.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    @NotNull(message = "{campo.pessoa}")
    private Long pessoa;

    @NotEmpty(message = "{campo.logradouro}")
    private String logradouro;

    @NotEmpty(message = "{campo.cep}")
    private String cep;

    @NotNull(message = "{campo.numero}")
    private Integer numero;

    @NotEmpty(message = "{campo.cidade}")
    private String cidade;

    private boolean enderecoPrincipal;

    public static Endereco fromDTO(EnderecoDTO enderecoDTO){
        Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEnderecoPrincial(enderecoDTO.isEnderecoPrincipal());
        return endereco;
    }
}
