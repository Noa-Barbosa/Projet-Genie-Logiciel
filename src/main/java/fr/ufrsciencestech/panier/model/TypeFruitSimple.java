/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 * Enumeration des types de fruits simple de l'application
 * @author noaba
 */
public enum TypeFruitSimple {
    Orange,Banane,Cerise,Poire;

    /**
     * Donne une valeur de l'enum aleatoir (utilise pour les tests)
     * @return 
     */
    static TypeFruitSimple rand() {
        TypeFruitSimple vals[] = TypeFruitSimple.values();
        return vals[(int)Math.floor(Math.random()*vals.length)];    }
}
