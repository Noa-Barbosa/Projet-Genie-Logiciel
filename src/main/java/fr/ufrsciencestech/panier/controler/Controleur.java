/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.FruitSimple;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.TypeProduit;
import fr.ufrsciencestech.panier.model.exception.PanierPleinException;
import fr.ufrsciencestech.panier.model.exception.PanierVideException;
import fr.ufrsciencestech.panier.view.VueGSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controleur de l'application
 * @author nb654417
 */
public class Controleur implements ActionListener {
    /**
     * Le panier de l'application
     */
    private Panier p;
    
    /**
     * La vue de l'application
     */
    private VueGSwing vg;
    
    /**
     * Ecoute les evenements de la vue, creer les objets modeles si necessaire : fruit,salade..
     * fait les actions sur le modele en lui passant les objets si necessaire
     * @param e l'evenement declenche
     */
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        try {
            if(e.getActionCommand().equals("+")){
                FruitSimple fruit = new FruitSimple(5,"France",TypeProduit.Banane);
                p.ajout(fruit);
            }        
            else{
                p.retrait(); 
            }
        } 
        catch (PanierPleinException | PanierVideException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Change le modele 
     * @param p le nouveau modele
     */
    public void setModele(Panier p){
        this.p = p;
    }
    
    /**
     * Change la vue 
     * @param vg la nouvelle vue
     */
    public void setVue(VueGSwing vg){
        this.vg = vg;
    }
}
