/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thendis
 */
public class SaladeFruitsTest {
    
    public SaladeFruitsTest() {
        
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
     * Test of isSeedless method, of class SaladeFruits.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        SaladeFruits instance = new SaladeFruits(0,"Test");
        Fruit fruit = new Cerise();
        instance.ajoutFruit(fruit);
        boolean expResult = false;
        boolean result = instance.isSeedless();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrix method, of class SaladeFruits.
     */
    @Test
    public void testGetPrix() {
        System.out.println("getPrix");
        SaladeFruits instance = new SaladeFruits(17,"Test");
        double expResult = 17;
        double result = instance.getPrix();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getOrigine method, of class SaladeFruits.
     */
    @Test
    public void testGetOrigine() {
        System.out.println("getOrigine");
        SaladeFruits instance = new SaladeFruits(0,"Test");
        String expResult = "Test";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }

    /**
     * Test of ajoutFruit method, of class SaladeFruits.
     */
    @Test
    public void testAjoutFruit() {
        System.out.println("ajoutFruit");
        Fruit fruit = new Orange();
        SaladeFruits instance = new SaladeFruits(0,"Test");
        instance.ajoutFruit(fruit);
        ArrayList<Fruit> listeFruits=instance.getFruits();
        assertEquals(1,listeFruits.size());
    }

    /**
     * Test of retirFruit method, of class SaladeFruits.
     */
    @Test
    public void testRetirFruit() {
        System.out.println("retirFruit");
        Fruit fruit = new Orange();
        SaladeFruits instance = new SaladeFruits(0,"Test");
        instance.ajoutFruit(fruit);
        instance.retirFruit(fruit);
        assertEquals(0,instance.getFruits().size());
    }

    /**
     * Test of toString method, of class SaladeFruits.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SaladeFruits instance = new SaladeFruits(0,"Test");
        Fruit fruit = new Cerise();
        Fruit fruit2 = new Orange();
        instance.ajoutFruit(fruit);
        instance.ajoutFruit(fruit2);
        String expResult = "Prix Total : "+instance.getPrix()+"\n";
        expResult+=fruit.toString()+"\n";
        expResult+=fruit2.toString()+"\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
