package fr.ufrsciencestech.panier.model.exception;

/**
 *
 * @author roudet
 */
public class PanierTropPetitException extends Exception {
    
    public PanierTropPetitException()
    {
	super("Ajout impossible car le panier est trop petit !");
    }

}
