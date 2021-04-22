package br.com.zup.ContatosMarketing.controllers;

import br.com.zup.ContatosMarketing.models.Contato;
import br.com.zup.ContatosMarketing.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    public ContatoService contatoService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Contato cadastrarContato(@RequestBody @Valid Contato contato){
        contatoService.cadastrarContato(contato);
        return contato;
    }

    @GetMapping("{email}/")
    public Contato buscarContatoPorEmail(@PathVariable String email){
        return contatoService.buscarContatoPorEmail(email);
    }

    @GetMapping
    public Iterable<Contato> listarContatos(){
        return contatoService.verTodosOsContatos();
    }

    @DeleteMapping("{email}/")
    public void deletarContatoPeloEmail(@PathVariable String email) {
        contatoService.deletarContato(email);
    }

    @GetMapping("/produto")
    public List<Contato> listarContatosPeloProduto(@RequestParam String nome){
        return contatoService.buscarContatosPorProduto(nome);
    }
}
