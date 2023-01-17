package application.controller;

import application.entities.Pessoa;
import application.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.criarPessoa(pessoa);
    }

    @PutMapping("editar/{idPessoa}")
    public ResponseEntity<Pessoa> editarPessoa(@PathVariable Long idPessoa, @RequestBody Pessoa pessoa) {
        Pessoa pessoaObj = pessoaService.editarPessoa(idPessoa, pessoa);
        return ResponseEntity.ok().body(pessoaObj);
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
