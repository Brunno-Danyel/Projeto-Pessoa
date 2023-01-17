package application.Repositories;

import application.entities.Endereco;
import application.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface EnderecoRespository extends JpaRepository<Endereco, Long> {

        Optional<List<Endereco>> findByPessoa(Pessoa pessoa);
}
