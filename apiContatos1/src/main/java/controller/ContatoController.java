package controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import entity.Contato;
import service.ContatoService;
import repository.ContatoRepository;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @PostMapping
    @Operation(summary = "Adiciona um novo Contato a uma Pessoa")
    public Contato createContato(@RequestBody Contato contato) {
        return contatoService.createContato(null, contato);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna os dados de um Contato por ID")
    public ResponseEntity<Contato> getContatoById(@PathVariable Long id) {
        Contato contato = contatoService.getContatoById(id)
            .orElseThrow(() -> new RuntimeException("Contato not found for this id :: " + id));
        return ResponseEntity.ok().body(contato);
    }

    @GetMapping
    @Operation(summary = "Lista todos os Contatos")
    public List<Contato> getAllContatos() {
        return contatoService.getAllContatos();
    }

    @GetMapping("/pessoa/{idPessoa}")
    @Operation(summary = "Lista todos os Contatos de uma Pessoa")
    public List<Contato> getContatosByPessoaId(@PathVariable Long idPessoa) {
        return contatoService.getContatosByPessoaId(idPessoa);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um Contato existente")
    public ResponseEntity<Contato> updateContato(@PathVariable Long id, @RequestBody Contato contatoDetails) {
        Contato updatedContato = contatoService.updateContato(id, contatoDetails);
        return ResponseEntity.ok(updatedContato);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um Contato por ID")
    public ResponseEntity<Void> deleteContato(@PathVariable Long id) {
        contatoService.deleteContato(id);
        return ResponseEntity.noContent().build();
    }
}