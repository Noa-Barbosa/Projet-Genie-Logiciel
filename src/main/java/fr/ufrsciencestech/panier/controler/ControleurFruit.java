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
import fr.ufrsciencestech.panier.model.Produit;
import fr.ufrsciencestech.panier.model.FruitFactory;
import fr.ufrsciencestech.panier.model.JusBanane;
import fr.ufrsciencestech.panier.model.exception.PanierPleinException;

/**
 * Controleur de la partie fruit de l'application
 * @author nb654417
 */
public class ControleurFruit extends ControleurAbstract {
    
    @Override
    public void ajoutProduit(Produit p) throws PanierPleinException{
        this.p.ajoutProduit(p);
    }
    
    @Override
    public void retraitProduit(Produit p){
        this.p.retraitProduit(p);
    }

    @Override
    public void boycotteOrigine(OrigineProduit op) {
        this.p.boycotteOrigine(op);
    }
    
    @Override
    public void produitModif(Produit pInit, Produit pModif, int quantiteAModif) {
        this.p.produitModif(pInit, pModif, quantiteAModif);
    }

    /**
     * Creer un jus selon les parametres indiques et l'ajoute au panier
     * @param prixJus
     * @param origineJus
     * @param typeJus
     * @param prixFruit
     * @param origineFruit
     * @param typeFruit
     * @throws PanierPleinException 
     */
    public void ajoutJus(double prixJus, OrigineProduit origineJus, TypeProduit typeJus, double prixFruit, OrigineProduit origineFruit, TypeFruitSimple typeFruit) throws PanierPleinException {
        FruitSimple fruitSimple = FruitFactory.creerFruitSimple(prixFruit, origineFruit, typeFruit);
        if(typeJus.equals(TypeProduit.JusBanane)){
            JusBanane jusBanane = FruitFactory.creerJusBanane(prixJus, origineJus, fruitSimple);
            this.ajoutProduit(jusBanane);
        }
        else{
            JusCerise jusCerise = FruitFactory.creerJusCerise(prixJus, origineJus, fruitSimple);
            this.ajoutProduit(jusCerise);
        }
        
    }
}
