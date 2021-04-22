package br.com.zup.ContatosMarketing.repositories;

import br.com.zup.ContatosMarketing.models.Contato;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ContatoRepository extends CrudRepository<Contato,String> {

    List<Contato> findAllByProdutosCategoriasNomeContains(String nome);
    List<Contato> findAllByProdutosNome(String nome);
}
