/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.exception.PanierPleinException;
import fr.ufrsciencestech.panier.model.exception.PanierTropPetitException;
import fr.ufrsciencestech.panier.model.exception.PanierVideException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexi
 */
public class PanierTest {
    private Panier panierVide4;
    private Panier panierVide0;
    private Panier panier1_4;
    private Panier panierPlein1;
    private Panier panierPlein2;
    private Panier panierPlein3;
    private Panier panierNonPlein;
    private FruitSimple o;
    private FruitSimple o1;
    private FruitSimple o2;
    private FruitSimple P;
    private FruitSimple p1;
    private FruitSimple p2;
    
    
    public PanierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws PanierPleinException {
        panierVide4 = new Panier(4);
        panierVide0 = new Panier(0);
        panier1_4 = new Panier(4);
        panierPlein1 = new Panier(1);
        panierPlein2 = new Panier(2);
        panierPlein3 = new Panier(3);
        panierNonPlein = new Panier(8);
        
         o = new FruitSimple(1,"espagna",TypeProduit.Orange);
         o1 = new FruitSimple(2,"la rora",TypeProduit.Orange);
         o2 = new FruitSimple(3,"ignesta",TypeProduit.Orange);
         P = new FruitSimple(0.5,"uno",TypeProduit.Poire);
         p1 = new FruitSimple(0.5,"dos",TypeProduit.Poire);
         p2 = new FruitSimple(0.5,"tres",TypeProduit.Poire);
        
        panier1_4.ajout(P);
        
        panierPlein1.ajout(P);
        panierPlein2.ajout(o);
        panierPlein2.ajout(P);
        
        panierPlein3.ajout(P);
        panierPlein3.ajout(p1);
        panierPlein3.ajout(P);
        
        panierNonPlein.ajout(P);
        panierNonPlein.ajout(p1);
        panierNonPlein.ajout(p2);
        panierNonPlein.ajout(o);
        panierNonPlein.ajout(o1);
        panierNonPlein.ajout(o2);

       
    }
    
    @After
    public void tearDown() {
    }

        @Test
    public void testToString()
    {
        
        String result = panierPlein2.toString();
        String attente = o.toString()+" "+P.toString()+" ";
        assertEquals(result,attente);
    }

    /**
     * Test of getFruits method, of class Panier.
     */
    @Test
    public void testGetFruits() {
        // Testez la méthode getFruits() sur un panier vide (panierVide4)
    ArrayList<Fruit> fruitsVide = panierVide4.getFruits();
    assertTrue(fruitsVide.isEmpty());

    // Testez la méthode getFruits() sur un panier avec un fruit (panier1_4)
    ArrayList<Fruit> fruits1Fruit = panier1_4.getFruits();
    assertEquals(1, fruits1Fruit.size());
    assertTrue(fruits1Fruit.contains(P)); // Assurez-vous d'importer correctement la classe Poire

    // Testez la méthode getFruits() sur un panier plein (panierNonPlein)
    ArrayList<Fruit> fruitsNonPlein = panierNonPlein.getFruits();
    assertEquals(6, fruitsNonPlein.size()); // Vous avez ajouté 6 fruits
    assertTrue(fruitsNonPlein.contains(P));
    assertTrue(fruitsNonPlein.contains(p1));
    assertTrue(fruitsNonPlein.contains(p2));
    assertTrue(fruitsNonPlein.contains(o));
    assertTrue(fruitsNonPlein.contains(o1));
    assertTrue(fruitsNonPlein.contains(o2));
    }

    /**
     * Test of setFruits method, of class Panier.
     */
    @Test
    public void testSetFruits() throws PanierTropPetitException {
        // Testez la méthode setFruit() sur un panier vide (panierVide4)
        
    panierVide4.setFruits(panierPlein1.getFruits()); // Remplacez le premier élément du panier par une orange
    assertEquals(panierPlein1.getFruits(), panierVide4.getFruits()); // Vérifiez que le premier élément est maintenant une orange

    // Testez la méthode setFruit() sur un panier avec un fruit (panier1_4)
    panier1_4.setFruits(panierPlein1.getFruits()); // Remplacez l'unique élément du panier par une poire
    assertEquals(panierPlein1.getFruits(), panier1_4.getFruits()); // Vérifiez que l'unique élément est maintenant une poire

    // Testez la méthode setFruit() sur un panier plein (panierPlein2)
    panierPlein2.setFruits(panierPlein1.getFruits()); // Remplacez le deuxième élément du panier par une orange supplémentaire
    assertEquals(panierPlein3.getFruits(), panierPlein2.getFruits()); // Vérifiez que le deuxième élément est maintenant une orange

    
        }

    /**
     * Test of getTaillePanier method, of class Panier.
     */
    @Test
    public void testGetTaillePanier() {
        // Testez la méthode getTaillePanier() sur un panier vide (panierVide4)
    assertEquals(0, panierVide4.getTaillePanier()); // Le panier doit être vide

    // Testez la méthode getTaillePanier() sur un panier avec un fruit (panier1_4)
    assertEquals(1, panier1_4.getTaillePanier()); // Le panier doit contenir 1 fruit

    // Testez la méthode getTaillePanier() sur un panier plein (panierPlein2)
    assertEquals(2, panierPlein2.getTaillePanier()); // Le panier doit contenir 2 fruits

    }

    /**
     * Test of getContenanceMax method, of class Panier.
     */
    @Test
    public void testGetContenanceMax() {
        // Testez la méthode getContenanceMax() sur un panier vide (panierVide4)
    assertEquals(4, panierVide4.getContenanceMax()); // La contenance maximale doit être de 4

    // Testez la méthode getContenanceMax() sur un panier avec un fruit (panier1_4)
    assertEquals(4, panier1_4.getContenanceMax()); // La contenance maximale doit toujours être de 4

    // Testez la méthode getContenanceMax() sur un panier plein (panierPlein2)
    assertEquals(2, panierPlein2.getContenanceMax()); // La contenance maximale doit être de 2

    }

    /**
     * Test of getFruit method, of class Panier.
     */
    @Test
    public void testGetFruit() {
        // Testez la méthode getFruit() sur un panier avec un fruit (panier1_4)
    assertEquals(P, panier1_4.getFruit(0)); // Le premier élément du panier doit être la poire P

    // Testez la méthode getFruit() sur un panier plein (panierPlein2)
    assertEquals(P, panierPlein2.getFruit(0)); // Le premier élément du panier doit être la poire P
    assertEquals(o, panierPlein2.getFruit(1)); // Le deuxième élément du panier doit être l'orange o

    // Testez la méthode getFruit() sur un index invalide (panierPlein1)
    assertNull(panierPlein1.getFruit(1)); // L'index 1 est invalide, la méthode doit renvoyer null

    }

    /**
     * Test of setFruit method, of class Panier.
     */
    @Test
    public void testSetFruit() {
        // Testez la méthode setFruit() sur un panier avec un fruit (panier1_4)
        panier1_4.setFruit(0, p1); // Remplacez la poire P par la poire p1
        assertEquals(p1, panier1_4.getFruit(0)); // Vérifiez que le premier élément est maintenant la poire p1

        // Testez la méthode setFruit() sur un panier plein (panierPlein2)
        panierPlein2.setFruit(1, o2); // Remplacez l'orange o par l'orange o2
        assertEquals(o2, panierPlein2.getFruit(1)); // Vérifiez que le deuxième élément est maintenant l'orange o2

        // Testez la méthode setFruit() sur un index invalide (panierPlein1)
        // Cette méthode ne devrait rien changer dans ce cas
        panierPlein1.setFruit(1, p1);
        assertEquals(P, panierPlein1.getFruit(0)); // Le premier élément doit rester la poire P
        assertNull(panierPlein1.getFruit(1)); // L'index 1 est invalide, la méthode doit renvoyer null

    }

    /**
     * Test of estVide method, of class Panier.
     */
    @Test
    public void testEstVide() {
        // Testez la méthode estVide() sur un panier vide (panierVide4)
        assertTrue(panierVide4.estVide()); // Le panier doit être vide

        // Testez la méthode estVide() sur un panier avec un fruit (panier1_4)
        assertFalse(panier1_4.estVide()); // Le panier ne doit pas être vide car il contient la poire P

        // Testez la méthode estVide() sur un panier plein (panierPlein2)
        assertFalse(panierPlein2.estVide()); // Le panier ne doit pas être vide car il contient l'orange o et o2

    }

    /**
     * Test of estPlein method, of class Panier.
     */
    @Test
    public void testEstPlein() {
        // Testez la méthode estPlein() sur un panier vide (panierVide4)
        assertFalse(panierVide4.estPlein()); // Le panier ne doit pas être plein car il est vide

        // Testez la méthode estPlein() sur un panier avec un fruit (panier1_4)
        assertFalse(panier1_4.estPlein()); // Le panier ne doit pas être plein car il ne contient qu'une poire

        // Testez la méthode estPlein() sur un panier plein (panierPlein2)
        assertTrue(panierPlein2.estPlein()); // Le panier doit être plein car il contient deux fruits (contenance max = 2)

    }

    /**
     * Test of ajout method, of class Panier.
     */
    @Test
    public void testAjout() throws Exception {
        // Testez la méthode ajout() sur un panier vide (panierVide4)
    panierVide4.ajout(o); // Ajoutez une orange
    assertEquals(1, panierVide4.getTaillePanier()); // Le panier doit contenir 1 fruit (l'orange o)

    // Testez la méthode ajout() sur un panier avec un fruit (panier1_4)
    panier1_4.ajout(o1); // Ajoutez une orange
    assertEquals(2, panier1_4.getTaillePanier()); // Le panier doit contenir 2 fruits (la poire P et l'orange o1)

    // Testez la méthode ajout() sur un panier plein (panierPlein2)
    try {
        panierPlein2.ajout(p1); // Essayez d'ajouter une poire au panier plein
        fail("Une PanierPleinException devrait être levée");
    } catch (PanierPleinException e) {
        // L'exception a été levée, ce qui est attendu
    }
    }

    /**
     * Test of retrait method, of class Panier.
     */
    @Test
    public void testRetrait() throws Exception {
        // Testez la méthode retrait() sur un panier avec un fruit (panier1_4)
        panier1_4.retrait(); // Retirez la poire du panier
        assertEquals(0, panier1_4.getTaillePanier()); // Le panier doit être vide

        // Testez la méthode retrait() sur un panier plein (panierPlein2)
        panierPlein2.retrait(); // Retirez l'orange du panier
        assertEquals(1, panierPlein2.getTaillePanier()); // Le panier doit contenir 1 fruit (l'orange o2)

        // Testez la méthode retrait() sur un panier vide (panierVide0)
        try {
            panierVide0.retrait(); // Essayez de retirer un fruit d'un panier vide
            fail("Une PanierVideException devrait être levée");
        } catch (PanierVideException e) {
            // L'exception a été levée, ce qui est attendu
        }
    }

    /**
     * Test of getPrix method, of class Panier.
     */
    @Test
    public void testGetPrix() {
        // Testez la méthode getPrix() sur un panier vide (panierVide4)
    assertEquals(0.0, panierVide4.getPrix(), 0.01); // Le prix du panier vide doit être de 0.0

    // Testez la méthode getPrix() sur un panier avec des fruits (panierNonPlein)
    assertEquals(7.0, panierNonPlein.getPrix(), 0.01); // Le prix du panier doit être la somme des prix des fruits (0.5 + 0.5 + 0.5 + 1.0 + 2.0 + 3.0 = 7.0)

    }

    /**
     * Test of boycotteOrigine method, of class Panier.
     */
    @Test
    public void testBoycotteOrigine() {
        // Testez la méthode boycotteOrigine() sur un panier avec des fruits (panierNonPlein)
        panierNonPlein.boycotteOrigine("espagna"); // Boycottez les fruits originaires d'Espagne

        // Vérifiez que les oranges d'Espagne ont été supprimées du panier
        for (Fruit fruit : panierNonPlein.getFruits()) {
            assertNotEquals("espagna", fruit.getOrigine()); // Aucun fruit ne devrait provenir d'Espagne
        }
    }

    /**
     * Test of equals method, of class Panier.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Panier instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Panier.
     */
    @Test
    public void testNotifyUpdate() throws Exception {
        // Testez la méthode update() avec action 1 (ajout) sur un panier vide (panierVide4)
        panierVide4.ajout(o1);
    panierVide4.notifyUpdate(); // Ajoutez une orange au panier vide
    assertEquals(1, panierVide4.getTaillePanier()); // Le panier doit contenir 1 fruit (l'orange ajoutée)

    // Testez la méthode update() avec action 2 (retrait) sur un panier avec un fruit (panier1_4)
    panier1_4.retrait();
    panier1_4.notifyUpdate(); // Retirez le dernier fruit (la poire) du panier
    assertEquals(0, panier1_4.getTaillePanier()); // Le panier doit être vide

    // Testez la méthode update() avec action 1 (ajout) sur un panier plein (panierPlein2)
    try {
        panierPlein2.ajout(o1);
        panierPlein2.notifyUpdate(); // Essayez d'ajouter une poire au panier plein
        fail("Une PanierPleinException devrait être levée");
    } catch (PanierPleinException e) {
        // L'exception a été levée, ce qui est attendu
    }
    }
    
}

