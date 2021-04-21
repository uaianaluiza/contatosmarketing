package br.com.zup.ContatosMarketing.controllers;

import br.com.zup.ContatosMarketing.models.Contato;
import br.com.zup.ContatosMarketing.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

}
