package br.com.zup.ContatosMarketing.services;

import br.com.zup.ContatosMarketing.exceptions.ContatoNaoCadastradoException;
import br.com.zup.ContatosMarketing.models.Contato;
import br.com.zup.ContatosMarketing.models.Produto;
import br.com.zup.ContatosMarketing.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ProdutoService produtoService;


    public Contato verificarEmailJaCadastrado(String email) {
        Optional<Contato> optionalContato = contatoRepository.findById(email);

        if(optionalContato.isPresent()){
            return optionalContato.get();
        }
        throw new RuntimeException("Email já cadastrado");
    }

    public Contato cadastrarContato(Contato contato) {
            try {
                contato.setProdutos(recuperarProdutosSalvos(contato.getProdutos()));
                Contato objContato = contatoRepository.save(contato);
                return contato;
            }catch (Exception error){
                throw new RuntimeException("Já existe um contato com este e-mail");
            }
    }

    private List<Produto> recuperarProdutosSalvos(List<Produto> produtos){
        List<Produto> produtosSalvos = new ArrayList<>();
        for (Produto item: produtos ){
            produtosSalvos.add(
                    produtoService.buscarProdutoPeloNome(item.getNome()));
        }
        return produtosSalvos;
    }

    public Contato buscarContatoPorEmail(String email) {
        Optional<Contato> contato = contatoRepository.findById(email);

        if ( contato.isPresent() ) {
            return contato.get();
        }
        throw new ContatoNaoCadastradoException();
    }

    public Iterable<Contato> verTodosOsContatos(){
        Iterable<Contato> contatos = contatoRepository.findAll();
        return contatos;
    }
    public void deletarContato(String email){
        contatoRepository.deleteById(email);
    }

    public List<Contato> listarContatosPelaCategoria(String nome) {
        System.out.println(nome);
        List<Contato> contatos = contatoRepository.findAllByProdutosCategoriasNomeContains(nome);
        System.out.println(contatos);
        return contatos;
    }

    public List<Contato> pesquisarContatoPorProduto(String nome){
        List<Contato> contatos = contatoRepository.findAllByProdutosNome(nome);
        return contatos;
    }

}
