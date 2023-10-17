/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author noaba
 */
public enum OrigineProduit {
    France,Espagne,PaysBas,Allemagne,Danemark,Maroc,Japon,Russie;
    
    /**
     * 
     * @return une origine au hasard 
     * @author EMK
     */
    public static OrigineProduit rand(){
        OrigineProduit vals[] = OrigineProduit.values();
        return vals[(int)Math.floor(Math.random()*vals.length)];
    }
}
