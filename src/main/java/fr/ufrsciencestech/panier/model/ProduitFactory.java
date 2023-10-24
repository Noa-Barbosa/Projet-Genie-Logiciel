/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.model;

/**
 * Interface de la fabrique pour la création de produits
 * @author Anthony
 */
public interface ProduitFactory {
    public abstract Produit creerProduit(double prix, OrigineProduit origine, TypeProduit type);
}
