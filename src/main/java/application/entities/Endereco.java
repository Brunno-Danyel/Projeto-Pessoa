package application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tb_id_pessoa")
    private Pessoa pessoa;

    @Column(name = "tb_logradouro")
    private String logradouro;

    @Column(name = "tb_cep", length = 8)
    private String cep;

    @Column(name = "tb_numero")
    private Integer numero;

    @Column(name = "tb_cidade")
    private String cidade;

    @Column(name = "tb_endereco_princial")
    private boolean enderecoPrincial;



}
