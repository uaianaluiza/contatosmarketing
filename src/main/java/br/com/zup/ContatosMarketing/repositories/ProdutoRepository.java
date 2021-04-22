package br.com.zup.ContatosMarketing.repositories;

import br.com.zup.ContatosMarketing.models.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProdutoRepository extends CrudRepository<Produto,Integer> {

   Optional<Produto> findByNome(String nome);

}
