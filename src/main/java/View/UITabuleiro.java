/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Gaspar
 */
public class UITabuleiro extends javax.swing.JPanel {

    private UICasinha[][] casinha;

    public UITabuleiro() {
        setLayout(new GridLayout(15, 15));
        casinha = new UICasinha[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                casinha[i][j] = new UICasinha();

                //PARTE VERDE
                if (i < 6 & j < 6) {
                    casinha[i][j].setCor(Color.GREEN);
                }
                if (j < 6 & j > 0 & i == 7) {
                    casinha[i][j].setCor(Color.GREEN);
                }
                if (j == 1 & i == 6) {
                    casinha[i][j].setCor(Color.GREEN);
                }

                //PARTE VERMELHO
                if (i > 8 & j < 6) {
                    casinha[i][j].setCor(Color.RED);
                }
                if (i < 14 & 8 < i & j == 7) {
                    casinha[i][j].setCor(Color.RED);
                }
                if (j == 6 & i == 13) {
                    casinha[i][j].setCor(Color.RED);
                }

                //PARTE AZUL
                if (i > 8 & j > 8) {
                    casinha[i][j].setCor(Color.BLUE);
                }
                if (j > 8 & j < 14 & i == 7) {
                    casinha[i][j].setCor(Color.BLUE);
                }
                if (j == 13 & i == 8) {
                    casinha[i][j].setCor(Color.BLUE);
                }

                //PARTE AMARELA
                if (i < 6 & j > 8) {
                    casinha[i][j].setCor(Color.YELLOW);
                }
                if (i < 6 & 0 < i & j == 7) {
                    casinha[i][j].setCor(Color.YELLOW);
                }
                if (j == 8 & i == 1) {
                    casinha[i][j].setCor(Color.YELLOW);
                }
                
                if ((i == 1 & j == 1) || (i == 1 & j == 4) || (i == 4 & j == 1) || (i == 4 & j == 4) )  {
                    casinha[i][j].setCor(Color.WHITE);
                    casinha[i][j].setCorPiao(Color.GREEN);
                }
                
                if ((i == 1 & j == 10) || (i == 1 & j == 13)  ||(i == 4 & j == 10) || (i == 4 & j == 13) )  {
                    casinha[i][j].setCor(Color.WHITE);
                    
                    casinha[i][j].setCorPiao(Color.YELLOW);
                }
                
                if ((i == 10 & j == 1) ||(i == 10 & j == 4) || (i == 13 & j == 1) ||(i == 13 & j == 4)  )  {
                    casinha[i][j].setCor(Color.WHITE);
                    casinha[i][j].setCorPiao(Color.RED);
                }
                
                if ((i == 10 & j == 10) || (i == 10 & j == 13) ||(i == 13 & j == 10) || (i == 13 & j == 13)  )  {
                    casinha[i][j].setCor(Color.WHITE);
                    casinha[i][j].setCorPiao(Color.BLUE);
                }
                

                add(casinha[i][j]);
            }
        }
        
        casinha[0][0].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
        
        
        
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

    }

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
