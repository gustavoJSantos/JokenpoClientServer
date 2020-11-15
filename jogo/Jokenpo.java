package JokenpoClientServer.jogo;

import java.util.Random;

import JokenpoClientServer.util.Mensagem;

/**
 *
 * @author Gustavo Santos <gustavojspro@hotmail.com>
 */

public class Jokenpo {

    public Mensagem jogar(Mensagem msg){
        Random rand = new Random();
        int jogada = rand.nextInt(3)+1;
        String player2 = "";

        if(jogada == 1){
            player2 = "pedra";
        }else if(jogada == 2){
            player2 = "papel";
        }else if(jogada == 3){
            player2 = "tesoura";
        }
        
        Mensagem msg2 = new Mensagem(0, "Admin", player2, "NPC");
        return jogar(msg, msg2);
        
    }

    public Mensagem jogar(Mensagem msg1, Mensagem msg2){
        Mensagem vencedor = new Mensagem(0, "Admin", "Ocorreu um erro, por favor feche a aplicação e abra novamente!", "nenhum");
        if(msg1.getTexto().equals("pedra") && msg2.getTexto().equals("tesoura")){
            vencedor = msg1;
            vencedor.setTexto(msg1.getNome() + " venceu!");
        }else if(msg2.getTexto().equals("pedra") && msg1.getTexto().equals("tesoura")){
            vencedor = msg2;
            vencedor.setTexto(msg2.getNome() + " venceu!");
        }

        if(msg1.getTexto().equals("tesoura") && msg2.getTexto().equals("papel")){
            vencedor = msg1;
            vencedor.setTexto(msg1.getNome() + " venceu!");
        }else if(msg2.getTexto().equals("tesoura") && msg1.getTexto().equals("papel")){
            vencedor = msg2;
            vencedor.setTexto(msg2.getNome() + " venceu!");
        }

        if(msg1.getTexto().equals("papel") && msg2.getTexto().equals("pedra")){
            vencedor = msg1;
            vencedor.setTexto(msg1.getNome() + " venceu!");
        }else if(msg2.getTexto().equals("papel") && msg1.getTexto().equals("pedra")){
            vencedor = msg2;
            vencedor.setTexto(msg2.getNome() + " venceu!");
        }

        if(msg1.getTexto().equals(msg2.getTexto())){
            vencedor = msg1;
            vencedor.setTexto("Deu empate!");
            vencedor.setTime("empate");
        }

        return vencedor;
    }

}