package application.services;

import application.Repositories.EnderecoRespository;
import application.dto.EnderecoDTO;
import application.entities.Endereco;
import application.entities.Pessoa;
import application.exception.PessoaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRespository enderecoRespository;

    @Autowired
    private PessoaService pessoaService;

    public Endereco criarEndereco(EnderecoDTO enderecoDTO) {
        Long idPessoa = enderecoDTO.getPessoa();
        Pessoa pessoa = pessoaService.consultarPessoa(enderecoDTO.getPessoa());

        Endereco endereco = enderecoDTO.fromDTO(enderecoDTO);
        endereco.setPessoa(pessoa);
        return enderecoRespository.save(endereco);
    }

    public Optional<List<Endereco>> consultarEnderecosPessoa(Pessoa pessoa) {
        return Optional.ofNullable(enderecoRespository.findByPessoa(pessoa)
                .orElseThrow(() -> new PessoaException("Pessoa não encontrada na base de dados!")));
    }

}
