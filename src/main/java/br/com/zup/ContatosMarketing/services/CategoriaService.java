package br.com.zup.ContatosMarketing.services;

import br.com.zup.ContatosMarketing.models.Categoria;
import br.com.zup.ContatosMarketing.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
