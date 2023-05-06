/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Gaspar
 */
public class UICasinha extends JButton {

    private int posicao_array;
    private Color corPiao;

    public UICasinha() {
        super();
        this.posicao_array = -1;
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.WHITE);
    }

    public void addListener(ActionListener listener) {
        this.addActionListener(listener);
    }

    public Color getCorPiao() {
        return corPiao;
    }

    public void setCorPiao(Color corPiao) {
        this.corPiao = corPiao;
    }

    public int getPosicao_array() {
        return posicao_array;
    }

    public void setPosicao_array(int posicao_array) {
        this.posicao_array = posicao_array;
    }

    public void setImagem(int cor) {
        if (cor == 0) {
            setIcon(null);
        }
        if (cor == 1) {
            try {
                // Carrega a imagem do pião
                BufferedImage originalImage = ImageIO.read(new File("E:/Geral/Unesp/Java/LudoGame/src/main/java/images/peaoAzul.png"));

                // Redimensiona a imagem para 50x50 pixels
                BufferedImage resizedImage = new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB);
                resizedImage.getGraphics().drawImage(originalImage, 0, 0, 40, 40, null);

                // Define o ícone da instância do JButton correspondente
                setIcon(new ImageIcon(resizedImage));
                // Define o tamanho do botão (opcional)
                setPreferredSize(new Dimension(50, 50));
            } catch (Exception ex) {
                System.out.println("Imagem não encontrada! Favor mudar o caminho em UICasinha linha 61");
            }

        }
        
        if (cor == 2) {
            try {
                // Carrega a imagem do pião
                BufferedImage originalImage = ImageIO.read(new File("E:/Geral/Unesp/Java/LudoGame/src/main/java/images/peaoVerde.png"));

                // Redimensiona a imagem para 50x50 pixels
                BufferedImage resizedImage = new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB);
                resizedImage.getGraphics().drawImage(originalImage, 0, 0, 40, 40, null);

                // Define o ícone da instância do JButton correspondente
                setIcon(new ImageIcon(resizedImage));
                // Define o tamanho do botão (opcional)
                setPreferredSize(new Dimension(50, 50));
            } catch (Exception ex) {
                System.out.println("Imagem não encontrada! Favor mudar o caminho em UICasinha linha 80");
            }

        }
    }

    public void setCor(Color cor) {
        setBackground(cor);
    }


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
