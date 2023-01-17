package application.services;

import application.Repositories.PessoaRepository;
import application.entities.Pessoa;
import application.exception.PessoaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa consultarPessoa(Long idPessoa) {
        return pessoaRepository.findById(idPessoa).orElseThrow(() -> new PessoaException("Pessoa não encontrada na base de dados!"));
    }

    public List<Pessoa> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public Pessoa editarPessoa(Long idPessoa, Pessoa pessoa){
        pessoaRepository.findById(idPessoa).orElseThrow(() -> new PessoaException("Pessoa não encontrada na base de dados - Impossível editar!"));

        pessoa.setId(idPessoa);
     return pessoaRepository.save(pessoa);
    }

}
