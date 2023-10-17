/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author pt454976
 */
public class VuePanier extends javax.swing.JFrame {
    Panier p;
    
    /**
     * Creates new form VuePanier
     */
    public VuePanier() {
        initComponents();
        this.setTitle("Panier");
        
        try{
            this.p = new Panier(10);
            this.p.ajoutProduit(new FruitSimple(1.0, OrigineProduit.Espagne, TypeProduit.Cerise));
            this.p.ajoutProduit(new FruitSimple(1.0, OrigineProduit.Espagne, TypeProduit.Cerise));
            this.p.ajoutProduit(new FruitSimple(1.0, OrigineProduit.Espagne, TypeProduit.Cerise));
            this.p.ajoutProduit(new FruitSimple(1.5, OrigineProduit.France, TypeProduit.Cerise));
            this.p.ajoutProduit(new FruitSimple(1.5, OrigineProduit.France, TypeProduit.Cerise));
            this.p.ajoutProduit(new FruitSimple(2.5, OrigineProduit.France, TypeProduit.Banane));
            this.p.ajoutProduit(new FruitSimple(2.0, OrigineProduit.Allemagne, TypeProduit.Banane));
            this.p.ajoutProduit(new FruitSimple(1.5, OrigineProduit.France, TypeProduit.Orange));
        }catch(Exception e){
            System.err.println(e);
        }
        
        remplirListe();
    }
    
    void remplirListe(){
        double prixTotalPanier = 0;
        
        this.panelListeFruits.removeAll();
        this.panelListeFruits.revalidate();
        this.panelListeFruits.repaint();
        
        ArrayList<Fruit> fruitsAjoutes = new ArrayList<>();
        for(Produit produit : this.p.getProduits()){
            Fruit fruit = (Fruit) produit;
            if(!layoutContientFruit(fruit, fruitsAjoutes)){
                int quantite = compteQteFruits(fruit, this.p);
                this.panelListeFruits.add(new VuePanelFruit(fruit, this, quantite));
                fruitsAjoutes.add(fruit);
                prixTotalPanier += quantite * produit.getPrix();
                
            }
        }
        
        this.contPrixTotalPanier.setText(Double.toString(prixTotalPanier) + "€ ");
    }
    
    boolean layoutContientFruit(Fruit f, ArrayList<Fruit> fruits){
        for(Fruit fruit : fruits){
            if(f.equals(fruit)){
                return true;
            }
        }
        return false;
    }
    
    int compteQteFruits(Fruit f, Panier p){
        int compteur = 0;
        for(Produit produit : p.getProduits()){
            if(produit.equals(f)) compteur++;
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

        panelListeFruits = new javax.swing.JPanel();
        panelPrixTotalPanier = new javax.swing.JPanel();
        labelPrixTotalPanier = new javax.swing.JLabel();
        contPrixTotalPanier = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        panelListeFruits.setLayout(new java.awt.GridLayout(0, 1));
        getContentPane().add(panelListeFruits, java.awt.BorderLayout.CENTER);

        labelPrixTotalPanier.setText("Prix total du panier : ");
        panelPrixTotalPanier.add(labelPrixTotalPanier);
        panelPrixTotalPanier.add(contPrixTotalPanier);

        getContentPane().add(panelPrixTotalPanier, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VuePanier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VuePanier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VuePanier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VuePanier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VuePanier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contPrixTotalPanier;
    private javax.swing.JLabel labelPrixTotalPanier;
    private javax.swing.JPanel panelListeFruits;
    private javax.swing.JPanel panelPrixTotalPanier;
    // End of variables declaration//GEN-END:variables
}
