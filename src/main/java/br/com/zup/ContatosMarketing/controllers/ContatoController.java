package br.com.zup.ContatosMarketing.controllers;

import br.com.zup.ContatosMarketing.DTOs.CadastroContatoDTO;
import br.com.zup.ContatosMarketing.models.Categoria;
import br.com.zup.ContatosMarketing.models.Contato;
import br.com.zup.ContatosMarketing.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Contato cadastrarContato(@RequestBody @Valid CadastroContatoDTO contatoDTO){
        return contatoService.cadastrarContato(contatoDTO.converterDTOparaModel());
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


    @GetMapping("/categoria")
    public List<Contato> verContatosPelaCategoria(@RequestParam String nome){
        return contatoService.listarContatosPelaCategoria(nome);
    }

    @GetMapping("/produto")
    public List<Contato> verContatosPeloProduto(@RequestParam String nome){
        return contatoService.pesquisarContatoPorProduto(nome);
    }


}
