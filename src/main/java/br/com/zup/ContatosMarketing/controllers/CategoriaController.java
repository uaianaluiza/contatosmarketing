package br.com.zup.ContatosMarketing.controllers;

import br.com.zup.ContatosMarketing.models.Categoria;
import br.com.zup.ContatosMarketing.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{nome}/")
    public Categoria buscarCategoriaPeloNome(@PathVariable String nome) {
        return categoriaService.buscarCategoriaPeloNome(nome);
    }

    @GetMapping
    public List<Categoria> verTodasAsCategoriasCadastradas() {
        return categoriaService.visualizarTodasAsCategorias();
    }

    @DeleteMapping("{nome}/")
    public void deletarCategoria( @PathVariable String nome){
        categoriaService.deletarCategoriaPeloNome(nome);
    }
}
