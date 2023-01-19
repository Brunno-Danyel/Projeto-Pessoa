package application.services;

import application.Repositories.EnderecoRespository;
import application.Repositories.PessoaRepository;
import application.dto.PessoaDTO;
import application.entities.Pessoa;
import application.exception.PessoaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRespository enderecoRespository;

    public Pessoa criarPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaDTO.fromDTO(pessoaDTO);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa consultarPessoa(Long idPessoa) {
        return pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new PessoaException("Pessoa não encontrada na base de dados!"));
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

}
