package application.dto;

import application.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    @NotEmpty(message = "{campo.nome}")
    private String nome;

    @NotEmpty(message = "{campo.dataNascimento}")
    private String dataNascimento;

    public static Pessoa fromDTO(PessoaDTO pessoaDTO){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
        return pessoa;
    }

}
