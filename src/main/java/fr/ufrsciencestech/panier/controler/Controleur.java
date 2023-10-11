/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.exception.PanierPleinException;
import fr.ufrsciencestech.panier.model.exception.PanierVideException;
import fr.ufrsciencestech.panier.view.VueGSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nb654417
 */
public class Controleur implements ActionListener {
    private Panier p;
    private VueGSwing vg;
    
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        try {
            if(e.getActionCommand().equals("+")){
                p.update(1);
            }        
            else{
                p.update(-1); 
            }
        } 
        catch (PanierPleinException | PanierVideException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setModele(Panier p){
        this.p = p;
    }
    public void setVue(VueGSwing vg){
        this.vg = vg;
    }
}
