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
public class FruitSimpleTest {
    
    public FruitSimpleTest() {
    }

    /**
     * Test of getPrix method, of class FruitSimple.
     */
    @Test
    public void testGetPrix() {
        FruitSimple fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        
        double resultatAttendu = 7;
        double resultatTest = fs.getPrix();
        assertEquals(resultatAttendu, resultatTest, 0);
    }
    
    /**
     * Test of getOrigine method, of class FruitSimple.
     */
    @Test
    public void testGetOrigine() {
        FruitSimple fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        
        OrigineProduit resultatAttendu = OrigineProduit.Allemagne;
        OrigineProduit resultatTest = fs.getOrigine();
        assertEquals(resultatAttendu, resultatTest);
    }

    /**
     * Test of getTypeProduit method, of class FruitSimple.
     */
    @Test
    public void testGetTypeProduit() {
        FruitSimple fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        
        TypeProduit resultatAttendu = TypeProduit.FruitSimple;
        TypeProduit resultatTest = fs.getTypeProduit();
        assertEquals(resultatAttendu, resultatTest);
    }
    
    /**
     * Test of getTypeFruitSimple method, of class FruitSimple.
     */
    @Test
    public void testGetTypeFruitSimple() {
         FruitSimple fs1 = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
         
        TypeFruitSimple resultatAttendu = TypeFruitSimple.Banane;
        TypeFruitSimple resultatTest = fs1.getTypeFruitSimple();
        assertEquals(resultatAttendu, resultatTest);

         
    }
    

    /**
     * Test of isSeedless method, of class FruitSimple.
     */
    @Test
    public void testIsSeedless() {
        FruitSimple fs1 = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        FruitSimple fs2 = new FruitSimple(10, OrigineProduit.France, TypeFruitSimple.Orange);
        
        boolean resultatAttenduPepin = true;
        boolean resultatAttenduNonPepin = false;
        
        boolean resultatTestPepin = fs1.isSeedless();
        boolean resultatTestNonPepin = fs2.isSeedless();
        
        assertEquals(resultatAttenduPepin, resultatTestPepin);
        assertEquals(resultatAttenduNonPepin, resultatTestNonPepin);
        
        
    }

    /**
     * Test of toString method, of class FruitSimple.
     */
    @Test
    public void testToString() {
        FruitSimple fs = new FruitSimple(7, OrigineProduit.Allemagne, TypeFruitSimple.Banane);
        
        String resultatAttendu = "Type : "+ fs.getTypeProduit() + "Prix : " + fs.getPrix() + " Origine : " +fs.getOrigine();
        String resultatTest = fs.toString();
        assertEquals(resultatAttendu, resultatTest);
    }
    
}
