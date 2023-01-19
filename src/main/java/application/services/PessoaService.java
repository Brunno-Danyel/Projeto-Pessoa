package application.services;

import application.Repositories.EnderecoRepository;
import application.Repositories.PessoaRepository;
import application.dto.PessoaDTO;
import application.entities.Pessoa;
import application.exception.PessoaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Pessoa criarPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaDTO.fromDTO(pessoaDTO);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa consultarPessoa(Long idPessoa) {
        return pessoaRepository.findById(idPessoa).orElseThrow(() -> new PessoaNaoEncontradaException());
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

}
