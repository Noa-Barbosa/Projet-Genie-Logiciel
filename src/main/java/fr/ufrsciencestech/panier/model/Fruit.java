package fr.ufrsciencestech.panier.model;

/**
 * Interface representant la partie fruit du panier
 * @author noaba
 */
public interface Fruit extends Produit{
    /**
     * 
     * @return Vrai si le fruit est sans pépin, faux sinon
     */
    public boolean isSeedless();
}
