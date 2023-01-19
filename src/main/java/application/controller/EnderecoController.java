package application.controller;

import application.Repositories.EnderecoRepository;
import application.dto.EnderecoDTO;
import application.entities.Endereco;
import application.entities.Pessoa;
import application.exception.EnderecoException;
import application.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public Endereco criarEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        return enderecoService.criarEndereco(enderecoDTO);
    }


    @GetMapping("pessoa/{pessoa}")
    public ResponseEntity<Optional<List<Endereco>>> listarEnderecosPessoa(@PathVariable Pessoa pessoa) {
        Optional<List<Endereco>> enderecos = enderecoService.buscarEnderecosPessoa(pessoa);
        return ResponseEntity.ok().body(enderecos);
    }

    @PutMapping("editar/{idEndereco}")
    public void editarEndereco(@PathVariable Long idEndereco, @RequestBody Endereco endereco) {
        enderecoRepository.findById(idEndereco).map(enderecoExistente -> {
            endereco.setId(idEndereco);
            enderecoRepository.save(endereco);
            return enderecoExistente;
        }).orElseThrow(() -> new EnderecoException("Endereço inexistente!"));
    }
}
