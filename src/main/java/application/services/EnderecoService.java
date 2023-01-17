package application.services;

import application.Repositories.EnderecoRespository;
import application.entities.Endereco;
import application.entities.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRespository enderecoRespository;

    @Autowired
    private PessoaService pessoaService;

    public Endereco criarEndereco(Endereco endereco){
        Long idPessoa = endereco.getPessoa().getId();
        Pessoa pessoa = pessoaService.consultarPessoa(endereco.getPessoa().getId());

        endereco.setPessoa(pessoa);
        return enderecoRespository.save(endereco);
    }
}
