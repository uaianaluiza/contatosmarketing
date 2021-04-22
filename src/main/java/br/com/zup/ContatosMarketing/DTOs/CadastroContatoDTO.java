package br.com.zup.ContatosMarketing.DTOs;

import br.com.zup.ContatosMarketing.models.Contato;
import br.com.zup.ContatosMarketing.models.Produto;

import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroContatoDTO {
    @NotBlank()
    @NotEmpty
    @Size(min = 3,max = 300,message = "Nome deve ter entre 3 e 300 caracteres")
    private String nomeCompleto;
    @NotBlank()
    @NotEmpty
    @Email
    @Id
    private String email;
    @NotNull
    private int telefone;
    private List<String> produtos;

    public CadastroContatoDTO(){

    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }

    public Contato converterDTOparaModel(){
        Contato contato = new Contato();
        contato.setEmail(this.email);
        contato.setNomeCompleto(this.nomeCompleto);
        contato.setTelefone(this.telefone);
        List<Produto> listaDeProdutos = new ArrayList<>();
        for(String nome: produtos){
            Produto produto = new Produto();
            produto.setNome(nome);
            listaDeProdutos.add(produto);
        }
        contato.setProdutos(listaDeProdutos);


        return contato;
    }
}
