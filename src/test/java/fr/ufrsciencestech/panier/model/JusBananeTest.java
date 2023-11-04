/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anthony
 */
public class JusBananeTest {
    
    public JusBananeTest() {
    }

    /**
     * Test of getPrix method, of class JusBanane.
     */
    @Test
    public void testGetPrix() {
        Fruit fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        JusBanane jb = new JusBanane(10, OrigineProduit.Danemark, fs);
        
        double resultatAttendu = 17;
        double resultatTest = jb.getPrix();
        assertEquals(resultatAttendu, resultatTest, 0);
        
    }

    /**
     * Test of getOrigine method, of class JusBanane.
     */
    @Test
    public void testGetOrigine() {
        Fruit fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        JusBanane jb = new JusBanane(10, OrigineProduit.Danemark, fs);
        
        OrigineProduit resultatAttendu = OrigineProduit.Danemark;
        OrigineProduit resultatTest = jb.getOrigine();
        assertEquals(resultatAttendu, resultatTest);
    }

    /**
     * Test of getTypeProduit method, of class JusBanane.
     */
    @Test
    public void testGetTypeProduit() {
        Fruit fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        JusBanane jb = new JusBanane(10, OrigineProduit.Danemark, fs);
        
        TypeProduit resultatAttendu = TypeProduit.JusBanane;
        TypeProduit resultatTest = jb.getTypeProduit();
        assertEquals(resultatAttendu, resultatTest);
    }
    
    /**
     * Test of getFruit method, of class JusBanane.
     */
    @Test
    public void testGetFruit() {
        Fruit fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        Fruit fs2 = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        JusBanane jb = new JusBanane(10, OrigineProduit.Danemark, fs);
        
        Fruit resultatAttendu = fs2;
        Fruit resultatTest = jb.getFruit();
        assertEquals(resultatAttendu, resultatTest);
    }
    
    /**
     * Test of toString method, of class JusBanane.
     */
    @Test
    public void testToString() {
        Fruit fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        JusBanane jb = new JusBanane(10, OrigineProduit.Danemark, fs);
        
        String resultatAttendu = fs.toString()+"Jus : Banane, Origine : "+jb.getOrigine()+", Prix : " + jb.getPrix();
        String resultatTest = jb.toString();
        assertEquals(resultatAttendu, resultatTest);

    }

    /**
     * Test of isSeedless method, of class JusBanane.
     */
    @Test
    public void testIsSeedless() {
        Fruit fs = new FruitSimple(2, OrigineProduit.Danemark, TypeFruitSimple.Banane);
        JusBanane jb = new JusBanane(10, OrigineProduit.Allemagne, fs);
        boolean resultatAttendu = false;
        boolean resultatTest = jb.isSeedless();
        assertEquals(resultatAttendu, resultatTest);
    }
    
}
