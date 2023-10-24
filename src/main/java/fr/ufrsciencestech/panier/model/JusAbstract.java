/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 * Classe abstraite, fonctionnement d'un jus pattern decorator
 * @author noaba
 */
public abstract class JusAbstract extends FruitAbstract{
    /**
     * Fruit decore par le jus
     */
    protected Fruit fruit;
    @Override
    public abstract double getPrix();
    @Override
    public abstract void setPrix(double prix);
    @Override
    public abstract OrigineProduit getOrigine();
    @Override
    public abstract void setOrigine(OrigineProduit origine);
    @Override
    public abstract TypeProduit getTypeProduit();
    @Override
    public abstract void setTypeProduit(TypeProduit typeProduit);
    @Override
    public abstract boolean equals(Object o);
    @Override
    public abstract String toString();
    @Override
    public abstract boolean isSeedless();
}
