/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.FruitSimple;
import fr.ufrsciencestech.panier.model.OrigineProduit;
import fr.ufrsciencestech.panier.model.TypeProduit;
import fr.ufrsciencestech.panier.model.exception.PanierPleinException;
import fr.ufrsciencestech.panier.model.exception.PanierVideException;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ControleurFruit de l'application
 * @author nb654417
 */
public class ControleurFruit extends ControleurAbstract {
    /**
     * Ecoute les evenements de la vue, creer les objets modeles si necessaire : fruit,salade..
     * fait les actions sur le modele en lui passant les objets si necessaire
     * @param e l'evenement declenche
     */
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        try {
            switch(e.getActionCommand()){
                case("+"):
                    FruitSimple fruit = new FruitSimple(5,OrigineProduit.France,TypeProduit.Banane);
                    p.ajout(fruit);
                    break;
                case("-"):
                    p.retraitLast(); 
                    break;
            }
        } 
        catch (PanierPleinException | PanierVideException ex) {
            Logger.getLogger(ControleurFruit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
