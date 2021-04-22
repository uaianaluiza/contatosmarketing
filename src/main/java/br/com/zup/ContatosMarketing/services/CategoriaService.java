package br.com.zup.ContatosMarketing.services;

import br.com.zup.ContatosMarketing.models.Categoria;
import br.com.zup.ContatosMarketing.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

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
}
