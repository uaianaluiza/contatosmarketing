package br.com.zup.ContatosMarketing.exceptions;

public class ObjetoErro {
    private String mensagem;
    private String campo;

    public ObjetoErro() { }

    public ObjetoErro(String mensagem, String campo) {
        this.mensagem = mensagem;
        this.campo = campo;
    }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getCampo() { return campo; }
    public void setCampo(String campo) { this.campo = campo; }
}
