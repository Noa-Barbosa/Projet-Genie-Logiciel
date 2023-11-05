/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.model.Produit;
import fr.ufrsciencestech.panier.model.FruitSimple;
import fr.ufrsciencestech.panier.model.OrigineProduit;
import fr.ufrsciencestech.panier.model.TypeFruitSimple;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author pt454976
 */
public class VueModifFruit extends javax.swing.JFrame {
    private Produit mProduit;
    private int mQuantite;

    /**
     * Creates new form VueModifFruit
     */
    public VueModifFruit(Produit produit, int quantite) {
        initComponents();
        this.mProduit = produit;
        this.mQuantite = quantite;
        
        initDatas();
    }
    
    void initDatas(){
        DefaultComboBoxModel<TypeFruitSimple> modelTypeFruit = new DefaultComboBoxModel<>(TypeFruitSimple.values());
        this.jComboBoxTypeFruit.setModel((ComboBoxModel)modelTypeFruit);
        FruitSimple fruit = (FruitSimple)this.mProduit;
        this.jComboBoxTypeFruit.setSelectedItem(fruit.getTypeFruitSimple());
        
        DefaultComboBoxModel<OrigineProduit> modelOrigineProduit = new DefaultComboBoxModel<>(OrigineProduit.values());
        this.jComboBoxOrigineFruits.setModel((ComboBoxModel)modelOrigineProduit);
        this.jComboBoxOrigineFruits.setSelectedItem(this.mProduit.getOrigine());
        
        this.jTextFieldPrixFruits.setText(Double.toString(this.mProduit.getPrix()));
        
        this.jSpinnerQuantite.setModel(new SpinnerNumberModel(1, 0, this.mQuantite, 1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTop = new javax.swing.JPanel();
        jPanelInfosFruits = new javax.swing.JPanel();
        jLabelTypeFruits = new javax.swing.JLabel();
        jComboBoxTypeFruit = new javax.swing.JComboBox<>();
        jLabelPrixFruits = new javax.swing.JLabel();
        jTextFieldPrixFruits = new javax.swing.JTextField();
        jLabelOrigineFruits = new javax.swing.JLabel();
        jComboBoxOrigineFruits = new javax.swing.JComboBox<>();
        jPanelQuantite = new javax.swing.JPanel();
        jLabelQuantite = new javax.swing.JLabel();
        jSpinnerQuantite = new javax.swing.JSpinner();
        jPanelBottom = new javax.swing.JPanel();
        jButtonValider = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(2, 1));

        jPanelTop.setLayout(new java.awt.GridLayout(2, 1));

        jLabelTypeFruits.setText("Type des fruits : ");
        jPanelInfosFruits.add(jLabelTypeFruits);

        jPanelInfosFruits.add(jComboBoxTypeFruit);

        jLabelPrixFruits.setText("Prix des fruits : ");
        jPanelInfosFruits.add(jLabelPrixFruits);
        jPanelInfosFruits.add(jTextFieldPrixFruits);

        jLabelOrigineFruits.setText("Origine des fruits : ");
        jPanelInfosFruits.add(jLabelOrigineFruits);

        jPanelInfosFruits.add(jComboBoxOrigineFruits);

        jPanelTop.add(jPanelInfosFruits);

        jLabelQuantite.setText("Quantité de fruits à modifier : ");
        jPanelQuantite.add(jLabelQuantite);
        jPanelQuantite.add(jSpinnerQuantite);

        jPanelTop.add(jPanelQuantite);

        getContentPane().add(jPanelTop);

        jButtonValider.setText("Valider");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });
        jPanelBottom.add(jButtonValider);

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });
        jPanelBottom.add(jButtonAnnuler);

        getContentPane().add(jPanelBottom);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        // TODO add your handling code here:
        this.dispose();
        this.pack();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JComboBox<String> jComboBoxOrigineFruits;
    private javax.swing.JComboBox<String> jComboBoxTypeFruit;
    private javax.swing.JLabel jLabelOrigineFruits;
    private javax.swing.JLabel jLabelPrixFruits;
    private javax.swing.JLabel jLabelQuantite;
    private javax.swing.JLabel jLabelTypeFruits;
    private javax.swing.JPanel jPanelBottom;
    private javax.swing.JPanel jPanelInfosFruits;
    private javax.swing.JPanel jPanelQuantite;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JSpinner jSpinnerQuantite;
    private javax.swing.JTextField jTextFieldPrixFruits;
    // End of variables declaration//GEN-END:variables

    public Produit getProduit(){
        return this.mProduit;
    }
    
    public int getQuantite(){
        return this.mQuantite;
    }
    
    public void setProduit(Produit produit){
        this.mProduit = produit;
    }
    
    public void setQuantite(int quantite){
        this.mQuantite = quantite;
    }
}
