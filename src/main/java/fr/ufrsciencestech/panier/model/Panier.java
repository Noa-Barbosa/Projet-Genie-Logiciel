package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.exception.PanierPleinException;
import fr.ufrsciencestech.panier.model.exception.PanierTropPetitException;
import fr.ufrsciencestech.panier.model.exception.PanierVideException;
import java.util.*;
/**
 * Classe de modele principal de l'application
 Le panier stocke l'ensemble des produits de l'utilisateur et sert à faire des manipulations dessus
 * @author roudet
 */
public class Panier extends Observable{
    /**
     * Liste des produits du panier
     */
    private ArrayList<Produit> produits;
    
    /**
     * Contenance maximum du panier
     */
    private final int contenanceMax;
	
    /**
     * initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
     * @param contenanceMax taille max 
     */
    public Panier(int contenanceMax){
	this.contenanceMax = contenanceMax;
        this.produits = new ArrayList<>(contenanceMax);
    }
    
    /**
     * accesseur de la liste de produits dans le panier
     * @return la listes des produits 
     */
    public ArrayList<Produit> getProduits() {
       return produits;
    }

    /**
     * Remplace la liste de produits si possible
     * @param p
     * @throws PanierTropPetitException 
     */
    public void setProduits(ArrayList<Produit> p)throws PanierTropPetitException{
        if(this.getContenanceMax() < p.size()){
            throw new PanierTropPetitException();
        }else{
            this.produits=p;
            notifyUpdate();
        }
    }
    
    /**
     * accesseur retournant le produit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
     * @param i emplacement du produit dans la liste
     * @return retourne un objet de type Produit
     */
    public Produit getProduit(int i){
        if(i>=this.getProduits().size() && i>-1){
            return null;
        }
	return this.produits.get(i);
    }
    
    /**
     * modificateur du produit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un produit a cet emplacement, ne rien faire sinon)
     * @param i index de l'emplacement futur du produit dans la liste
     * @param p L'objet Produit à ajouter dans la liste
     */
    public void setProduit(int i, Produit p){  
        if(i<this.getProduits().size() && i>-1){
            this.produits.set(i, p);
            notifyUpdate();
        }
        
    }
    
    /**
     * accesseur retournant la taille allouee pour l'attibut produits
     * @return taille du panier de produits
     */
    public int getTaillePanier(){
        return produits.size();
    }
    
    /**
     * accesseur de la taille du panier
     * @return la taille du panier
     */
    public int getContenanceMax(){
	return contenanceMax;
    }
    
    /**
     * calcule le prix du panier par addition des prix de tous les produits contenus dedans
     * @return un double correspondant à la somme de la valeur des produits
     */
    public double getPrix(){ 
	double prix=0;
        for(Produit produit : this.produits){
            prix+= produit.getPrix();
        }
        return prix;
    }
    
    /**
     * predicat indiquant que le panier est vide
     * @return vrai si la liste est vide sinon faux
     */
    public boolean estVide(){  
	return this.produits.isEmpty();
    }
    
    /**
     * predicat indiquant que le panier est plein ( si la contenance est égale à la contenanceMax)
     * @return un booleen, vrai si la liste pleine et sinon faux
     */
    public boolean estPlein(){
	return this.produits.size() == this.contenanceMax;
    }

    /**
     * indique la quantité restante de produits que l'on peut mettre dans le panier
     * @return un entier, la soustraction de la contenance max du panier avec sa taille
     */
    public int quantiteRestante(){
        return this.getContenanceMax() - this.getTaillePanier();
    }
    
    /**
     * ajoute le produit o a la fin du panier si celui-ci n'est pas plein
     * @param o Objet de type Produit
     * @throws PanierPleinException vérifie si le panier est plein
     */
    public void ajoutProduit(Produit o) throws PanierPleinException{  
       if(!this.estPlein()){
            this.produits.add(o);
            notifyUpdate();
       }
       else{
        throw new PanierPleinException();
       }
    }
    
    /**
     * Ajout d'une suite de produits
     * @param produits liste contenant des produits
     * @throws fr.ufrsciencestech.panier.model.exception.PanierTropPetitException
     */
    public void ajoutProduits(ArrayList<Produit> produits) throws PanierTropPetitException{
        //Si taille array <= espace restant;
      if(produits.size() <= this.contenanceMax-this.getProduits().size()){
          ArrayList<Produit> mesProduits=this.getProduits();
          for(Produit produit:produits)
          {
              mesProduits.add(produit);
          }
          notifyUpdate();
      }else{
          throw new PanierTropPetitException();
      }
    }
    
    /**
     * Retire la premiere occurence du produit
     * @param p produit
     */
    public void retraitProduit(Produit p) {
        this.produits.remove(p);
        notifyUpdate();
    }
    
    /**
    * Supprime et retourne un produit precis
    * @param index la position du produit a récupérer et supprimer
    * @return Le produit à la position index
    */
    public Produit retraitProduitAt(int index){
        Produit ret = this.produits.get(index);
        this.produits.remove(index);
        notifyUpdate();
        return ret;
    }
    
    
     /**
     * retire le dernier produit du panier si celui-ci n'est pas vide
     * @throws PanierVideException vérifie si le panier n'est pas vide
     */
    public void retraitLastProduit() throws PanierVideException{
        if(!this.estVide()){
            this.produits.remove(this.produits.size()-1);
            notifyUpdate();
        }
        else{
            throw new PanierVideException();
        }
    }

    /**
     * Supprime tout les produits d'un meme type du Panier
     * @param type le type de produit
     */
    public void retraitAllProduitsByType(TypeProduit type){
        //ArrayList<Fruit> mesFruits= this.getFruits();
        ArrayList<Produit> mesProduits= this.getProduits();
        ArrayList<Produit> produitsAEnlever=new ArrayList<>();
        for(Produit p:mesProduits){ 
            if(p.getTypeProduit().equals(type)){
                produitsAEnlever.add(p);
            }
        }
        for(Produit p:produitsAEnlever){ //Retir les produits du panier
            this.produits.remove(p);
        }
        notifyUpdate();
    }
    
    /**
     * supprime du panier tous les produits provenant du pays origine
     * @param origine une chaine de charactere correspondant à l'origine des produits visés
     */
    public void boycotteOrigine(OrigineProduit origine){
        ArrayList<Produit> produitsAEnlever = new ArrayList<>();
	for (Produit p : this.produits) {
            if (p.getOrigine().equals(origine)){
                produitsAEnlever.add(p);
            }
        }
        this.produits.removeAll(produitsAEnlever);
        
        notifyUpdate();
    }  
    
    /**
     * Modifie le premier produit en paramètre par un nouveau prix et une nouvelle origine
     * (ne modifie que la première occurence du produit dans la liste)
     * @param init
     * @param pModif
     * @param quantiteAModif
     */
    public void produitModif(Produit init, Produit pModif, int quantiteAModif){           
        int compteur = 0;
        
        for(Produit produit : this.getProduits()){
            if(compteur == quantiteAModif){
                break;
            }else if(init.equals(produit)){
                produit.setOrigine(pModif.getOrigine());
                produit.setPrix(pModif.getPrix());
                compteur++;
            }
        }
        notifyUpdate();
    }
        
    /**
     * predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes produits
     * @param o Objet de type Panier
     * @return un booleen vrai si les paniers sont identiques sinon faux
     */   
    @Override
    public boolean equals(Object o){  
        if(o.getClass().equals(this.getClass())){
            Panier p = (Panier) o;
            if(this.getTaillePanier()!=p.getTaillePanier()){
                return false;
            }
            else{
                return this.produits.equals(p.getProduits());
            }
        }
        else{
            return false;
        }
    }
    
    /**
     * affichage de ce qui est contenu dans le panier  
     * @return liste des produits presents
     */
    @Override
    public String toString() {
        String retour="";
        for(int i =0;i<produits.size();i++){
            Produit p = this.produits.get(i);
            retour +=  p.toString()+" ";
        }
        return retour;
    }
    
    /**
     * Observe la taille du panier
     */
    private void notifyUpdate(){
        setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
        notifyObservers(this);   //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed 
        clearChanged();
    }
}
