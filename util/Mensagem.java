package JokenpoClientServer.util;

import java.io.Serializable;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.pro.br>
 */

public class Mensagem implements Serializable {
    private static final long serialVersionUID = 1L;

    private int tipo;
    private String nome, texto, time;

    public Mensagem(int tipo, String nome, String texto, String time) {
        this.tipo = tipo;
        this.nome = nome;
        this.texto = texto;
        this.time = time;
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

    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }

}
