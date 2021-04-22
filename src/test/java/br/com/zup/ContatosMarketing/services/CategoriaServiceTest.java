package br.com.zup.ContatosMarketing.services;

import br.com.zup.ContatosMarketing.models.Categoria;
import br.com.zup.ContatosMarketing.repositories.CategoriaRepository;
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
}
