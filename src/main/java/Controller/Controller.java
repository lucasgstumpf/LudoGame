/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.Conexao;
import View.MainFrame;
import View.UITabuleiro;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import src.Model.Jogo;
import src.Model.Movimento;

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

    private boolean isHost;

    private int valorDado;

    /**
     * Objeto da classe MainFrame
     */
    private MainFrame mf;

    public Controller() {
        this.jogo = new Jogo();
        this.con = new Conexao(this);
        this.jogo.reiniciarTabuleiro();
        this.isHost = true;
    }

    public boolean isMyTurn() {
        return this.con.isMeuTurno();
    }

    public Integer movePiece(Movimento movimento) {
        movimento.setValorDado(valorDado);
        Integer valorCasaAtual = null;
        if (this.con.isMeuTurno()) {
            this.con.sendBord(movimento);
            valorCasaAtual = this.jogo.mover(movimento);
            this.mf.setTurn("Vez do oponente");
        }

        fimDeJogo();
        return valorCasaAtual;
    }

    public void setMove(Movimento movimento) {
        //Verifica desistência
        if (movimento.getValorDado() == null) {
            JOptionPane.showMessageDialog(null, "Seu Oponente Desistiu !");
            this.mf.setTitle("Damas");
            this.mf.getDesistir().setEnabled(false);
            this.mf.getMenu().setEnabled(true);
            this.con.disconnect();
            this.con.setMeuTurno(false);
            return;
        }
        
        this.mf.receiveMovimento(movimento);
        this.mf.setTurn("Sua vez!");
    }

    public boolean fimDeJogo() {
        int index;

        if (this.isHost) {
            index = 0;
        } else {
            index = 1;
        }

        if (this.jogo.fimDeJogo(index)) {
            if (this.jogo.isVencedor()) {
                JOptionPane.showMessageDialog(null, "Parabéns, você é o vencedor");
            } else {
                JOptionPane.showMessageDialog(null, "Você foi derrotado");
            }

            this.con.disconnect();
            this.jogoThread.interrupt();
            return true;
        }
        return false;
    }

    public void conectar(String ip, int port) {
        try {
            this.con.setPort(port);
            this.con.setIp(InetAddress.getByName(ip));
            this.con.conectar();
            this.isHost = false;
        } catch (UnknownHostException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void jogadorEncontrado() {
        this.jogoThread = new Thread(this.con);
        this.jogoThread.start();

        JOptionPane.showMessageDialog(null, "Oponente conectado!");
        this.mf.setTitle("Ludo - Em jogo");
        this.mf.getDesistir().setEnabled(true);
        this.mf.getMenu().setEnabled(false);
        this.mf.setHost(false);
        this.jogo.reiniciarTabuleiro();
        if (this.con.isMeuTurno()) {
            this.mf.setTurn("Sua vez!");
        } else {
            this.mf.setTurn("Vez do oponente");
        }
    }

    public int rodarDado() {
        setValorDado(jogo.rodarDado());
        return valorDado;
    }

    public void desistir() {
        Movimento movimento = new Movimento(null, null, null);
        this.con.sendBord(movimento);
        this.jogoThread.interrupt();
        this.mf.getDesistir().setEnabled(false);
        this.mf.getMenu().setEnabled(true);
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

    public int getValorDado() {
        return valorDado;
    }

    public void setValorDado(int valorDado) {
        this.valorDado = valorDado;
    }

    public boolean isIsHost() {
        return isHost;
    }

}
