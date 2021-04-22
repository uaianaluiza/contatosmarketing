package br.com.zup.ContatosMarketing.exceptions;

public class CategoriaNaoExisteException extends ExcecaoBasica{
    public CategoriaNaoExisteException() {
        super("Categoria não existe", 422, "nome", "Not Found");
    }
}
