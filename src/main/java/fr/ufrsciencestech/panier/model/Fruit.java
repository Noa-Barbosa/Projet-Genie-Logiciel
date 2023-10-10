package fr.ufrsciencestech.panier.model;

/**
 *
 * @author noaba
 */
public interface Fruit {
    /**
     * 
     * @return Vrai si le fruit est sans pépin, faux sinon
     */
    public boolean isSeedless();
    
    /**
     * 
     * @return le prix du fruit
     */
    public double getPrix();
    
    /**
     * Modifie le prix du fruit
     * @param prix le prix a modifier
     */
    public void setPrix(double prix);
    
    /**
     * 
     * @return l'origine du fruit
     */
    public String getOrigine();   
    
    /***
     * Modifie l'origine d'un fruit
     * @param origine l'origine a modifie
     */
    public void setOrigine(String origine);
    
    /**
     * 
     * @param o 
     * @return vrai si l'objet en paramètre est égale a this
     */
    @Override
    public boolean equals(Object o);  //predicat pour tester si 2 fruits sont equivalents
    
    /**
     * 
     * @return la chaine representant le fruit
     */
    @Override
    public String toString();    //affichage d'un fruit
}
