package JokenpoClientServer.client;

import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.JTextArea;

import JokenpoClientServer.util.Mensagem;

/**
 *
 * @author Gustavo Santos <gustavojspro@hotmail.com>
 */

public class Escuta extends Thread {
    Socket socket;
    ObjectInputStream in;
    JTextArea historico;

    public Escuta(Socket sc, JTextArea hist) {
        socket = sc;
        historico = hist;
    }

    @Override
    public void run() {
        Mensagem msg;
        Mensagem admin = new Mensagem("admin", "Bem vindo ao chat!\n\nPara jogar Jokenpo use o comando !jogar\nPara ver os resultados das equipes use o comando !resultados");
        try {
            in = new ObjectInputStream(socket.getInputStream());
        
            historico.append( admin.getNome() + "> " + admin.getTexto() + "\n");
            while (true) {
                msg = (Mensagem) in.readObject();
                if(msg != null){
                    historico.append( msg.getNome() + "> " + msg.getTexto() + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
