/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.exception.PanierPleinException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eddin
 */
public class PanierTest {
    Panier panier;
    Fruit f1;
    Fruit f2;
    public PanierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        panier=new Panier(3);
        f1=new FruitSimple(15,"Danemark",TypeFruitSimple.Orange);
        f2=new FruitSimple(5,"Zimbabwe",TypeFruitSimple.Banane);
    }
    
    @After
    public void tearDown() {
    }
 
    @Test
    public void testToString()
    {
        try{
            panier.ajout(f1);
            panier.ajout(f2);
        }catch(PanierPleinException e)
        {
            fail("Echec du test à cause de : "+e);
        }
        String result = panier.toString();
        String attente = f1.toString()+" "+f2.toString()+" ";
        assertEquals(result,attente);
    }
}

