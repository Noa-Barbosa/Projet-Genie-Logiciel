/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 * Un fruit basique : Orange,Cerise...
 * @author noaba
 */
public class FruitSimple extends FruitAbstract{   
    /**
     * Type de fruit
     */
    private TypeFruitSimple typeFruit;
    
    /**
     * Constructeur avec parametre
     * @param prix le prix
     * @param origine l'origine
     * @param type le type
     */
    public FruitSimple(double prix, OrigineProduit origine, TypeFruitSimple type){
        this.prix=prix;
        this.origine=origine;
        this.typeProduit=TypeProduit.FruitSimple;
        this.typeFruit=type;
    }
    
    /**
     * Assesseur du type du fruit
     * @return le type du fruit
     */
    public TypeFruitSimple getTypeFruitSimple(){
        return this.typeFruit;
    }
    
    @Override
    public boolean equals(Object o){
        if(o.getClass().equals(this.getClass())){
            FruitSimple f = (FruitSimple) o;
            
            if(f.getTypeProduit() == this.getTypeProduit() &&
                    f.getOrigine() == this.getOrigine() &&
                    f.getPrix() == this.getPrix()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSeedless(){
        switch (typeFruit) {
            case Orange : 
                return false;
            case Banane:
                return true;
            case Cerise:
                return false;
            case Poire:
                return false;
            default :
                return true;
        }
    }

    @Override
    public String toString() {
        return "Type : "+ this.typeFruit + "Prix : " + this.prix + " Origine : " +this.origine;   
    }
    
}
