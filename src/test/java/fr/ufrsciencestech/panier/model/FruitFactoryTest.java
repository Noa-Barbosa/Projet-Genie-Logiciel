/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Anthony
 */
public class FruitFactoryTest {
    
    private FruitFactory ff;

    public FruitFactoryTest() {
    }

    @Before
    public void setUp(){
        ff = new FruitFactory();
    }

    /**
     * Test of creerSaladeFruits method, of class FruitFactory.
     */
    @Test
    public void testCreerProduit() {
        //Test pour la création d'un objet depuis la factory
        double prix = 10;
        TypeFruitSimple tp = TypeFruitSimple.Banane;
        OrigineProduit op = OrigineProduit.France;
        FruitSimple pAttente = new FruitSimple(prix, op, tp);
        FruitSimple pResulat;
        pResulat = ff.creerFruitSimple(prix, op, tp);
        assertEquals(pResulat,pAttente);
        
    }

    /**
     * Test of creerFruitSimple method, of class FruitFactory.
     */
    @Test
    public void testCreerFruitSimple() {
        double prix = 10;
        TypeFruitSimple tp = TypeFruitSimple.Banane;
        OrigineProduit op = OrigineProduit.France;
        FruitSimple pAttente = new FruitSimple(prix, op, tp);
        FruitSimple pResulat;
        pResulat = ff.creerFruitSimple(prix, op, tp);
        assertEquals(pResulat,pAttente);
    }

    /**
     * Test of creerSaladeFruits method, of class FruitFactory.
     */
    @Test
    public void testCreerSaladeFruits() {
        double prix = 10;
        OrigineProduit op = OrigineProduit.Allemagne;
        SaladeFruits sfAttente = new SaladeFruits(prix, op);
        
        SaladeFruits sfResultat;
        sfResultat= ff.creerSaladeFruits(prix, op);
        
        assertEquals(sfResultat,sfAttente);
    }

    /**
     * Test of creerJusCerise method, of class FruitFactory.
     */
    @Test
    public void testCreerJusCerise() {
        double prix = 5;
        double prixjus = 15;
        
        TypeFruitSimple tp = TypeFruitSimple.Cerise;
        
        OrigineProduit op = OrigineProduit.Maroc;        
        OrigineProduit opJus = OrigineProduit.Allemagne;
        
        FruitSimple f = new FruitSimple(prix, op, tp);
        
        JusCerise jcAttente = new JusCerise(prixjus, opJus, f);
        JusCerise jcResultat;
        jcResultat = ff.creerJusCerise(prixjus, opJus, f);
  
        assertEquals(jcResultat,jcAttente);
    }

    /**
     * Test of creerJusBanane method, of class FruitFactory.
     */
    @Test
    public void testCreerJusBanane() {
        double prix = 5;
        double prixjus = 20;
        
        TypeFruitSimple tp = TypeFruitSimple.Banane;
        
        OrigineProduit op = OrigineProduit.Maroc;        
        OrigineProduit opJus = OrigineProduit.Allemagne;
        
        FruitSimple f = new FruitSimple(prix, op, tp);

        JusBanane jcAttente = new JusBanane(prixjus, opJus, f);
        JusBanane jcResultat;
        jcResultat = ff.creerJusBanane(prixjus, opJus, f);
  
        assertEquals(jcResultat,jcAttente);

    }
    
}
