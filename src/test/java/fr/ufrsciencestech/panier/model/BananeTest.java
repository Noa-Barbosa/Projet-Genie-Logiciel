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
public class BananeTest {
    
    public BananeTest() {
        System.out.println("ConstructorNull");
        Banane instance = new Banane();
        double expResult = 0.5;
        double result = instance.getPrix();
        assertEquals(expResult, result, 0);
        //
        System.out.println("Constructor");
        Banane instance1 = new Banane(0.6,"Danemark");
        double expResult1 = 0.5;
        double result1 = instance1.getPrix();
        assertEquals(expResult1, result1, 0);

    }


    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
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
     * Test of getPrix method, of class Banane.
     */
    @org.junit.Test
    public void testGetPrix() {
        System.out.println("getPrix");
        Banane instance = new Banane();
        double expResult = 0.0;
        double result = instance.getPrix();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrix method, of class Banane.
     */
    @org.junit.Test
    public void testSetPrix() {
        System.out.println("setPrix");
        double prix = 0.0;
        Banane instance = new Banane();
        instance.setPrix(prix);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrigine method, of class Banane.
     */
    @org.junit.Test
    public void testGetOrigine() {
        System.out.println("getOrigine");
        Banane instance = new Banane();
        String expResult = "";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrigine method, of class Banane.
     */
    @org.junit.Test
    public void testSetOrigine() {
        System.out.println("setOrigine");
        String origine = "";
        Banane instance = new Banane();
        instance.setOrigine(origine);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Banane.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        Banane instance = new Banane();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Banane.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Banane instance = new Banane();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSeedless method, of class Banane.
     */
    @org.junit.Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        Banane instance = new Banane();
        boolean expResult = false;
        boolean result = instance.isSeedless();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
