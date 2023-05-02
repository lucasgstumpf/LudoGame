/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.Conexao;
import View.Main;
import View.MainFrame;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import src.Model.Jogo;

/**
 *
 * @author felipe.freitas_visag
 */
public class Controller {
    
     /**
     * Objeto da classe Connection
     */
    private Conexao con;
    
    /**
     * Thread para receber a jogada do oponente
     */
    private Thread jogoThread;
    
    /**
     * Objeto da classe Game
     */
    private Jogo jogo;
    
    /**
     * Objeto da classe MainFrame
     */
    private MainFrame mf;

    public Controller() {
        this.jogo = new Jogo();
        this.con = new Conexao(this);
        this.jogo.reiniciarTabuleiro();
    }
    
    public boolean isMyTurn() {
        return this.con.isMeuTurno();
    }
    
    public boolean fimDeJogo() {
        
        if (this.jogo.fimDeJogo()) {
            if (this.jogo.isVencedor()) {
                JOptionPane.showMessageDialog(null, "Parabéns, você é o vencedor");
            } else {
                JOptionPane.showMessageDialog(null, "Você foi derrotado");
            }

            this.con.disconnect();
            this.jogoThread.interrupt();
            //this.mf.getMenu().setEnabled(true);
            return true;
        }
        return false;
    }
    
    public void conectar(String ip, int port) {
        try {
            this.con.setPort(port);
            this.con.setIp(InetAddress.getByName(ip));
            this.con.conectar();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void jogadorEncontrado() {
        this.jogoThread = new Thread(this.con);
        this.jogoThread.start();

        JOptionPane.showMessageDialog(null, "Oponente conectado!");
        this.mf.setTitle("Ludo - Em jogo");
        this.mf.getConcede().setEnabled(true);
        this.mf.getMenu().setEnabled(false);
        this.mf.setHost(false);
        this.mf.getCheckerBoard().rebuild(8, 8, 3);
        this.jogo.reiniciarTabuleiro();
        //Move m = new Move(null,0,null,this.jogo.getBoard());
        if(this.con.isMeuTurno()){
            this.mf.setTurn("Sua vez!");
        }else{
            this.mf.setTurn("Vez do oponente");
        }
        this.mf.clearLog();
        //this.mf.getCheckerBoard().repaintBoard(m);
    }
    
    public void desistir() {
        //Move m = new Move(null, 0, null, null);
        //this.con.sendBord(m);
        this.jogoThread.interrupt();
        System.out.println("Desistiu legal");
    }
    
    public String getIP() {
        return this.con.getIp().getHostAddress();
    }

    public String getPort() {
        return Integer.toString(this.con.getPort());
    }    
    
    public void host() {
        this.con.host();
    }

    public void cancelHost() {
        this.con.cancelHost();
    }
    
    public void interrupt() {
        this.jogoThread.interrupt();
    }
    
    public void setMF(MainFrame mf) {
        this.mf = mf;
    }
}
