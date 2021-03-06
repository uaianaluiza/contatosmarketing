package br.com.zup.ContatosMarketing.services;

import br.com.zup.ContatosMarketing.exceptions.ProdutoNaoExisteException;
import br.com.zup.ContatosMarketing.models.Produto;
import br.com.zup.ContatosMarketing.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ContatoService contatoService;

    public Produto cadastrarProduto (Produto produto){
        try{ Produto obj = produtoRepository.save(produto);
            return produto;
        }catch (Exception error){
           throw new  RuntimeException("Produto já cadastrado");
        }
    }

    public List<Produto> mostrarTodosOsProdutos(){
        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();
        return produtos;
    }

    public Produto buscarProdutoPeloId(int id){
        Optional<Produto> optionalProduto = produtoRepository.findById(id);

        if ( optionalProduto.isPresent()){
            return optionalProduto.get();
        }
        throw new ProdutoNaoExisteException();
    }

    public Produto buscarProdutoPeloNome(String nome){
        Optional<Produto> optionalProduto = produtoRepository.findByNome(nome);

        if ( optionalProduto.isPresent()){
            return optionalProduto.get();
        }
        throw new ProdutoNaoExisteException();
    }
    public void deletarProdutoPeloId(int id){
        produtoRepository.deleteById(id);
    }

}
