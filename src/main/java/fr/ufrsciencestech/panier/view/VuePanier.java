/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.controler.ControleurFruit;
import fr.ufrsciencestech.panier.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author pt454976
 */
public class VuePanier extends javax.swing.JFrame implements VueG {
    private Panier mPanier;
    private Controleur mControleur;
    
    /**
     * Creates new form VuePanier
     */
    public VuePanier() {
        initComponents();
        this.setTitle("Panier");  
        this.setVisible(true);
        
        this.remplirBoycotteOrigine();
    }
    
    public VuePanier(Controleur c, Panier p){
        initComponents();
        this.setTitle("Panier");
        this.setVisible(true);
        
        this.mControleur= c;
        this.mPanier= p;
        this.remplirBoycotteOrigine();
    }
    
    void remplirBoycotteOrigine(){
        ArrayList<String> lst = new ArrayList<>();
        lst.add("Aucune");
        for(OrigineProduit origine : OrigineProduit.values()){
            lst.add(origine.toString());
        }
        DefaultComboBoxModel<String> modelType = new DefaultComboBoxModel<>();
        for(String str : lst){
            modelType.addElement(str);
        }
        this.jComboBoxBoycotteOrigine.setModel(modelType);
    }
    
    OrigineProduit getBoycotte(){
        String selectedString = (String)this.jComboBoxBoycotteOrigine.getSelectedItem();
        
        if(selectedString.equals("Aucune")) return null;
        else{
            try{
                return OrigineProduit.valueOf(selectedString);
            }catch(IllegalArgumentException e){
                System.err.println(e);
                return null;
            }
        }
    }
    
    void remplirListe(){
        double prixTotalPanier = 0;
        
        //retire tout les éléments du gridLayout
        this.panelListeFruits.removeAll();
        this.panelListeFruits.revalidate();
        this.panelListeFruits.repaint();
        
        ArrayList<Produit> produitsAjoutes = new ArrayList<>();
        for(Produit produit : this.mPanier.getProduits()){
            if(!layoutContientProduit(produit, produitsAjoutes)){
                int quantite = compteQteFruits(produit, this.mPanier);
             
                VuePanelFruit vf = new VuePanelFruit(produit, this, quantite, this.mControleur);
                
                this.panelListeFruits.add(vf);
                produitsAjoutes.add(produit);
                prixTotalPanier += quantite * produit.getPrix();
                
            }
        }
        
        this.contPrixTotalPanier.setText(Double.toString(prixTotalPanier) + "€ ");
    }
    
    boolean layoutContientProduit(Produit prodTest, ArrayList<Produit> produits){
        for(Produit produit : produits){
            if(prodTest.equals(produit)){
                return true;
            }
        }
        return false;
    }
    
    int compteQteFruits(Produit prodTest, Panier panier){
        int compteur = 0;
        for(Produit produit : panier.getProduits()){
            if(produit.equals(prodTest)) compteur++;
        }
        return compteur;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVuePanier = new javax.swing.JPanel();
        panelPanier = new javax.swing.JPanel();
        panelListeFruits = new javax.swing.JPanel();
        panelPrixTotalPanier = new javax.swing.JPanel();
        labelPrixTotalPanier = new javax.swing.JLabel();
        contPrixTotalPanier = new javax.swing.JLabel();
        panelBoutonsAjouts = new javax.swing.JPanel();
        jButtonAjouterFruit = new javax.swing.JButton();
        jButtonAjouterJus = new javax.swing.JButton();
        jButtonAjoutSaladeMacedoine = new javax.swing.JButton();
        jLabelOrigineBoycotte = new javax.swing.JLabel();
        jComboBoxBoycotteOrigine = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        panelVuePanier.setLayout(new java.awt.BorderLayout());

        panelPanier.setLayout(new java.awt.BorderLayout());

        panelListeFruits.setLayout(new java.awt.GridLayout(0, 1));
        panelPanier.add(panelListeFruits, java.awt.BorderLayout.CENTER);

        labelPrixTotalPanier.setText("Prix total du panier : ");
        panelPrixTotalPanier.add(labelPrixTotalPanier);
        panelPrixTotalPanier.add(contPrixTotalPanier);

        panelPanier.add(panelPrixTotalPanier, java.awt.BorderLayout.SOUTH);

        panelVuePanier.add(panelPanier, java.awt.BorderLayout.CENTER);

        panelBoutonsAjouts.setLayout(new java.awt.GridLayout(5, 1));

        jButtonAjouterFruit.setText("Ajouter fruit");
        jButtonAjouterFruit.setPreferredSize(null);
        jButtonAjouterFruit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterFruitActionPerformed(evt);
            }
        });
        panelBoutonsAjouts.add(jButtonAjouterFruit);

        jButtonAjouterJus.setText("Ajouter jus");
        jButtonAjouterJus.setPreferredSize(null);
        jButtonAjouterJus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterJusActionPerformed(evt);
            }
        });
        panelBoutonsAjouts.add(jButtonAjouterJus);

        jButtonAjoutSaladeMacedoine.setText("Ajouter salade/macédoine");
        panelBoutonsAjouts.add(jButtonAjoutSaladeMacedoine);

        jLabelOrigineBoycotte.setText("Origine a boycotter :");
        panelBoutonsAjouts.add(jLabelOrigineBoycotte);

        jComboBoxBoycotteOrigine.setPreferredSize(null);
        jComboBoxBoycotteOrigine.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxBoycotteOrigineItemStateChanged(evt);
            }
        });
        jComboBoxBoycotteOrigine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBoycotteOrigineActionPerformed(evt);
            }
        });
        panelBoutonsAjouts.add(jComboBoxBoycotteOrigine);

        panelVuePanier.add(panelBoutonsAjouts, java.awt.BorderLayout.EAST);

        getContentPane().add(panelVuePanier, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAjouterFruitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterFruitActionPerformed
        // TODO add your handling code here:
        VueAjoutFruit vag = new VueAjoutFruit(this.getPanier(), this, this.getControleur());
        vag.setVisible(true);
    }//GEN-LAST:event_jButtonAjouterFruitActionPerformed

    private void jComboBoxBoycotteOrigineItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxBoycotteOrigineItemStateChanged
        // TODO add your handling code here:
        this.mControleur.boycotteOrigine(this.getBoycotte());
        this.remplirListe();
    }//GEN-LAST:event_jComboBoxBoycotteOrigineItemStateChanged

    private void jButtonAjouterJusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterJusActionPerformed
        VueAjoutJus vaj = new VueAjoutJus(this.getPanier(), this, this.getControleur());
        vaj.setVisible(true);
    }//GEN-LAST:event_jButtonAjouterJusActionPerformed

    private void jComboBoxBoycotteOrigineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBoycotteOrigineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxBoycotteOrigineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contPrixTotalPanier;
    private javax.swing.JButton jButtonAjoutSaladeMacedoine;
    private javax.swing.JButton jButtonAjouterFruit;
    private javax.swing.JButton jButtonAjouterJus;
    private javax.swing.JComboBox<String> jComboBoxBoycotteOrigine;
    private javax.swing.JLabel jLabelOrigineBoycotte;
    private javax.swing.JLabel labelPrixTotalPanier;
    private javax.swing.JPanel panelBoutonsAjouts;
    private javax.swing.JPanel panelListeFruits;
    private javax.swing.JPanel panelPanier;
    private javax.swing.JPanel panelPrixTotalPanier;
    private javax.swing.JPanel panelVuePanier;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable m, Object o){
        this.mPanier= (Panier)o;
        this.remplirListe();
    }

    @Override
    public void addControleur(Controleur c) {
        this.mControleur=c;
    }
    
    public void setPanier(Panier p){
        this.mPanier = p;
    }
    
    public Panier getPanier() {
        return mPanier;
    }

    public Controleur getControleur() {
        return mControleur;
    }
}
