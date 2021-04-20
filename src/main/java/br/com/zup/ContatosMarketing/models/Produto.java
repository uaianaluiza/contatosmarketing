package br.com.zup.ContatosMarketing.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "produtos")

public class Produto {
    @Id
    private String nome;

    @ManyToMany
    private List<Categoria> categorias;

    public Produto(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
