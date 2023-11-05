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
    private TypeFruitSimple typeFruit;
    public FruitSimple(double prix, OrigineProduit origine, TypeFruitSimple type){
        this.prix=prix;
        this.origine=origine;
        this.typeProduit=TypeProduit.FruitSimple;
        this.typeFruit=type;
    }
    
    @Override
    public double getPrix() {
        return this.prix;
    }

    @Override
    public void setPrix(double prix) {
        this.prix=prix;
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
    public TypeProduit getTypeProduit(){
        return this.typeProduit;
    }
    
    @Override
    public void setTypeProduit(TypeProduit typeProduit){
        this.typeProduit = typeProduit;
    }
    
    public TypeFruitSimple getTypeFruitSimple(){
        return this.typeFruit;
    }
    
    public void setTypeFruitSimple(TypeFruitSimple type){
        this.typeFruit = type;  
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
