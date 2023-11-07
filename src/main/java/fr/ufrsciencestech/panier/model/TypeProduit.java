/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 * Enumeration permettant d'avoir les types de produit de l'appli
 * @author noaba
 */
public enum TypeProduit {
    
    FruitSimple,SaladeFruits,JusCerise,JusBanane;
    
    /**
     * 
     * @return un type au hasard
     * @author EMK
     */
    public static TypeProduit rand(){
        TypeProduit vals[] = TypeProduit.values();
        return vals[(int)Math.floor(Math.random()*vals.length)];
    }
    
}
