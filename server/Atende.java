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
                if(msg.getTexto().equals("!resultados")){
                    msg.setNome("Admin");
                    msg.setTexto("Estes são os resultados do dia:\n"+
                        "Jogos feitos: " + Servidor.getJogosFeitos()+"\n"+
                        "Vitorias do time azul: " + Servidor.getVitoriaAzul()+"\n"+
                        "Vitorias do time vermelho: " + Servidor.getVitoriaVerm()+"\n"+
                        "Vitorias do NPC: " + Servidor.getVitoriaNPC()+"\n"+
                        "Empates: " + Servidor.getEmpates()
                    );
                }
                if(msg.getTipo() == 1){
                    msg = jogo.jogar(msg);
                    msg.setNome("Jogo do " + msg.getNome());
                    Servidor.setVencedor(msg.getTime());
                }
                if(msg.getTipo() == 2){
                    if(Servidor.getNome1().equals("")){
                        Servidor.setNome1(msg.getNome());
                        Servidor.setPlayer1(msg.getTexto());
                        Servidor.setTime1(msg.getTime());
                        msg.setNome("Admin");
                        msg.setTexto("O " + Servidor.getNome1() + " do time " + Servidor.getTime1() + "\nesta aguardando alguem para jogar Jokenpo\nTeste sua sorte e jogue com ele!");
                    }else{
                        Servidor.setTime2(msg.getTime());
                        if(Servidor.timesIguais() == true){
                            Servidor.setTime2("");
                            msg.setNome("Admin");
                            msg.setTexto("Os jogadores não podem ser do mesmo time\npor favor troque de time e teste novamente\nOu espere acontecer o proximo jogo");
                        }else{
                            Mensagem player1 = new Mensagem(0, Servidor.getNome1(), Servidor.getPlayer1(), Servidor.getTime1());
                            Servidor.setNome2(msg.getNome());
                            Servidor.setPlayer2(msg.getTexto());
                            Servidor.setTime2(msg.getTime());
                            msg = jogo.jogar(player1, msg);
                            msg.setNome("Jogo entre o " + Servidor.getNome1() + " e " + Servidor.getNome2());
                            msg.setTexto(msg.getTexto()+"\nMais um ponto para "+ msg.getTime());
                            Servidor.setVencedor(msg.getTime());
                            Servidor.clear();
                        }
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
