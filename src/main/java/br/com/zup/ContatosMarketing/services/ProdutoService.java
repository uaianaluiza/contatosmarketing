package br.com.zup.ContatosMarketing.services;

import br.com.zup.ContatosMarketing.models.Produto;
import br.com.zup.ContatosMarketing.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto (Produto produto){
        try{
            Produto obj = produtoRepository.save(produto);
            return produto;
        }catch (Exception error){
           throw new  RuntimeException("Produto já cadastrado");
        }
    }
}
