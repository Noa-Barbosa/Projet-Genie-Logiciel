/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author vt718096
 */
public abstract class FruitSimple {
    private double prix;
    private String origine;
    abstract double getPrix();
    abstract void setPrix(double prix);
    abstract String getOrigine();
    abstract void setOrigine(String origine);
    abstract boolean isSeedless() ;
}
