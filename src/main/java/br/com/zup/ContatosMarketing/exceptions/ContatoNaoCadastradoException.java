package br.com.zup.ContatosMarketing.exceptions;

public class ContatoNaoCadastradoException extends ExcecaoBasica{
    public ContatoNaoCadastradoException(){
        super(
                "Não existe um contato com este e-mail",
                422,
                "email",
                "Not Found"
        );
    }
}
