package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.view.VueConsole;
import fr.ufrsciencestech.panier.view.VueG;
import fr.ufrsciencestech.panier.view.VueGSwing;
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

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }
    
    public VueG getVueg() {
        return vueg; 
    }
    public void setVueg(VueG vueg) {
        this.vueg = vueg; 
    }
    
    public static void main (String[] args){ 
        

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VueGSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueGSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueGSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueGSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
                Main testMVC = (Main)context.getBean("MVC");
                testMVC.setControleur( (Controleur)context.getBean("Controleur") );  //SpringIoC
                testMVC.setVueg( (VueGSwing)context.getBean("VueG") );   //SpringIoC
                Panier p = new Panier(5);
                VueConsole vuec = new VueConsole();

                testMVC.getControleur().setModele(p);                 
                p.addObserver(testMVC.getVueg());        
                p.addObserver(vuec);         
                testMVC.getVueg().addControleur(testMVC.getControleur());
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
