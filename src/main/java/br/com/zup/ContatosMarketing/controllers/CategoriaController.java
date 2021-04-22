package br.com.zup.ContatosMarketing.controllers;

import br.com.zup.ContatosMarketing.models.Categoria;
import br.com.zup.ContatosMarketing.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categorias/")

public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria registrarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.cadastrarCategoria(categoria);
    }
}
