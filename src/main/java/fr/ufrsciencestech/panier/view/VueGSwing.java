/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author nb654417
 */
public class VueGSwing extends javax.swing.JFrame implements VueG {

    /**
     * Creates new form VueGSwing
     */
    public VueGSwing() {
        initComponents();
        this.setVisible(true);
        mainPanel.setName("mainPanel");
        plusButton.setName("plusButton");
        minusButton.setName("minusButton");
        nbFruits.setName("nbFruits");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        plusButton = new javax.swing.JButton();
        nbFruits = new javax.swing.JLabel();
        minusButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panier");

        mainPanel.setLayout(new java.awt.GridLayout(0, 1));

        plusButton.setText("+");
        mainPanel.add(plusButton);

        nbFruits.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbFruits.setText("0");
        mainPanel.add(nbFruits);

        minusButton.setText("-");
        mainPanel.add(minusButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton minusButton;
    private javax.swing.JLabel nbFruits;
    private javax.swing.JButton plusButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addControleur(Controleur c){
        this.plusButton.addActionListener(c);
        this.minusButton.addActionListener(c);
    }
    
    @Override
    public void update(Observable m, Object o){     //This method is called whenever the observed object is changed
        this.nbFruits.setText(((Integer) o).toString());
    }

    /**
     * @return the inc
     */
    public JButton getInc() {
        return this.plusButton;
    }
    
    public void setInc(JButton button){
        this.plusButton=button;
    }

    /**
     * @return the dec
     */
    public JButton getDec() {
        return this.minusButton;
    }
    
    public void setDec(JButton button){
        this.minusButton=button;
    }

    /**
     * @return the affiche
     */
    public JLabel getAffiche() {
        return this.nbFruits;
    }
    
    public void setAffiche(JLabel label){
        this.nbFruits=label;
    }

}