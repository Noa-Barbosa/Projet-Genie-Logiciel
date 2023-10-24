/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 * Classe representant un jus de cerise (pattern decorator)
 * @author noaba
 */
public class JusBanane extends JusAbstract{

    /**
     * Constructeur d'un jus de banane
     * @param prix le prix du jus
     * @param origine
     * @param fruit 
     */
    public JusBanane(double prix, OrigineProduit origine, Fruit fruit){
        this.prix=prix;
        this.origine = origine;
        this.fruit=fruit;
        this.typeProduit=TypeProduit.JusBanane;
    }
    
    @Override
    public double getPrix() {
        return this.prix + fruit.getPrix();
    }

    @Override
    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public OrigineProduit getOrigine() {
        return this.origine;
    }

    @Override
    public void setOrigine(OrigineProduit origine) {
        this.origine=origine;
    }

    @Override
    public TypeProduit getTypeProduit() {
        return this.typeProduit;
    }

    @Override
    public void setTypeProduit(TypeProduit typeProduit) {
        this.typeProduit=TypeProduit.JusBanane;
    }
    
    public Fruit getFruit(){
        return this.fruit;
    }

    @Override
    public boolean equals(Object o) {
        if(o.getClass().equals(this.getClass())){
            JusBanane j = (JusBanane) o;
            
            if(this.fruit.equals(j.getFruit())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return fruit.toString()+"Jus : Banane, Origine : "+this.getOrigine()+", Prix : " + this.getPrix();
    }

    @Override
    public boolean isSeedless() {
        return false;
    }
    
}
