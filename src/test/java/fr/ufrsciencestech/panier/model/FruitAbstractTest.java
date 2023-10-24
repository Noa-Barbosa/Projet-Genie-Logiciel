/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe qui teste la classe FruitAbstract
 * On factorise les tests qui sont tout le temps identique pour chaque type de fruit
 * @author vt718096
 */
abstract public class FruitAbstractTest {
    abstract FruitAbstract createFruit(double prix,OrigineProduit origine, TypeFruitSimple type);
    abstract FruitAbstract createFruitNull();
    
    public FruitAbstractTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPrix method, of class FruitAbstract.
     */
    @Test
    public void testGetPrix() {
        System.out.println("getPrix");
        FruitAbstract instance = createFruit(0.6,OrigineProduit.France,TypeFruitSimple.Orange);
        double expResult = 0.6;
        double result = instance.getPrix();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of setPrix method, of class FruitAbstract.
     */
    @Test
    public void testSetPrix() {
        System.out.println("setPrix");
        double prix = 0.0;
        FruitAbstract instance = createFruit(0.6,OrigineProduit.France,TypeFruitSimple.Orange);
        instance.setPrix(prix);
        assertEquals(prix, instance.getPrix(), 0);
        
        System.out.println("setPrix");
        double prix1 = 0.8;
        FruitAbstract instance1 = createFruitNull();
        instance.setPrix(prix1);
        assertEquals(prix1, instance1.getPrix(), 0);
    }

    /**
     * Test of getOrigine method, of class FruitAbstract.
     */
    @Test
    public void testGetOrigine() {
        System.out.println("getOrigine");
        FruitAbstract instance = createFruit(0.6,OrigineProduit.France,TypeFruitSimple.Orange);
        OrigineProduit result = instance.getOrigine();
        assertEquals(OrigineProduit.France, result);
    }

    /**
     * Test of setOrigine method, of class FruitAbstract.
     */
    @Test
    public void testSetOrigine() {
        System.out.println("setOrigine");
        OrigineProduit origine = OrigineProduit.Danemark;
        FruitAbstract instance = createFruit(0.6,OrigineProduit.France,TypeFruitSimple.Orange);
        instance.setOrigine(origine);
        assertEquals(origine,instance.getOrigine());
    }

    /**
     * Test of isSeedless method, of class FruitAbstract.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        FruitAbstract instance = createFruit(0.6,OrigineProduit.France,TypeFruitSimple.Orange);
        boolean expResult = false;
        boolean result = instance.isSeedless();
        assertEquals(expResult, result);
    }

    
}
