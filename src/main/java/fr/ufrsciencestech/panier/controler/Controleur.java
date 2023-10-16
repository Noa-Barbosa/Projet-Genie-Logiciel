/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.view.VueG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author noaba
 */
public interface Controleur extends ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e);
    public void setVue(VueG vg);
    public void setModele(Panier p);
}
