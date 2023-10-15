/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 * Interface representant un produit générique de l'application
 * @author noaba
 */
public interface Produit {    
    /**
     * 
     * @return le prix du produit
     */
    public double getPrix();
    
    /**
     * Modifie le prix du produit
     * @param prix le prix a modifier
     */
    public void setPrix(double prix);
    
    /**
     * 
     * @return l'origine du produit
     */
    public String getOrigine();   
    
    /***
     * Modifie l'origine d'un produit
     * @param origine l'origine a modifie
     */
    public void setOrigine(String origine);
    
    /**
     * 
     * @return le type du produit
     */
    public TypeProduit getTypeProduit();
    
    /**
     * Modifie le type du produit
     * @param typeProduit
     */
    public void setTypeProduit(TypeProduit typeProduit);
    
    /**
     * 
     * @param o 
     * @return vrai si l'objet en paramètre est égale a this
     */
    @Override
    public boolean equals(Object o); 
    /**
     * 
     * @return la chaine representant le produit
     */
    @Override
    public String toString();   
    
}
