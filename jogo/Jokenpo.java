package jogo;

import java.util.Scanner;

public class Jokenpo {
    public static void main(String[]args){
        String player1 = "";
        String player2 = "";

        Scanner entrada = new Scanner(System.in);

        boolean valido = false;

        while(valido == false){
            System.out.println("informe a entrada 1");
            player1 = entrada.nextLine();

            player1 = player1.toLowerCase();
            
            switch(player1){
                case "pedra":
                    valido = true;
                break;
                case "papel":
                    valido = true;
                break;
                case "tesoura":
                    valido = true;
                break;
                default:
                    valido = false;
                    System.out.println("caractere invalido, tente novamente");
                break;
            }
        }

        valido = false;

        while(valido == false){
            System.out.println("informe a entrada 2");
            player2 = entrada.nextLine();

            player2 = player2.toLowerCase();
            
            switch(player2){
                case "pedra":
                    valido = true;
                break;
                case "papel":
                    valido = true;
                break;
                case "tesoura":
                    valido = true;
                break;
                default:
                    valido = false;
                    System.out.println("caractere invalido, tente novamente");
                break;
            }
        }

        if(player1.equals("pedra") && player2.equals("tesoura")){
            System.out.println("player 1 venceu");
        }else if(player2.equals("pedra") && player1.equals("tesoura")){
            System.out.println("player 2 venceu");
        }

        if(player1.equals("tesoura") && player2.equals("papel")){
            System.out.println("player 1 venceu");
        }else if(player2.equals("tesoura") && player1.equals("papel")){
            System.out.println("player 2 venceu");
        }

        if(player1.equals("papel") && player2.equals("pedra")){
            System.out.println("player 1 venceu");
        }else if(player2.equals("papel") && player1.equals("pedra")){
            System.out.println("player 2 venceu");
        }

    }
    /*public String jogo(){
        

    }*/

}