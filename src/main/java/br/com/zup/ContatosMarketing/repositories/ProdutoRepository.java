package br.com.zup.ContatosMarketing.repositories;

import br.com.zup.ContatosMarketing.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto,Integer> {
}
