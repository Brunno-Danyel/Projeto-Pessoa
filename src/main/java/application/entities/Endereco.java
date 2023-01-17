package application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_Endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tb_logradouro")
    private String logradouro;

    @Column(name = "tb_cep", length = 8)
    private String cep;

    @Column(name = "tb_numero")
    private String numero;

    @Column(name = "tb_cidade")
    private String cidade;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
}
