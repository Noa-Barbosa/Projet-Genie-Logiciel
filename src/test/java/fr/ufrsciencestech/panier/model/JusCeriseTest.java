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
public class JusCeriseTest {
    
    public JusCeriseTest() {
    }

    /**
     * Test of getPrix method, of class JusCerise.
     */
    @Test
    public void testGetPrix() {
        Fruit fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        JusCerise jc = new JusCerise(20, OrigineProduit.France, fs);
        double resultatAttendu = 27;
        double resultatTest = jc.getPrix();
        assertEquals(resultatAttendu, resultatTest, 0);
    }

    /**
     * Test of getOrigine method, of class JusCerise.
     */
    @Test
    public void testGetOrigine() {
        Fruit fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        JusCerise jc = new JusCerise(20, OrigineProduit.France, fs);
        OrigineProduit resultatAttendu = OrigineProduit.France;
        OrigineProduit resultatTest = jc.getOrigine();
        assertEquals(resultatAttendu, resultatTest);
    }

    /**
     * Test of getTypeProduit method, of class JusCerise.
     */
    @Test
    public void testGetTypeProduit() {
        Fruit fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        JusCerise jc = new JusCerise(20, OrigineProduit.France, fs);
        
        TypeProduit resultatAttendu = TypeProduit.JusCerise;
        TypeProduit resultatTest = jc.getTypeProduit();
        assertEquals(resultatAttendu, resultatTest);
    }

    /**
     * Test of getFruit method, of class JusCerise.
     */
    @Test
    public void testGetFruit() {
        Fruit fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        Fruit fs2 = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        JusCerise jc = new JusCerise(20, OrigineProduit.France, fs);
        
        Fruit resultatAttendu = fs2;
        Fruit resultatTest = jc.getFruit();
        assertEquals(resultatAttendu, resultatTest);
    }
    /**
     * Test of toString method, of class JusCerise.
     */
    @Test
    public void testToString() {
        Fruit fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        JusCerise jc = new JusCerise(20, OrigineProduit.France, fs);
        
        String resultatAttendu = fs.toString()+"Jus : Cerise, Origine : "+jc.getOrigine()+", Prix : " + jc.getPrix();
        String resultatTest = jc.toString();
        assertEquals(resultatAttendu, resultatTest);
    }

    /**
     * Test of isSeedless method, of class JusCerise.
     */
    @Test
    public void testIsSeedless() {
        Fruit fs = new FruitSimple(2, OrigineProduit.Danemark, TypeFruitSimple.Cerise);
        JusCerise jc = new JusCerise(20, OrigineProduit.France, fs);
        boolean resultatAttendu = false;
        boolean resultatTest = jc.isSeedless();
        assertEquals(resultatAttendu, resultatTest);
    }
    
}
