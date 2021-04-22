package br.com.zup.ContatosMarketing.services;

import br.com.zup.ContatosMarketing.models.Categoria;
import br.com.zup.ContatosMarketing.models.Contato;
import br.com.zup.ContatosMarketing.repositories.CategoriaRepository;
import br.com.zup.ContatosMarketing.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    public Categoria cadastrarCategoria (Categoria categoria){
        try{
            Categoria obj = categoriaRepository.save(categoria);
            return categoria;
        }catch (Exception error){
            throw new  RuntimeException("Categoria já cadastrado");
        }
    }

    public Categoria buscarCategoriaPeloNome(String nome){
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(nome);

        if ( optionalCategoria.isPresent()){
            return optionalCategoria.get();
        }
        throw new RuntimeException("Categoria não existe");
    }

    public List<Categoria> visualizarTodasAsCategorias(){
        List<Categoria> categorias = (List<Categoria>) categoriaRepository.findAll();
        return categorias;
    }

    public void deletarCategoriaPeloNome(String nome){
       categoriaRepository.deleteById(nome);
    }






}
