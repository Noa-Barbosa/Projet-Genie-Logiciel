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
     * accesseur retournant le produit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
     * @param i emplacement du produit dans la liste
     * @return retourne un objet de type Produit
     */
    public Produit getProduit(int i){
	return this.produits.get(i);
    }
    
    /**
     * modificateur du produit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un produit a cet emplacement, ne rien faire sinon)
     * @param i index de l'emplacement futur du produit dans la liste
     * @param p L'objet Produit à ajouter dans la liste
     */
    public void setProduit(int i, Produit p){  
        this.produits.set(i, p);
        notifyUpdate();
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
     * @return un booleen, vrai si la liste pleinne et sinon faux
     */
    public boolean estPlein(){
	return this.produits.size() == this.contenanceMax;
    }

    
    /**
     * ajoute le produit o a la fin du panier si celui-ci n'est pas plein
     * @param o Objet de type Produit
     * @throws PanierPleinException vérifie si le panier est plein
     */
    public void ajout(Produit o) throws PanierPleinException{  
       if(!this.estPlein()){
            this.produits.add(o);
            notifyUpdate();
       }
       else{
        throw new PanierPleinException();
       }
    }

     /**
     * retire le dernier produit du panier si celui-ci n'est pas vide
     * @throws PanierVideException vérifie si le panier n'est pas vide
     */
    public void retrait() throws PanierVideException{
        if(!this.estVide()){
            this.produits.remove(this.produits.size()-1);
            notifyUpdate();
        }
        else{
            throw new PanierVideException();
        }
    }

    /**
     * Retourne une sous catégorie de fruit A MODIFIER POUR PRENDRE NE COMPTE L'ENUM
     * ex : Si le fruit en parmetre est une orange, retourne un liste de toutes les oranges du panier.
     * @param fruit le type de fruit
     * @return Retourne une ArrayList des produits de class fruit.
     */
    public ArrayList<Fruit> retrait(Fruit fruit){
        //ArrayList<Fruit> mesFruits= this.getFruits();
        ArrayList<Fruit> mesFruits= new ArrayList<>();
        ArrayList<Fruit> ret=new ArrayList<>();
        for(Fruit f:mesFruits){ //Créer la liste de retour
            if(fruit.getClass() == f.getClass()){
                ret.add(f);
            }
        }
        for(Fruit f:ret){ //Retir les produits du panier
            this.produits.remove(f);
        }
        return ret;
    }
    
    /**
     * Supprime et retourne un produit precis
     * @param index la position du produit a récupérer et supprimer
     * @return Le produit à la position index
     */
    public Produit retrait(int index){
        Produit ret = this.produits.get(index);
        this.produits.remove(index);
        notifyUpdate();
        return ret;
    }
    
    /**
     * Supprime seulement une instance précise de Fruit placée en paramètre
     * @param fruit 
     */
    public void retraitFruitSimple(Fruit fruit){
        this.produits.remove(fruit);
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
     * Observe la taille du panier
     */
    private void notifyUpdate(){
        setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
        notifyObservers(this);   //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed 
        clearChanged();
    }
}
