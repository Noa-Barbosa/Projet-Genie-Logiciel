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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interface des controleurs de l'application
 * @author noaba
 */
public interface Controleur extends ActionListener{
    
    /**
     * Ecoute les evenements de la vue, creer les objets modeles si necessaire : fruit,salade..
     * fait les actions sur le modele en lui passant les objets si necessaire
     * @param e l'evenement declenche
     */
    @Override
    public void actionPerformed(ActionEvent e);
    
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
    
    public void ajoutProduit(Produit p) throws PanierPleinException;
    
    public void retraitProduit(Produit p);
    
    public void boycotteOrigine(OrigineProduit o);
    
    public void produitModif(Produit pInit, Produit pModif, int quantiteAModif);
}
