/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.view.VueG;
import java.awt.event.ActionEvent;

/**
 * Classe abstraite definissant un controleur
 * @author noaba
 */
public abstract class ControleurAbstract implements Controleur{

    /**
     * Modele de l'application
     */
    Panier p;
    
    /**
     * Vue de l'application
     */
    VueG vg;
    
    @Override
    public abstract void actionPerformed(ActionEvent e);

    @Override
    public void setModele(Panier p){
        this.p = p;
    }
    
    @Override
    public void setVue(VueG vg){
        this.vg = vg;
    }
    
}
