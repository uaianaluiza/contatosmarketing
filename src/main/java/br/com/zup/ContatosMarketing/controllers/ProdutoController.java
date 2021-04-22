package br.com.zup.ContatosMarketing.controllers;

import br.com.zup.ContatosMarketing.models.Produto;
import br.com.zup.ContatosMarketing.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
    public Produto registrarProduto (@RequestBody Produto produto){
      return produtoService.cadastrarProduto(produto);
  }
  @GetMapping
    public List<Produto> listarProdutos(){
      return produtoService.mostrarTodosOsProdutos();
  }
  @GetMapping("{id}/")
    public Produto buscarProdutoPeloId(@PathVariable int id) {
      return produtoService.buscarProdutoPeloId(id);
  }
}
