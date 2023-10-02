/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author nb654417
 */
public interface VueG extends Observer {
    @Override
    public void update(Observable m, Object o);
    public void addControleur(Controleur c);
    
}
