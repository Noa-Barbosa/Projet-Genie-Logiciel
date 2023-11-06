/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 * Classe representant un jus de cerise (pattern decorator)
 * @author noaba
 */
public class JusCerise extends JusAbstract{

    /**
     * Constructeur d'un jus de cerise
     * @param prix le prix du jus
     * @param origine
     * @param fruit 
     */
    public JusCerise(double prix, OrigineProduit origine, Fruit fruit){
        this.prix=prix;
        this.origine = origine;
        this.fruit=fruit;
        this.typeProduit=TypeProduit.JusCerise;
    }
    
    @Override
    public double getPrix() {
        return this.prix + fruit.getPrix();
    }

    @Override
    public boolean equals(Object o) {
        if(o.getClass().equals(this.getClass())){
            JusCerise j = (JusCerise) o;
            
            if(this.fruit.equals(j.getFruit())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return fruit.toString()+"Jus : Cerise, Origine : "+this.getOrigine()+", Prix : " + this.getPrix();
    }

    @Override
    public boolean isSeedless() {
        return false;
    }
    
}
