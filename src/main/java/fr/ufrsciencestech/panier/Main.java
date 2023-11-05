package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.controler.ControleurFruit;
import fr.ufrsciencestech.panier.model.FruitSimple;
import fr.ufrsciencestech.panier.model.OrigineProduit;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.TypeFruitSimple;
import fr.ufrsciencestech.panier.model.TypeProduit;
import fr.ufrsciencestech.panier.view.VueConsole;
import fr.ufrsciencestech.panier.view.VueG;
import fr.ufrsciencestech.panier.view.VuePanier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Main 
{
    private VueG vueg;
    private Controleur controleur;

    public Controleur getControleur() {
        return controleur;
    }

    public void setControleur(ControleurFruit controleur) {
        this.controleur = controleur;
    }
    
    public VueG getVueg() {
        return vueg; 
    }
    public void setVueg(VueG vueg) {
        this.vueg = vueg; 
    }
    
    public static void main (String[] args){ 
        
        /* Create and display the form */
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
        /*Ecrire ici vos tests
        System.out.println("premier test Orange");
        Orange o1 = new Orange(3, "Argentine");
        System.out.println(o1);
        System.out.println("Test setter");
        o1.setPrix(50);
        o1.setOrigine("Finlande");
        System.out.println(o1);

        System.out.println("premier test Poire");
        Poire p1 = new Poire(55, "Martinique");
        System.out.println(p1);
        System.out.println("Test setter");
        p1.setPrix(100);
        p1.setOrigine("Danemark");
        System.out.println(p1);
        */
        
   }
}
