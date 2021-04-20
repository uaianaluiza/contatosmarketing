package br.com.zup.ContatosMarketing.DTOs;

import br.com.zup.ContatosMarketing.models.Contato;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CadastroContatoDTO {
    @NotBlank()
    @NotEmpty
    @Size(min = 3,max = 300,message = "Nome deve ter entre 3 e 300 caracteres")
    private String nomeCompleto;
    @NotBlank()
    @NotEmpty
    @Email
    private String email;
    @NotBlank()
    @NotEmpty
    private int telefone;

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

    public Contato converterDTOparaModel(){
        Contato contato = new Contato();
        contato.setEmail(this.email);
        contato.setNomeCompleto(this.nomeCompleto);
        contato.setTelefone(this.telefone);

        return contato;
    }
}
