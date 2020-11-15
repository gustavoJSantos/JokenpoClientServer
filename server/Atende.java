package JokenpoClientServer.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import JokenpoClientServer.util.Comunicacao;
import JokenpoClientServer.util.Mensagem;
import JokenpoClientServer.jogo.Jokenpo;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.pro.br>
 */

public class Atende extends Thread {
    Socket cliente;
    Comunicacao comunicacao;
    ArrayList<Atende> atendimentos;
    String venceu = "";
    

    public Atende(Socket cliente, ArrayList<Atende> atendimentos) {
        this.cliente = cliente;
        this.atendimentos = atendimentos;
        comunicacao = new Comunicacao(cliente);
    }

    @Override
    public void run() {
        boolean online = true;
        Mensagem msg;
        Jokenpo jogo = new Jokenpo();

        while (online) {
            msg = (Mensagem) comunicacao.receive();
            if(msg == null){
                atendimentos.remove(this);
                online = false;
            }else{
                if(msg.getTipo() == 1){
                    venceu = jogo.jogar(msg.getNome(), msg.getTexto());
                    msg.setNome("Jogo do " + msg.getNome());
                    msg.setTexto(venceu);
                }
                if(msg.getTipo() == 2){
                    if(Servidor.getNome1().equals("")){
                        Servidor.setNome1(msg.getNome());
                        Servidor.setPlayer1(msg.getTexto());
                        msg.setNome("Admin");
                        msg.setTexto("O " + Servidor.getNome1() + " esta aguardando alguem para jogar Jokenpo\nTeste sua sorte e jogue com ele!");
                    }else{
                        Servidor.setNome2(msg.getNome());
                        Servidor.setPlayer2(msg.getTexto());
                        venceu = jogo.jogar(Servidor.getNome1(), Servidor.getPlayer1(), Servidor.getNome2(), Servidor.getPlayer2());
                        msg.setNome("Jogo entre o " + Servidor.getNome1() + " e " + Servidor.getNome2());
                        msg.setTexto(venceu);
                        Servidor.clear();
                    }
                }
                for (Atende atende : atendimentos) {
                    atende.enviar(msg);
                }
            }
        }

        try {
            cliente.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    public void enviar(Mensagem msg) {
        comunicacao.send(msg);
    }

}
