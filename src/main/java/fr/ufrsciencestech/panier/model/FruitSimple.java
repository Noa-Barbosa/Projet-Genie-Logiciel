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

    private TypeFruitSimple typeFruit;
    
    public FruitSimple(double prix, String origine, TypeFruitSimple type){
        this.prix=prix;
        this.origine=origine;
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
    public String getOrigine() {
        return this.origine;
    }

    @Override
    public void setOrigine(String origine) {
        this.origine=origine;
    }
    
    @Override
    public TypeFruitSimple getTypeFruitSimple(){
        return this.typeFruit;
    }
    
    @Override
    public void setTypeFruitSimple(TypeFruitSimple typeFruitSimple){
        this.typeFruit = typeFruitSimple;
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
    
}
