package application.controller;

import application.Repositories.PessoaRepository;
import application.dto.PessoaDTO;
import application.entities.Pessoa;
import application.exception.PessoaNaoEncontradaException;
import application.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    @ResponseStatus(CREATED)
    public Pessoa criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaService.criarPessoa(pessoaDTO);
    }

    @PutMapping("editar/{idPessoa}")
    @ResponseStatus(NO_CONTENT)
    public void editarPessoa(@PathVariable Long idPessoa, @RequestBody Pessoa pessoa) {

        pessoaRepository.findById(idPessoa).map(pessoaExistente -> {
            pessoa.setId(idPessoa);
            pessoaRepository.save(pessoa);
            return pessoaExistente;
        }).orElseThrow(() -> new PessoaNaoEncontradaException());

    }

    @GetMapping("consultar/{idPessoa}")
    public ResponseEntity<Pessoa> consultarPessoa(@PathVariable Long idPessoa) {
        Pessoa pessoa = pessoaService.consultarPessoa(idPessoa);
        return ResponseEntity.ok().body(pessoa);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoa(Pessoa pessoa) {
        List<Pessoa> listPessoa = pessoaService.listarPessoas();
        return ResponseEntity.ok().body(listPessoa);
    }
}
