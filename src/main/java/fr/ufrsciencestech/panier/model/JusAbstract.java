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
    /**
     * Assesseur du fruit decore
     * @return le fruit decore par le jus
     */
    public Fruit getFruit(){
        return this.fruit;
    };
}
