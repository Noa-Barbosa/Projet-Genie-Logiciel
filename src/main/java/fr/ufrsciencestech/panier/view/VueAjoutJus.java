/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.controler.ControleurFruit;
import fr.ufrsciencestech.panier.model.FruitSimple;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.OrigineProduit;
import fr.ufrsciencestech.panier.model.TypeFruitSimple;
import fr.ufrsciencestech.panier.model.TypeProduit;
import java.util.Observable;

import javax.swing.*;

/**
 *
 * @author pt454976
 */
public class VueAjoutJus extends javax.swing.JFrame implements VueG{
    private Panier mPanier;
    private VuePanier mVP;
    private Controleur mControleur;

    /**
     * Creates new form VueAjoutFruit
     */
    public VueAjoutJus(Panier panier, VuePanier vuePanier, Controleur controleur) {
        initComponents();
        this.mPanier = panier;
        this.mVP = vuePanier;
        this.mControleur = controleur;
                
        initDatas();
    }
    
    void initDatas(){
        DefaultComboBoxModel<OrigineProduit> modelOrigineJus = new DefaultComboBoxModel<>(OrigineProduit.values());
            DefaultComboBoxModel<OrigineProduit> modelOrigineFruit = new DefaultComboBoxModel<>(OrigineProduit.values());

        this.jComboBoxOrigineJus.setModel((ComboBoxModel) modelOrigineJus);
        this.jComboBoxOrigineFruit.setModel((ComboBoxModel) modelOrigineFruit);
        
        DefaultComboBoxModel<TypeFruitSimple> modelType = new DefaultComboBoxModel<>(TypeFruitSimple.values());
        this.jComboBoxTypeFruit.setModel((ComboBoxModel) modelType);
        
        TypeProduit[] typesJus= {TypeProduit.JusBanane,TypeProduit.JusCerise};
        DefaultComboBoxModel<TypeProduit> modelTypeJus = new DefaultComboBoxModel<>(typesJus);
        this.jComboBoxTypeJus.setModel((ComboBoxModel) modelTypeJus);

    }
    
    boolean jTextFieldPrixValide(){
        try{
            String text = this.jTextFieldPrixJus.getText();
            double prix = Double.parseDouble(text);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTypeOrigineFruitSimple = new javax.swing.JPanel();
        labelPrixJus = new javax.swing.JLabel();
        jTextFieldPrixJus = new javax.swing.JTextField();
        labelOrigineFruitSimple = new javax.swing.JLabel();
        jComboBoxOrigineJus = new javax.swing.JComboBox<>();
        jLabelTypeJus = new javax.swing.JLabel();
        jComboBoxTypeJus = new javax.swing.JComboBox<>();
        panelPrixQteFruitSimple = new javax.swing.JPanel();
        jLabelFruit = new javax.swing.JLabel();
        jTextFieldPrixFruit = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxOrigineFruit = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxTypeFruit = new javax.swing.JComboBox<>();
        panelBoutonsValiderAnnuler = new javax.swing.JPanel();
        jButtonValiderFruitSimple = new javax.swing.JButton();
        jButtonAnnulerFruitSimple = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelPrixJus.setText("Prix du jus : ");
        panelTypeOrigineFruitSimple.add(labelPrixJus);

        jTextFieldPrixJus.setPreferredSize(new java.awt.Dimension(100, 30));
        panelTypeOrigineFruitSimple.add(jTextFieldPrixJus);

        labelOrigineFruitSimple.setText("Origine du jus : ");
        panelTypeOrigineFruitSimple.add(labelOrigineFruitSimple);

        panelTypeOrigineFruitSimple.add(jComboBoxOrigineJus);

        jLabelTypeJus.setText("Type du jus :");
        panelTypeOrigineFruitSimple.add(jLabelTypeJus);

        jComboBoxTypeJus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelTypeOrigineFruitSimple.add(jComboBoxTypeJus);

        getContentPane().add(panelTypeOrigineFruitSimple, java.awt.BorderLayout.NORTH);

        jLabelFruit.setText("Prix du fruit décoré :");
        panelPrixQteFruitSimple.add(jLabelFruit);

        jTextFieldPrixFruit.setPreferredSize(new java.awt.Dimension(100, 30));
        panelPrixQteFruitSimple.add(jTextFieldPrixFruit);

        jLabel1.setText("Origine du fruit décoré :");
        panelPrixQteFruitSimple.add(jLabel1);

        jComboBoxOrigineFruit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelPrixQteFruitSimple.add(jComboBoxOrigineFruit);

        jLabel2.setText("Type fruit décoré :");
        panelPrixQteFruitSimple.add(jLabel2);

        jComboBoxTypeFruit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelPrixQteFruitSimple.add(jComboBoxTypeFruit);

        getContentPane().add(panelPrixQteFruitSimple, java.awt.BorderLayout.CENTER);

        jButtonValiderFruitSimple.setText("Valider");
        jButtonValiderFruitSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderFruitSimpleActionPerformed(evt);
            }
        });
        panelBoutonsValiderAnnuler.add(jButtonValiderFruitSimple);

        jButtonAnnulerFruitSimple.setText("Annuler");
        jButtonAnnulerFruitSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerFruitSimpleActionPerformed(evt);
            }
        });
        panelBoutonsValiderAnnuler.add(jButtonAnnulerFruitSimple);

        getContentPane().add(panelBoutonsValiderAnnuler, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValiderFruitSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderFruitSimpleActionPerformed
        // TODO add your handling code here:
        if(this.jTextFieldPrixValide()){
            try{
                
                double prixJus = Double.parseDouble(this.jTextFieldPrixJus.getText());
                OrigineProduit origineJus = (OrigineProduit) this.jComboBoxOrigineJus.getSelectedItem();
                TypeProduit typeJus = (TypeProduit) this.jComboBoxTypeJus.getSelectedItem();
                
                double prixFruit = Double.parseDouble(this.jTextFieldPrixFruit.getText());                
                OrigineProduit origineFruit = (OrigineProduit) this.jComboBoxOrigineFruit.getSelectedItem();
                TypeFruitSimple typeFruit = (TypeFruitSimple) this.jComboBoxTypeFruit.getSelectedItem();

                ControleurFruit cf = (ControleurFruit)this.mVP.getControleur();
                try{
                    cf.ajoutJus(prixJus,origineJus,typeJus,prixFruit,origineFruit,typeFruit);
                }catch (Exception e){
                    System.err.println(e);
                }
                
            }catch(Exception e){
                System.err.println(e);
            }
            this.dispose();
            this.pack();
        }else{
            System.err.println("Vous devez renseigner le prix du fruit correctement !\nOu alors le fruit est boycotté !");
        }
    }//GEN-LAST:event_jButtonValiderFruitSimpleActionPerformed

    private void jButtonAnnulerFruitSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerFruitSimpleActionPerformed
        // TODO add your handling code here:
        this.dispose();
        this.pack();
    }//GEN-LAST:event_jButtonAnnulerFruitSimpleActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnulerFruitSimple;
    private javax.swing.JButton jButtonValiderFruitSimple;
    private javax.swing.JComboBox<String> jComboBoxOrigineFruit;
    private javax.swing.JComboBox<String> jComboBoxOrigineJus;
    private javax.swing.JComboBox<String> jComboBoxTypeFruit;
    private javax.swing.JComboBox<String> jComboBoxTypeJus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFruit;
    private javax.swing.JLabel jLabelTypeJus;
    private javax.swing.JTextField jTextFieldPrixFruit;
    private javax.swing.JTextField jTextFieldPrixJus;
    private javax.swing.JLabel labelOrigineFruitSimple;
    private javax.swing.JLabel labelPrixJus;
    private javax.swing.JPanel panelBoutonsValiderAnnuler;
    private javax.swing.JPanel panelPrixQteFruitSimple;
    private javax.swing.JPanel panelTypeOrigineFruitSimple;
    // End of variables declaration//GEN-END:variables

    public Panier getPanier(){
        return this.mPanier;
    }
    
    public VuePanier getVuePanier(){
        return this.mVP;
    }
    
    public void setPanier(Panier panier){
        this.mPanier = panier;
    }
    
    public void setVuePanier(VuePanier vuePanier){
        this.mVP = vuePanier;
    }
    
    public Controleur getControleur(){
        return this.mControleur;
    }
    
    @Override
    public void addControleur(Controleur c){
        this.mControleur=c;
    }
    
    @Override
    public void update(Observable m, Object o){
        this.mPanier= (Panier)o;
        this.mVP.remplirListe();
    }
}