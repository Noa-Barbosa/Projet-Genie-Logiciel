/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

import java.util.*;
/**
 *
 * @author thendis
 */
public class SaladeFruits extends FruitAbstract {

    private ArrayList<Fruit> listeFruits;
    public SaladeFruits(double prix, String origine){
        super();
        this.listeFruits = new ArrayList<>();
        this.prix=prix;
        this.origine=origine;
    }
    
    /**
     * Vérifie que les fruits de la salade son sans pepins
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
 
    public void ajoutFruit(Fruit fruit){
        this.getFruits().add(fruit);
        this.setPrix(this.getPrix()+fruit.getPrix());
    }
    
    public void retirFruit(Fruit fruit){
        this.getFruits().remove(fruit);
        this.setPrix(this.getPrix()-fruit.getPrix());
    }
    
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
}
