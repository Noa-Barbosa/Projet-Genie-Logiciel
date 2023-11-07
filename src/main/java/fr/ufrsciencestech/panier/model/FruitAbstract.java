/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 * Classe abstraite pour la partie fruit
 * @author vt718096
 */
public abstract class FruitAbstract implements Fruit{
    /**
     * Prix du fruit
     */
    protected double prix;
    
    /**
     * Origine du fruit
     */
    protected OrigineProduit origine;
    
    /**
     * Type du fruit
     */
    protected TypeProduit typeProduit;
    @Override
    public double getPrix(){
        return this.prix;
    }
    @Override
    public void setPrix(double prix){
        this.prix=prix;
    }
    @Override
    public OrigineProduit getOrigine(){
        return this.origine;
    }
    @Override
    public void setOrigine(OrigineProduit origine){
        this.origine=origine;
    }
    @Override
    public TypeProduit getTypeProduit(){
        return this.typeProduit;
    }
    @Override
    public void setTypeProduit(TypeProduit typeProduit){
        this.typeProduit=typeProduit;
    }
    @Override
    public abstract boolean equals(Object o);
    @Override
    public abstract String toString();
    @Override
    public abstract boolean isSeedless();
}
