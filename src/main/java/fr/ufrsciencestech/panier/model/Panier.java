package fr.ufrsciencestech.panier.model;

import java.util.*;
/**
 *
 * @author roudet
 */
public class Panier extends Observable{
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private final int contenanceMax;        //nb maximum d'oranges que peut contenir le panier
	
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
           retour =  f.toString();
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
     * modificateur de la liste de fruits dans le panier 
     * @param fruits liste contenant des fruits
     */
    public void setFruits(ArrayList<Fruit> fruits) {
      this.fruits=fruits;
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
    public void notifyUpdate(){
        setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
        notifyObservers(this.getTaillePanier());   //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed 
    }
    
    /**
     * Modifie le panier à partir d'une action
     * @param action type d'action à réaliser (ex 1 correspond à l'ajout)
     * @throws PanierPleinException exception si le panier est plein
     * @throws PanierVideException exception si le panier est vide
     */
    public void update(int action) throws PanierPleinException, PanierVideException {
        
        //ajoute ou enleve une orange du panier
        if(action == 1){
       
            Orange o = new Orange(156,"Espagne");
            this.ajout(o);
           
        }
        else{
            this.retrait();
        }
        
        notifyUpdate();
    }
}