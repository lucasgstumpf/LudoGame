/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import Controller.Controller;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import src.Model.Movimento;

/**
 *
 * @author felipe.freitas_visag
 */
public class Conexao implements Runnable {

    /**
     * Objeto da classe Socket para a troca de mensagens durante o jogo
     */
    private Socket soc;
    
    /**
     * Thread que aguarda um novo oponente
     */
    private Thread hostThread;
    
    /**
     * Socket que aguarda um novo oponente
     */
    private ServerSocket servSoc;
    
    /**
     * Objeto que guarda o IP
     */
    private InetAddress ip;
    
    /**
     * Guarda a porta
     */
    private int port;
    
    /**
     * Objeto da classe CBController
     */
    public Controller controller;
    
    /**
     * Informa se o turno é do jogador ou do oponente
     */
    private boolean meuTurno;

    /**
     * Construtor da classe
     * 
     * @param controller CBController
     */
    public Conexao(Controller controller) {
        this.controller = controller;
    }

    public InetAddress getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isMeuTurno() {
        return meuTurno;
    }

    @Override
    public void run() {
        while (true) {
            recieveBoard();
            meuTurno = true;

        }
    }

    /**
     * Cria a conexão do host
     */
    public void initCon() {
        try {
            this.meuTurno = true;
            this.ip = InetAddress.getLocalHost();
            this.servSoc = new ServerSocket(5000);
            this.port = this.servSoc.getLocalPort();
            this.soc = this.servSoc.accept();
            this.servSoc.close();
            this.controller.jogadorEncontrado();
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

         
    public void sendBord(Movimento movimento) {
        try {
            this.meuTurno = false;
            ObjectOutputStream out = new ObjectOutputStream(this.soc.getOutputStream());
            out.writeObject(movimento);
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    private void recieveBoard() {
        try {
            ObjectInputStream in = new ObjectInputStream(this.soc.getInputStream());
            Movimento move = (Movimento) in.readObject();
            this.controller.setMove(move);
        } catch (IOException ex) {
            if (ex instanceof SocketException) {
                this.controller.interrupt();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Conecta com o host
     */
    public void conectar() {
        try {
            this.meuTurno = false;
            this.soc = new Socket(ip, port);
            this.controller.jogadorEncontrado();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falha na conexão!");
        }
    }

    /**
     * Disconecta
     */
    public void disconnect() {
        try {
            this.soc.close();
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cria a thread do host
     */
    public void host() {
        Host h = new Host(this);
        this.hostThread = new Thread(h);
        this.hostThread.start();
    }

    /**
     * Mata a thread do host
     */
    public void cancelHost() {
        this.hostThread.interrupt();
    }

    public void setMeuTurno(boolean meuTurno) {
        this.meuTurno = meuTurno;
    }
}
