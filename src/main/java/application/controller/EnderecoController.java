package application.controller;

import application.Repositories.EnderecoRespository;
import application.dto.EnderecoDTO;
import application.entities.Endereco;
import application.entities.Pessoa;
import application.exception.EnderecoException;
import application.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRespository enderecoRespository;

    @PostMapping
    public Endereco criarEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        return enderecoService.criarEndereco(enderecoDTO);
    }

    @GetMapping("pessoa/{pessoa}")
    public ResponseEntity<Optional<List<Endereco>>> findByEnderecoPessoa(@PathVariable Pessoa pessoa) {
        Optional<List<Endereco>> EnderecoPessoa = enderecoService.consultarEnderecosPessoa(pessoa);
        return ResponseEntity.ok().body(EnderecoPessoa);
    }

    @PutMapping("editar/{idEndereco}")
    public void editarEndereco(@PathVariable Long idEndereco, @RequestBody Endereco endereco) {
        enderecoRespository.findById(idEndereco).map(enderecoExistente -> {
            endereco.setId(idEndereco);
            enderecoRespository.save(endereco);
            return enderecoExistente;
        }).orElseThrow(() -> new EnderecoException("Endereço inexistente!"));
    }
}
