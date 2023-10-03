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
public class SaladeFruits implements Fruit {

    private ArrayList<Fruit> listeFruits;
    public SaladeFruits(){
        super();
        this.listeFruits = new ArrayList<>();
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
        double prix=0;
        for(Fruit fruit:this.getFruits()){
            prix+=fruit.getPrix();
        }
        return prix;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * 
     * @return Un String de toutes les origines des fruits de la salade. Sous la forme "origine, origine, origine" 
     */
    @Override
    public String getOrigine() {
        String origines="";
        for(Fruit fruit:this.getFruits()){
            origines+=fruit.getOrigine()+", ";
        }
        return origines.substring(0, origines.length()-2);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
    public void ajoutFruit(Fruit fruit){
        this.getFruits().add(fruit);
    }
    
    public void retirFruit(Fruit fruit){
        this.getFruits().remove(fruit);
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
}
