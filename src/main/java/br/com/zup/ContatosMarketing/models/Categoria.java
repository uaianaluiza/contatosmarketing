package br.com.zup.ContatosMarketing.models;

import javax.persistence.*;


@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    private String nome;


    public Categoria(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
