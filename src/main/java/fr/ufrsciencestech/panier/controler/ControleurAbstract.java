/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.view.VueG;
import java.awt.event.ActionEvent;

/**
 *
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

    /**
     * Change le modele 
     * @param p le nouveau modele
     */
    public void setModele(Panier p){
        this.p = p;
    }
    
    /**
     * Change la vue 
     * @param vg la nouvelle vue
     */
    public void setVue(VueG vg){
        this.vg = vg;
    }
    
}
