/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Gaspar
 */
public class MainFrame extends JFrame {

    private Controller controller;
     
    private JMenuBar menuBar;
    private JMenu menu;
    
    private JMenuItem host;
    private JMenuItem connect;
    
    private JButton desistir;
    private JButton regras;
    
    private JPanel rightPanel;

    private JLabel turn;
            
    private boolean isHost;
 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public MainFrame() {
        UITabuleiro tabuleiro = new UITabuleiro();

        controller = new Controller();
        controller.setMF(this);

        createMenu();
        this.setTitle("Ludo");
        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(500, 500)); // define o tamanho do painel da direitasssssssssssssssssssssssssss
        createLabel();
        createButtonDesistir();
        createButtonRegras();
        this.setLayout(new BorderLayout());
        rightPanel.setLayout(new FlowLayout());

        //Cria o Botao como jogar     
        regras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Mensagem 1\nMensagem 2", "Como jogar!", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        rightPanel.add(regras);
        this.add(tabuleiro, BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.EAST);
        //Botao Desistir
        rightPanel.add(desistir);
        desistir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showOptionDialog( null,  "Deseja continuar?", "Desistir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, new String[] {"Quero!", "Não, vou continuar jogando"},"Sim");
                if (resposta == JOptionPane.YES_OPTION) {
                    // O usuário clicou no botão "OK"
                    // Encerra o aplicativo
                    controller.desistir();
                }
            }
        });
        
        host.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == host) {
                    hostAction();
                }
            }
        });
        
        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == connect) {
                    connectAction();
                }
            }
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    private void createButtonDesistir() {
        this.desistir = new JButton("Desistir");
        rightPanel.add(desistir);
        this.desistir.setFont(new Font("Dialog", Font.BOLD, 15));
        this.desistir.setEnabled(false);

        add(desistir);
    }

    private void createButtonRegras() {
        this.regras = new JButton("Regras");
        rightPanel.add(regras);
        this.regras.setFont(new Font("Dialog", Font.BOLD, 15));
        this.regras.setEnabled(true);
    }
    
    private void createLabel() {
        this.turn = new JLabel("Turno", JLabel.CENTER);
        this.turn.setFont(new Font("Dialog", Font.BOLD, 16));
        rightPanel.add(turn);
    }
    
    public void createMenu() {
        this.menuBar = new JMenuBar();
        menu = new JMenu();
        menu.setText("Jogar");
        host = new JMenuItem();
        host.setName("hostBtn");
        host.setText("Ser host");

        connect = new JMenuItem();
        connect.setName("conectarBtn");
        connect.setText("Conectar");

        menu.add(host);
        menu.add(connect);
        this.menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }
    
    public void hostAction() {
        if (isHost) {
            this.setTitle("Ludo");
            host.setText("Ser host");
            connect.setText("Conectar");
            controller.cancelHost();
            this.isHost = false;
        } else {
            this.setTitle("Buscando ...");
            host.setText("Cancelar");
            connect.setText("Informações");
            isHost = true;
            controller.host();
        }
    }
    
    public void connectAction() {
        if (isHost) {
            String msg = "Seu IP é: " + controller.getIP() + "\n"
                    + "E sua porta é : " + controller.getPort();

            JOptionPane.showMessageDialog(null, msg);
        } else {
            String ip = JOptionPane.showInputDialog("Digite o IP:");
            if (ip == null) {
                return;
            }
            controller.conectar(ip, 5000);
        }

    }
    
    public void setTurn(String str) {
        this.turn.setText(str);
    }
    
    public boolean isIsHost() {
        return isHost;
    }

    public void setIsHost(boolean isHost) {
        this.isHost = isHost;
    }   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
