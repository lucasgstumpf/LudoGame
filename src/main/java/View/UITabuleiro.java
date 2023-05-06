/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import src.Model.Movimento;

/**
 *
 * @author Gaspar
 */
public class UITabuleiro extends javax.swing.JPanel {

    private UICasinha[][] casinha;

    public UITabuleiro(Controller controller) {
        setLayout(new GridLayout(15, 15));
        casinha = new UICasinha[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                
                final int finalI = i;
                final int finalJ = j;
                
                casinha[i][j] = new UICasinha();

                //PARTE y
                if (i < 6 & j < 6) {
                    casinha[i][j].setCor(Color.YELLOW);
                }
                if (j < 6 & j > 0 & i == 7) {
                    casinha[i][j].setCor(Color.YELLOW);
                }
                if (j == 1 & i == 6) {
                    casinha[i][j].setCor(Color.YELLOW);
                }

                //PARTE VERMELHO
                if (i > 8 & j < 6) {
                    casinha[i][j].setCor(Color.BLUE);
                }
                if (i < 14 & 8 < i & j == 7) {
                    casinha[i][j].setCor(Color.BLUE);
                }
                if (j == 6 & i == 13) {
                    casinha[i][j].setCor(Color.BLUE);
                }

                //PARTE AZUL
                if (i > 8 & j > 8) {
                    casinha[i][j].setCor(Color.RED);
                }
                if (j > 8 & j < 14 & i == 7) {
                    casinha[i][j].setCor(Color.RED);
                }
                if (j == 13 & i == 8) {
                    casinha[i][j].setCor(Color.RED);
                }

                //PARTE GREEN
                if (i < 6 & j > 8) {
                    casinha[i][j].setCor(Color.GREEN);
                }
                if (i < 6 & 0 < i & j == 7) {
                    casinha[i][j].setCor(Color.GREEN);
                }
                if (j == 8 & i == 1) {
                    casinha[i][j].setCor(Color.GREEN);
                }
                
                if ((i == 1 & j == 1) || (i == 1 & j == 4) || (i == 4 & j == 1) || (i == 4 & j == 4) )  {
                    casinha[i][j].setCor(Color.WHITE);
                }
                
                if ((i == 1 & j == 10) || (i == 1 & j == 13)  ||(i == 4 & j == 10) || (i == 4 & j == 13) )  {
                    casinha[i][j].setCor(Color.WHITE);
                    
                    casinha[i][j].setImagem(2);
                }
                
                if ((i == 10 & j == 1) ||(i == 10 & j == 4) || (i == 13 & j == 1) ||(i == 13 & j == 4)  )  {
                    casinha[i][j].setCor(Color.WHITE);
                    casinha[i][j].setImagem(1);
                }
                
                if ((i == 10 & j == 10) || (i == 10 & j == 13) ||(i == 13 & j == 10) || (i == 13 & j == 13)  )  {
                    casinha[i][j].setCor(Color.WHITE);
                    
                }
                
                // cria uma instância de ActionListener que chama o método desejado em UICasinha
                //FELIPE AQUI CLICA NO BOTAO
                ActionListener listener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(true){
                            
                            int posAntiga = casinha[finalI][finalJ].getPosicao_array();
                            Movimento movimento = new Movimento(null,posAntiga,controller.isMyTurn());
                            int posNova =controller.movePiece(movimento);
                            System.out.println(posAntiga);
                            ArrayList<Integer> pairPosicaoAntiga = pegaPosicaoCasinha(posAntiga);
                            ArrayList<Integer> pairPosicaoNova = pegaPosicaoCasinha(posNova);
                            if(controller.isIsHost()){
                                pintaCasa(pairPosicaoAntiga.get(0),pairPosicaoAntiga.get(1),0);
                                pintaCasa(pairPosicaoNova.get(0),pairPosicaoNova.get(1),1);
                                
                            }else{
                                pintaCasa(pairPosicaoAntiga.get(0),pairPosicaoAntiga.get(1),0);
                                pintaCasa(pairPosicaoNova.get(0),pairPosicaoNova.get(1),2);
                            }
                        }
                        
                    }
                };
                
                
                casinha[i][j].addActionListener(listener);
                add(casinha[i][j]);
            }
        }
        
      
        
        
        
        int posicao = 0;
        for (int i = 13; i > 8; i--) {
            casinha[i][6].setPosicao_array(posicao);
            posicao++;
        }
        for (int j = 5; j > -1; j--) {
            casinha[8][j].setPosicao_array(posicao);
            posicao++;
        }
        casinha[7][0].setPosicao_array(posicao);
        posicao++;
        for (int j = 0; j < 6; j++) {
            casinha[6][j].setPosicao_array(posicao);
            posicao++;
        }
        for (int i = 5; i > -1; i--) {
            casinha[i][6].setPosicao_array(posicao);
            posicao++;
        }
        casinha[0][7].setPosicao_array(posicao);
        posicao++;
        for (int i = 0; i < 6; i++) {
            casinha[i][8].setPosicao_array(posicao);
            posicao++;
        }
        for (int j = 9; j < 15; j++) {
            casinha[6][j].setPosicao_array(posicao);
            posicao++;
        }
        casinha[7][14].setPosicao_array(posicao);
        posicao++;
        for (int j = 14; j > 8; j--) {
            casinha[8][j].setPosicao_array(posicao);
            posicao++;
        }
        for (int i = 9; i < 15; i++) {
            casinha[i][8].setPosicao_array(posicao);
            posicao++;
        }
        casinha[14][7].setPosicao_array(posicao);
        posicao++;
        casinha[14][6].setPosicao_array(posicao);
        
        posicao = 70;
        
        for (int i = 13; i > 7; i--) {
            System.out.println("Passou");
            casinha[i][7].setPosicao_array(posicao);
            posicao++;
        }
        posicao = 80;
        for (int i = 1; i < 7; i++) {
            casinha[i][7].setPosicao_array(posicao);
            posicao++;
        }
        casinha[10][1].setPosicao_array(100);
        casinha[10][4].setPosicao_array(101);
        
        casinha[13][1].setPosicao_array(102);
        casinha[13][4].setPosicao_array(103);
        
        casinha[1][10].setPosicao_array(110);
        casinha[1][13].setPosicao_array(111);
        
        casinha[4][10].setPosicao_array(112);
        casinha[4][13].setPosicao_array(113);
          
    }
    
    public ArrayList<Integer> pegaPosicaoCasinha(int busca) {
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    int posCasinha = casinha[i][j].getPosicao_array();
                    if(posCasinha == busca){
                        System.out.println("POSICAO I: " + i);
                        System.out.println("POSICAO J: " + j);
                        ArrayList<Integer> pairPosicao;
                        pairPosicao = new ArrayList<>();
                        pairPosicao.add(i);
                        pairPosicao.add(j);
                        return pairPosicao;
                        
                    }
                    
                }
            }
            return null;
        };
    
    
    public void pintaCasa(int i,int j, int cor){
        casinha[i][j].setImagem(cor);
    }
    
    

    public UICasinha[][] getCasinha() {
        return casinha;
    }

    public void setCasinha(UICasinha[][] casinha) {
        this.casinha = casinha;
    }
/**
 * Creates new form UITabuleiro
 */
/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
