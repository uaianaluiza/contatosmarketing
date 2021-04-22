package br.com.zup.ContatosMarketing.services;

import br.com.zup.ContatosMarketing.models.Categoria;
import br.com.zup.ContatosMarketing.repositories.CategoriaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



@SpringBootTest
public class CategoriaServiceTest {

    @Autowired
    private CategoriaService categoriaService;

    @MockBean
    private CategoriaRepository categoriaRepository;

    private Categoria categoriaTeste;

    @BeforeEach
    public void setUp(){
        this.categoriaTeste = new Categoria();
        this.categoriaTeste.setNome("Cozinha");
    }

    @Test
    public void testarCadastrodeCategoriaOK(){
        Mockito.when(categoriaRepository.save(Mockito.any(Categoria.class))).thenReturn(categoriaTeste);
        Categoria testCategoria = categoriaService.cadastrarCategoria(categoriaTeste);
        Assertions.assertEquals(testCategoria,categoriaTeste);
    }


}
