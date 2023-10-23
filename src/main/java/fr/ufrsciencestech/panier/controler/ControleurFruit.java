/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.FruitSimple;
import fr.ufrsciencestech.panier.model.JusCerise;
import fr.ufrsciencestech.panier.model.OrigineProduit;
import fr.ufrsciencestech.panier.model.TypeFruitSimple;
import fr.ufrsciencestech.panier.model.TypeProduit;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.Produit;
import fr.ufrsciencestech.panier.model.SaladeFruits;
import fr.ufrsciencestech.panier.model.exception.PanierPleinException;
import fr.ufrsciencestech.panier.model.exception.PanierVideException;
import fr.ufrsciencestech.panier.view.VuePanelFruit;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controleur de la partie fruit de l'application
 * @author nb654417
 */
public class ControleurFruit extends ControleurAbstract {
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        try {
            switch(e.getActionCommand()){
                case("+"):
                    FruitSimple fruit = new FruitSimple(5,OrigineProduit.France,TypeFruitSimple.Banane);
                    SaladeFruits salade = new SaladeFruits(5,OrigineProduit.Danemark);
                    JusCerise jus = new JusCerise(6,OrigineProduit.Allemagne,fruit);
                    JusCerise jusJus = new JusCerise(5,OrigineProduit.Danemark,jus);
                    p.ajoutProduit(jusJus);
                    break;
                case("-"):
                    p.retraitLastProduit(); 
                    break;
                case("ajoutQteFruitVuePanelFruit"):
                    VuePanelFruit vpf1 = (VuePanelFruit) this.vg;
                    this.p.ajoutProduit(vpf1.getProduit());
                    break;
                case("retireQteFruitVuePanelFruit"):
                    VuePanelFruit vpf2 = (VuePanelFruit) this.vg;
                    this.p.retraitProduit(vpf2.getProduit());
                    break;
            }
        } 
        catch (PanierPleinException | PanierVideException ex) {
            Logger.getLogger(ControleurFruit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void ajoutProduit(Produit p) throws PanierPleinException{
        this.p.ajoutProduit(p);
    }
    
    @Override
    public void retraitProduit(Produit p){
        this.p.retraitProduit(p);
    }
}
