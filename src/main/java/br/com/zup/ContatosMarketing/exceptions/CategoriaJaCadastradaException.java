package br.com.zup.ContatosMarketing.exceptions;

public class CategoriaJaCadastradaException extends ExcecaoBasica{

    public CategoriaJaCadastradaException() {
        super("Categoria já cadastrada", 422, "nome", "Unprocesable Entity");
    }
}
