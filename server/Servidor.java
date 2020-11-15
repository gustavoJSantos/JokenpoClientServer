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

    public static void clear(){
        nome1 = "";
        player1 = "";
        nome2 = "";
        player2 = "";
    }

}
