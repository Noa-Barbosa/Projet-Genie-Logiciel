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
    public SaladeFruits(double prix, String origine){
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
     * 
     * @return La somme des prix de tous les fruits de la salade 
     */
    @Override
    public double getPrix() {
        return this.prix;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * 
     * @return Un String de toutes les origines des fruits de la salade. Sous la forme "origine, origine, origine" 
     */
    @Override
    public String getOrigine() {
        return this.origine;
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
    public void setPrix(double prix) {
        this.prix=prix; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setOrigine(String origine) {
        this.origine=origine;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public TypeProduit getTypeProduit(){
        return this.typeProduit;
    }
    
    @Override
    public void setTypeProduit(TypeProduit typeProduit){
        this.typeProduit  = typeProduit;
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
    
}
