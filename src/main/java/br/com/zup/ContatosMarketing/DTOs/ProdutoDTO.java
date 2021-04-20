package br.com.zup.ContatosMarketing.DTOs;

import br.com.zup.ContatosMarketing.models.Categoria;
import br.com.zup.ContatosMarketing.models.Produto;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class ProdutoDTO {

    @NotEmpty
    @NotBlank
    @Size(min = 3,message = "Nome do produto deve ter no mínimo 3 caracteres")
    private String nome;

    @ManyToMany
    private List<CategoriaDTO> categorias;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto converterDTOparaModel(){
        Produto produto = new Produto();
        produto.setNome(this.nome);

        return produto;
    }
}
