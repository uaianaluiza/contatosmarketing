package br.com.zup.ContatosMarketing.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "produtos")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;

    @ManyToMany
    @JoinTable(name = "contatos_produtos",joinColumns = {@JoinColumn (name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "email")})
    private List<Contato> contatos;

    @ManyToMany
    @JoinTable(name = "categorias_produtos",joinColumns = {@JoinColumn (name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "nome")})
    private List<Categoria> categorias;

    public Produto(){
    }


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

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
