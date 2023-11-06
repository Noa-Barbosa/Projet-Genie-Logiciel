/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

import java.util.*;
/**
 * Classe contenant une liste de fruit
 * @author thendis
 */
public class SaladeFruits extends FruitAbstract {
    
    /**
     * Liste des fruits
     */
    private ArrayList<Fruit> listeFruits;
    
    /**
     * Constructeur avec parametre
     * @param prix le prix
     * @param origine la pays d'origine, de fabrication 
     */
    public SaladeFruits(double prix, OrigineProduit origine){
        super();
        this.listeFruits = new ArrayList<>();
        this.prix=prix;
        this.origine=origine;
        this.typeProduit = TypeProduit.SaladeFruits;
    }
    
    /**
     * Vérifie que les fruits de la salade sont sans pepins
     * @return false si l'un des fruits de la salade contient des pepins 
     */
    @Override
    public boolean isSeedless() {
        for(Fruit fruit : this.getFruits())
        {
            if(!fruit.isSeedless())
                return false;
        }
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
    /**
     * Ajoute un fruit dans la salade
     * @param fruit le fruit a ajoute
     */
    public void ajoutFruit(Fruit fruit){
        this.getFruits().add(fruit);
        this.setPrix(this.getPrix()+fruit.getPrix());
    }
    
    /**
     * Retire un fruit de la salade
     * @param fruit le fruit a retire
     */
    public void retirFruit(Fruit fruit){
        this.getFruits().remove(fruit);
        this.setPrix(this.getPrix()-fruit.getPrix());
    }
    
    /**
     * 
     * @return la liste des fruits de la salade
     */
    public ArrayList<Fruit> getFruits(){
        return this.listeFruits;
    }
    
    /**
     * 
     * @return Retourne un String qui décrit la SaladeFruit sous forme: 
     * Prix Total : X
     * Fruit1
     * Fruit2
     */
    @Override
    public String toString(){
        String ret = "Prix Total : "+this.getPrix()+"\n";
        for(Fruit fruit:this.getFruits())
        {
            ret+=fruit.toString()+"\n";
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object o){
        if(o.getClass().equals(this.getClass())){
            SaladeFruits sf = (SaladeFruits) o;
            if(sf.getOrigine() == this.getOrigine() && sf.getPrix() == this.getPrix() && sf.getTypeProduit() == this.getTypeProduit() ){
                if(sf.getFruits().equals(this.getFruits())){
                    return true;
                }
            }
        }
        return false;
    }
    
}
