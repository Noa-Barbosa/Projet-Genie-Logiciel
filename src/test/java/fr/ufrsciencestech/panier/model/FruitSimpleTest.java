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
 *
 * @author vt718096
 */
abstract public class FruitSimpleTest {
    abstract FruitSimple createFruit(double prix,String origine);
    abstract FruitSimple createFruitNull();
    
    public FruitSimpleTest() {
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
     * Test of getPrix method, of class FruitSimple.
     */
    @Test
    public void testGetPrix() {
        System.out.println("getPrix");
        FruitSimple instance = createFruit(0.6,"France");
        double expResult = 0.6;
        double result = instance.getPrix();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of setPrix method, of class FruitSimple.
     */
    @Test
    public void testSetPrix() {
        System.out.println("setPrix");
        double prix = 0.0;
        FruitSimple instance = createFruit(0.6,"France");
        instance.setPrix(prix);
        assertEquals(prix, instance.getPrix(), 0);
        
        System.out.println("setPrix");
        double prix1 = 0.8;
        FruitSimple instance1 = createFruitNull();
        instance.setPrix(prix1);
        assertEquals(prix1, instance1.getPrix(), 0);
    }

    /**
     * Test of getOrigine method, of class FruitSimple.
     */
    @Test
    public void testGetOrigine() {
        System.out.println("getOrigine");
        FruitSimple instance = createFruit(0.6,"France");
        String expResult = "France";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrigine method, of class FruitSimple.
     */
    @Test
    public void testSetOrigine() {
        System.out.println("setOrigine");
        String origine = "Danemark";
        FruitSimple instance = createFruit(0.6,"France");
        instance.setOrigine(origine);
        assertEquals(origine,instance.getOrigine(),0);
    }

    /**
     * Test of isSeedless method, of class FruitSimple.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        FruitSimple instance = createFruit(0.6,"France");
        boolean expResult = false;
        boolean result = instance.isSeedless();
        assertEquals(expResult, result);
    }

    
}
