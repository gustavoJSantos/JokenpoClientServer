package util;

import java.io.Serializable;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.pro.br>
 */

public class Mensagem implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome, texto;

    public Mensagem(String nome, String texto) {
        this.nome = nome;
        this.texto = texto;
    }

    public String getNome() {
        return nome;
    }

    public String getTexto() {
        return texto;
    }

}
