/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author Anthony
 */
public class FruitFactory implements ProduitFactory{

    @Override
    public Produit creerProduit(double arg0, OrigineProduit arg1, TypeProduit arg2) {
        
        Produit fs = null; 
        switch(arg2){
            case Orange:
                fs = new FruitSimple(arg0, arg1, arg2);
                break;
            case Banane:
                fs = new FruitSimple(arg0, arg1, arg2);
                break;
            case Cerise:
                fs = new FruitSimple(arg0, arg1, arg2);
                break;
            case Poire:
                fs = new FruitSimple(arg0, arg1, arg2);
                break;
            case SaladeFruits:
                fs = new FruitSimple(arg0, arg1, arg2);
                break;
        }
        return fs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
