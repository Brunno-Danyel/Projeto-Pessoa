package application.services;

import application.Repositories.EnderecoRepository;
import application.dto.EnderecoDTO;
import application.entities.Endereco;
import application.entities.Pessoa;
import application.exception.PessoaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    public Endereco criarEndereco(EnderecoDTO enderecoDTO) {
        Long idPessoa = enderecoDTO.getPessoa();
        Pessoa pessoa = pessoaService.consultarPessoa(enderecoDTO.getPessoa());

        Endereco endereco = enderecoDTO.fromDTO(enderecoDTO);
        endereco.setPessoa(pessoa);
        return enderecoRepository.save(endereco);
    }

    public Optional<List<Endereco>> buscarEnderecosPessoa(Pessoa pessoa) {
        return Optional.ofNullable(enderecoRepository.findByPessoa(pessoa).orElseThrow(() -> new PessoaNaoEncontradaException()));
    }

}
