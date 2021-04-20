package br.com.zup.ContatosMarketing.DTOs;

import br.com.zup.ContatosMarketing.models.Categoria;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class CategoriaDTO {
    @NotEmpty
    @NotBlank
    @Size(min = 3,message = "Nome da categoria deve ter no mínimo 3 caracteres")
    private String nome;

    @ManyToMany
    private List<ProdutoDTO> produtos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converterDTOparaModel(){
        Categoria categoria = new Categoria();
        categoria.setNome(this.nome);

        return categoria;
    }
}
