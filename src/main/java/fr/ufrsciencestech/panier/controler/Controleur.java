/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.OrigineProduit;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.Produit;
import fr.ufrsciencestech.panier.model.exception.PanierPleinException;
import fr.ufrsciencestech.panier.view.VueG;

/**
 * Interface des controleurs de l'application
 * @author noaba
 */
public interface Controleur{
        
    /**
     * Mutateur de la vue
     * @param vg n'importe quelle vue
     */
    public void setVue(VueG vg);
    
    /**
     * Mutateur du modele
     * @param p le panier
     */
    public void setModele(Panier p);
    
    /**
     * Ajout d'un produit dans le panier
     * @param p le produit
     * @throws PanierPleinException 
     */
    public void ajoutProduit(Produit p) throws PanierPleinException;
    
    /**
     * Retrait d'un produit dans le panier
     * @param p le produit
     */
    public void retraitProduit(Produit p);
    
    /**
     * Supprime tout les produits d'une origine dans le panier
     * @param o l'origine
     */
    public void boycotteOrigine(OrigineProduit o);
    
    /**
     * Modifie un produit dans le panier egale a prodInit selon les modifs dans prodModif
     * @param pInit le produi a modifier
     * @param pModif les modification a apporter
     * @param quantiteAModif la quantite de produit a modifier
     */
    public void produitModif(Produit pInit, Produit pModif, int quantiteAModif);
}
