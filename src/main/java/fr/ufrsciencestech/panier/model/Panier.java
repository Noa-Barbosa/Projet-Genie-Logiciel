package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.exception.PanierPleinException;
import fr.ufrsciencestech.panier.model.exception.PanierTropPetitException;
import fr.ufrsciencestech.panier.model.exception.PanierVideException;
import java.util.*;
/**
 * Classe de modele principal de l'application
 * Le panier stocke l'ensemble des fruits de l'utilisateur et sert à faire des manipulations dessus
 * @author roudet
 */
public class Panier extends Observable{
    /**
     * Liste des fruits
     */
    private ArrayList<Fruit> fruits;
    
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
        this.fruits = new ArrayList<>(contenanceMax);
    }

    /**
     * affichage de ce qui est contenu dans le panier  
     * @return liste des fruits presents
     */
    @Override
    public String toString() {
        String retour="";
        for(int i =0;i<fruits.size();i++){
            Fruit f = this.fruits.get(i);
            retour +=  f.toString()+" ";
        }
        return retour;
    }
    
    /**
     * accesseur de la liste de fruits dans le panier
     * @return la listes des fruits 
     */
    public ArrayList<Fruit> getFruits() {
       return fruits;
    }

    /**
     * Remplace la liste de fruits si possible
     * @param f
     * @throws PanierTropPetitException 
     */
    public void setFruits(ArrayList<Fruit> f)throws PanierTropPetitException{
        if(this.getContenanceMax() < f.size()){
            throw new PanierTropPetitException();
        }else{
            this.fruits=f;
            notifyUpdate();
        }
    }
    /**
     * Ajout d'une suite de fruits
     * @param fruits liste contenant des fruits
     * @throws fr.ufrsciencestech.panier.model.PanierTropPetitException
     */
    public void ajoutFruits(ArrayList<Fruit> fruits) throws PanierTropPetitException{
        //Si taille array <= espace restant;
      if(fruits.size() <= this.contenanceMax-this.getFruits().size()){
          ArrayList<Fruit> mesFruits=this.getFruits();
          for(Fruit fruit:fruits)
          {
              mesFruits.add(fruit);
          }
          notifyUpdate();
      }else{
          throw new PanierTropPetitException();
      }
    }

    /**
     * accesseur retournant la taille allouee pour l'attibut fruits
     * @return taille du panier de fruits
     */
    public int getTaillePanier(){
        return fruits.size();
    }
    
    /**
     * accesseur de la taille du panier
     * @return la taille du panier
     */
    public int getContenanceMax(){
	return contenanceMax;
    }

    /**
     * accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
     * @param i emplacement du fruit dans la liste
     * @return retourne un objet de type Fruit
     */
    public Fruit getFruit(int i){
	return this.fruits.get(i);
    }
    
    /**
     * modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
     * @param i index de l'emplacement futur du fruit dans la liste
     * @param f L'objet Fruit à ajouter dans la liste
     */
    public void setFruit(int i, Fruit f){  
        this.fruits.set(i, f);
        notifyUpdate();
    }
    
    /**
     * predicat indiquant que le panier est vide
     * @return vrai si la liste est vide sinon faux
     */
    public boolean estVide(){  
	return this.fruits.isEmpty();
    }
    
    /**
     * predicat indiquant que le panier est plein ( si la contenance est égale à la contenanceMax)
     * @return un booleen, vrai si la liste pleinne et sinon faux
     */
    public boolean estPlein(){
	return this.fruits.size() == this.contenanceMax;
    }

    
    /**
     * ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
     * @param o Objet de type Fruit
     * @throws PanierPleinException vérifie si le panier est plein
     */
    public void ajout(Fruit o) throws PanierPleinException{  
       if(!this.estPlein()){
            this.fruits.add(o);
            notifyUpdate();
       }
       else{
        throw new PanierPleinException();
       }
    }

     /**
     * retire le dernier fruit du panier si celui-ci n'est pas vide
     * @throws PanierVideException vérifie si le panier n'est pas vide
     */
    public void retrait() throws PanierVideException{
        if(!this.estVide()){
            this.fruits.remove(this.fruits.size()-1);
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
     * @return Retourne une ArrayList des fruits de class fruit.
     */
    public ArrayList<Fruit> retrait(Fruit fruit){
        ArrayList<Fruit> mesFruits= this.getFruits();
        ArrayList<Fruit> ret=new ArrayList<>();
        for(Fruit f:mesFruits){ //Créer la liste de retour
            if(fruit.getClass() == f.getClass()){
                ret.add(f);
            }
        }
        for(Fruit f:ret){ //Retir les fruits du panier
            this.fruits.remove(f);
        }
        return ret;
    }
    
    /**
     * Supprime et retourne un fruit precis
     * @param index la position du fruit a récupérer et supprimer
     * @return Le fruit à la position index
     */
    public Fruit retrait(int index){
        Fruit ret = this.fruits.get(index);
        this.fruits.remove(index);
        notifyUpdate();
        return ret;
    }
    
    /**
     * Supprime seulement une instance précise de Fruit placée en paramètre
     * @param fruit 
     */
    public void retraitFruitSimple(Fruit fruit){
        this.fruits.remove(fruit);
    }

     /**
     * calcule le prix du panier par addition des prix de tous les fruits contenus dedans
     * @return un double correspondant à la somme de la valeur des fruits
     */
    public double getPrix(){ 
	int prix=0;
        for(Fruit fruit : this.fruits){
            prix+= fruit.getPrix();
        }
        return prix;
    }
    
    /**
     * supprime du panier tous les fruits provenant du pays origine
     * @param origine une chaine de charactere correspondant à l'origine des fruits visés
     */
    public void boycotteOrigine(String origine){  
	for (Fruit f : fruits) {
            if (f.getOrigine().equals(origine)){
                this.fruits.remove(f);
            }
        }
        notifyUpdate();
    }  
        
    /**
     * predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
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
                return this.fruits.equals(p.getFruits());
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
