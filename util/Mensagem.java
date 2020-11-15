package JokenpoClientServer.util;

import java.io.Serializable;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.pro.br>
 */

public class Mensagem implements Serializable {
    private static final long serialVersionUID = 1L;

    private int tipo;
    private String nome, texto;

    public Mensagem(int tipo, String nome, String texto) {
        this.tipo = tipo;
        this.nome = nome;
        this.texto = texto;
    }
    public Mensagem(String nome, String texto) {
        this.nome = nome;
        this.texto = texto;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public int getTipo(){
        return tipo;
    }

}
