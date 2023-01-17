package application.Repositories;

import application.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnderecoRespository extends JpaRepository<Endereco, Long> {

}
