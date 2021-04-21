package br.com.zup.ContatosMarketing.exceptions;

public class ContatoDuplicadoException extends ExcecaoBasica{
    public ContatoDuplicadoException(){
        super("Já existe um contato com este e-mail",
                422,
                "email",
                "Unprocesable Entity");
    }
}
