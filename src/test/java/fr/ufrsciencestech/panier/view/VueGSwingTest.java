/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.TestUtils;
import fr.ufrsciencestech.panier.controler.ControleurFruit;
import fr.ufrsciencestech.panier.model.FruitSimple;
import fr.ufrsciencestech.panier.model.OrigineProduit;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.exception.PanierPleinException;
import fr.ufrsciencestech.panier.model.TypeProduit;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nb654417
 */
public class VueGSwingTest {
    private static VueGSwing vueg;
    private ControleurFruit c;
    private Panier p;
    
    public VueGSwingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        vueg = new VueGSwing();
        p = new Panier(5);
        c = new ControleurFruit();
        
        c.setModele(p);
        c.setVue(vueg);
        p.addObserver(vueg);
        vueg.addControleur(c);
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of update method, of class VueGraphique.
     */
    @Test
    public void testUpdate() throws PanierPleinException {
        System.out.println("update");
        
        //si on oublie d'ajouter la vue comme observateur du modele, elle ne se met pas à jour correctement
        assertEquals(vueg.getAffiche().getText(), "0");
        FruitSimple o = new FruitSimple(10,OrigineProduit.France,TypeProduit.Orange);
        p.ajoutProduit(o);
        
        assertEquals(vueg.getAffiche().getText(), "1");
        
        vueg.setAffiche(new JLabel("0", JLabel.CENTER));
        assertEquals(vueg.getAffiche().getText(), "0");       
    }
    
    @Test
    public void testAjout() {
        System.out.println("incr");
        assertNotNull(vueg);  // Instantiated?
        JPanel mainPanel = (JPanel)TestUtils.getChildNamed(vueg, "mainPanel");
        JLabel res = (JLabel)TestUtils.getChildNamed(mainPanel, "nbFruits");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(mainPanel, "plusButton");
        assertNotNull(plus);
        
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "1");
        plus.doClick();
        assertEquals(res.getText(), "2");
    }
    
    //https://www.javaworld.com/article/2073056/swing-gui-programming/automate-gui-tests-for-swing-applications.html
    @Test
    public void testAjoutRetire() {
        System.out.println("decr");
        assertNotNull(vueg);  // Instantiated?
        JPanel mainPanel = (JPanel)TestUtils.getChildNamed(vueg, "mainPanel");
        JLabel res = (JLabel)TestUtils.getChildNamed(mainPanel, "nbFruits");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(mainPanel, "plusButton");
        assertNotNull(plus);
        final JButton minus = (JButton)TestUtils.getChildNamed(mainPanel, "minusButton");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "1");
        minus.doClick();
        assertEquals(res.getText(), "0");
    }
    
    @Test
    public void testRetirOnEmpty() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        JPanel mainPanel = (JPanel)TestUtils.getChildNamed(vueg, "mainPanel");
        JLabel res = (JLabel)TestUtils.getChildNamed(mainPanel, "nbFruits");
        assertNotNull(res); // Component found?
        final JButton minus = (JButton)TestUtils.getChildNamed(mainPanel, "minusButton");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        minus.doClick();
        assertEquals(res.getText(), "0");
    }
}
