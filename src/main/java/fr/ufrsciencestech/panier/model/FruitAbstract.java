/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 * 
 * @author vt718096
 */
public abstract class FruitAbstract implements Fruit{
    protected double prix;
    protected String origine;
    protected TypeFruitSimple typeFruit;
    @Override
    public abstract double getPrix();
    @Override
    public abstract void setPrix(double prix);
    @Override
    public abstract String getOrigine();
    @Override
    public abstract void setOrigine(String origine);
    @Override
    public abstract TypeFruitSimple getTypeFruitSimple();
    @Override
    public abstract void setTypeFruitSimple(TypeFruitSimple typeFruitSimple);
    @Override
    public abstract boolean isSeedless();
}
