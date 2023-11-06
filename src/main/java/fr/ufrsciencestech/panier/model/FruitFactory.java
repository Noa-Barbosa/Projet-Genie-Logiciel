/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.model;

import static fr.ufrsciencestech.panier.model.TypeFruitSimple.Banane;
import static fr.ufrsciencestech.panier.model.TypeFruitSimple.Cerise;
import static fr.ufrsciencestech.panier.model.TypeFruitSimple.Orange;
import static fr.ufrsciencestech.panier.model.TypeFruitSimple.Poire;

/**
 *
 * @author Anthony
 */
public class FruitFactory{

    public static FruitSimple creerFruitSimple(double prix, OrigineProduit origine, TypeFruitSimple type){
        FruitSimple fs = null; 
        fs = new FruitSimple(prix,origine,type);
        return fs;
    }
    
    public static SaladeFruits creerSaladeFruits(double prix, OrigineProduit origine) {
        
        SaladeFruits fs = null; 
        fs = new SaladeFruits(prix, origine);
        return fs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static JusCerise creerJusCerise(double prix, OrigineProduit origine, Fruit fruit){
        JusCerise fs = null; 
        fs = new JusCerise(prix, origine,fruit);
        return fs;
    }
    
    public static JusBanane creerJusBanane(double prix, OrigineProduit origine, Fruit fruit){
        JusBanane fs = null; 
        fs = new JusBanane(prix, origine,fruit);
        return fs;
    }
    
}
