package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.controler.ControleurFruit;
import fr.ufrsciencestech.panier.model.FruitSimple;
import fr.ufrsciencestech.panier.model.OrigineProduit;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.TypeFruitSimple;
import fr.ufrsciencestech.panier.view.VueConsole;
import fr.ufrsciencestech.panier.view.VueG;
import fr.ufrsciencestech.panier.view.VuePanier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main de l'application
 *
 */
public class Main 
{
    /**
     * Vue principale de l'application
     */
    private VueG vueg;
    /**
     * Controleur de l'application
     */
    private Controleur controleur;

    /**
     * Assesseur du controleur
     * @return le controleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    /**
     * Mutateur du controleur
     * @param controleur le nouveau controleur
     */
    public void setControleur(ControleurFruit controleur) {
        this.controleur = controleur;
    }
    
    /**
     * Assesseur de la vue principale
     * @return la vue principale
     */
    public VueG getVueg() {
        return vueg; 
    }
    
    /**
     * Mutateur de la vue principale
     * @param vueg la nouvelle vue
     */
    public void setVueg(VueG vueg) {
        this.vueg = vueg; 
    }
    
    /**
     * Main de l'application,
     * utilise spring pour creer le controleur et la vue principale
     * met en place le pattern mvc avec addObserver
     * @param args 
     */
    public static void main (String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
                Main testMVC = (Main)context.getBean("MVC");
                testMVC.setControleur((ControleurFruit)context.getBean("Controleur") );  //SpringIoC
                testMVC.setVueg( (VuePanier)context.getBean("VueG") );   //SpringIoC
                Panier p = new Panier(10);
                
                VueConsole vuec = new VueConsole();

                testMVC.getControleur().setModele(p);                 
                p.addObserver(testMVC.getVueg());        
                p.addObserver(vuec);         
                testMVC.getVueg().addControleur(testMVC.getControleur());
                //ajoute des produit de base dans le panier
                try{
                    p.ajoutProduit(new FruitSimple(1.0, OrigineProduit.Espagne, TypeFruitSimple.Cerise));
                    p.ajoutProduit(new FruitSimple(1.0, OrigineProduit.Espagne, TypeFruitSimple.Cerise));
                    p.ajoutProduit(new FruitSimple(1.0, OrigineProduit.Espagne, TypeFruitSimple.Cerise));
                    p.ajoutProduit(new FruitSimple(1.5, OrigineProduit.France, TypeFruitSimple.Cerise));
                    p.ajoutProduit(new FruitSimple(1.5, OrigineProduit.France, TypeFruitSimple.Cerise));
                    p.ajoutProduit(new FruitSimple(2.5, OrigineProduit.France, TypeFruitSimple.Banane));
                    p.ajoutProduit(new FruitSimple(2.0, OrigineProduit.Allemagne, TypeFruitSimple.Banane));
                    p.ajoutProduit(new FruitSimple(1.5, OrigineProduit.France, TypeFruitSimple.Orange));
                }catch(Exception e){
                    System.err.println(e);
                }
            }
        });
        
   }
}
