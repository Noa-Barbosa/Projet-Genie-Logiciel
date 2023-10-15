/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author noaba
 */
public class FruitSimple extends FruitAbstract{    
    public FruitSimple(double prix, String origine, TypeProduit type){
        this.prix=prix;
        this.origine=origine;
        this.typeProduit=type;
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
    public String getOrigine() {
        return this.origine;
    }

    @Override
    public void setOrigine(String origine) {
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
    
    @Override
    public boolean equals(Object o){
        if(o.getClass().equals(this.getClass())){
            FruitSimple f = (FruitSimple) o;
            
            if(f.getTypeProduit() == this.getTypeProduit() &&
                    f.getOrigine().equalsIgnoreCase(this.getOrigine()) &&
                    f.getPrix() == this.getPrix()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSeedless(){
        switch (typeProduit) {
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
    
}
