package JokenpoClientServer.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.pro.br>
 */
public class Servidor {
    private static ArrayList<Atende> atendimentos = new ArrayList<>();
    private static String nome1 = "";
    private static String player1 = "";
    private static String nome2 = "";
    private static String player2 = "";
    private static String time1 = "";
    private static String time2 = "";
    private static int jogosFeitos = 0;
    private static int vitoriaAzul = 0;
    private static int vitoriaVerm = 0;
    private static int empates = 0;
    private static int vitoriaNPC = 0;

    public static void main(String[] args) {
        final int PORTA = 9876;
        ServerSocket srv;
        Socket cliente;

        try {
            srv = new ServerSocket(PORTA);
            while (true) {
                System.out.println("Aguardando conexão...");
                cliente = srv.accept();
                Atende atende = new Atende(cliente, atendimentos);
                atende.start();
                atendimentos.add(atende);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    public static String getNome1() {
        return nome1;
    }

    public static void setNome1(String newName) {
        nome1 = newName;
    }

    public static String getPlayer1() {
        return player1;
    }

    public static void setPlayer1(String newPlayer) {
        player1 = newPlayer;
    }

    public static String getNome2() {
        return nome2;
    }

    public static void setNome2(String newName) {
        nome2 = newName;
    }

    public static String getPlayer2() {
        return player2;
    }

    public static void setPlayer2(String newPlayer) {
        player2 = newPlayer;
    }

    public static String getTime1() {
        return time1;
    }

    public static void setTime1(String time) {
        time1 = time;
    }

    public static String getTime2() {
        return time2;
    }

    public static void setTime2(String time) {
        time2 = time;
    }

    public static boolean timesIguais(){
        if(time1.equals(time2)){
            return true;
        }else{
            return false;
        }
    }

    public static void clear(){
        nome1 = "";
        player1 = "";
        nome2 = "";
        player2 = "";
        time1 = "";
        time2 = "";
    }


    public static void setVencedor(String time) {
        Servidor.jogosFeitos += 1;
        switch(time){
            case "azul":
                vitoriaAzul += 1;
            break;
            case "vermelho":
                vitoriaVerm += 1;
            break;
            case "NPC":
                vitoriaNPC += 1;
            break;
            case "empate":
                empates += 1;
            break;
            default:
            break;
        }
    }

    public static int getJogosFeitos() {
        return jogosFeitos;
    }

    public static int getVitoriaAzul() {
        return vitoriaAzul;
    }

    public static int getVitoriaVerm() {
        return vitoriaVerm;
    }

    public static int getEmpates() {
        return empates;
    }

    public static int getVitoriaNPC() {
        return vitoriaNPC;
    }

    

}
