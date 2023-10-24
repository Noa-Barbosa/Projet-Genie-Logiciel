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
     * Test of creerProduit method, of class FruitFactory.
     */
    @Test
    public void testCreerProduit() {
        //Test pour la création d'un objet depuis la factory
        double prix = 10;
        TypeProduit tp = TypeProduit.Banane;
        OrigineProduit op = OrigineProduit.France;
        Produit pAttente = new FruitSimple(prix, op, tp);
        Produit pResulat;
        pResulat = ff.creerProduit(prix, op, tp);
        assertEquals(pResulat,pAttente);
        
    }
    
}
