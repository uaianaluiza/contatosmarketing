package br.com.zup.ContatosMarketing.DTOs;

import br.com.zup.ContatosMarketing.models.Produto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class ProdutoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @NotBlank
    @Size(min = 3,message = "Nome do produto deve ter no mínimo 3 caracteres")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto converterDTOparaModel(){
        Produto produto = new Produto();
        produto.setNome(this.nome);

        return produto;
    }
}
