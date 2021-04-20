package br.com.zup.ContatosMarketing.controllers;

import br.com.zup.ContatosMarketing.DTOs.CadastroContatoDTO;
import br.com.zup.ContatosMarketing.models.Contato;
import br.com.zup.ContatosMarketing.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    public ContatoService contatoService;

    @PostMapping("/")
    public Contato cadastrarContato(@RequestBody @Valid CadastroContatoDTO contatoDTO){
        Contato contato = contatoDTO.converterDTOparaModel();
        return contatoService.cadastrarContato(contato);
    }

}
