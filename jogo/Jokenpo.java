package JokenpoClientServer.jogo;

import java.util.Random;

public class Jokenpo {

    public String jogar(String nome1, String player1){
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
        return jogar(nome1, player1, "Admin", player2);
        
    }

    public String jogar(String nome1, String player1, String nome2, String player2){
        String vencedor = "Ocorreu um erro, por favor feche a aplicação e abra novamente!";
        if(player1.equals("pedra") && player2.equals("tesoura")){
            vencedor = nome1 + " venceu!";
        }else if(player2.equals("pedra") && player1.equals("tesoura")){
            vencedor = nome2 + " venceu!";
        }

        if(player1.equals("tesoura") && player2.equals("papel")){
            vencedor = nome1 + " venceu!";
        }else if(player2.equals("tesoura") && player1.equals("papel")){
            vencedor = nome2 + " venceu!";
        }

        if(player1.equals("papel") && player2.equals("pedra")){
            vencedor = nome1 + " venceu!";
        }else if(player2.equals("papel") && player1.equals("pedra")){
            vencedor = nome2 + " venceu!";
        }

        if(player1.equals(player2)){
            vencedor = "Deu empate!";
        }

        return vencedor;
    }

}