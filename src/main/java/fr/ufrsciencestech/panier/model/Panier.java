package fr.ufrsciencestech.panier.model;

import java.util.*;
/**
 *
 * @author roudet
 */
public class Panier extends Observable{
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private final int contenanceMax;        //nb maximum d'oranges que peut contenir le panier
	
    //groupe 1
    public Panier(int contenanceMax){  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
	this.contenanceMax = contenanceMax;
        this.fruits = new ArrayList<>(contenanceMax);
    }

    @Override
    public String toString() {  //affichage de ce qui est contenu dans le panier : liste des fruits presents
        String retour="";
        for(int i =0;i<fruits.size();i++){
            Fruit f = this.fruits.get(i);
           retour =  f.toString();
        }
        return retour;
    }
    
    //groupe 2
    public ArrayList<Fruit> getFruits() {  //accesseur du premier attribut
       return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { //modificateur du premier attribut
      this.fruits=fruits;
    }

    public int getTaillePanier(){  //accesseur retournant la taille allouee pour l'attibut fruits
        return fruits.size();
    }
    
    public int getContenanceMax(){  //accesseur du second attribut
	return contenanceMax;
    }

    //groupe 3
    public Fruit getFruit(int i){  //accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
	return this.fruits.get(i);
    }
    
    public void setFruit(int i, Fruit f){  //modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
        this.fruits.set(i, f);
    }
    
    public boolean estVide(){  //predicat indiquant que le panier est vide
	return this.fruits.isEmpty();
    }
    
    public boolean estPlein(){  //predicat indiquant que le panier est plein
	return this.fruits.size() == this.contenanceMax;
    }

    //groupe 4
    public void ajout(Fruit o) throws PanierPleinException{  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
       if(!this.estPlein()){
            this.fruits.add(o);
            notifyUpdate();
       }
       else{
        throw new PanierPleinException();
       }
    }

    //groupe 5
    public void retrait() throws PanierVideException{ //retire le dernier fruit du panier si celui-ci n'est pas vide
        if(!this.estVide()){
            this.fruits.remove(this.fruits.size()-1);
            notifyUpdate();
        }
        else{
            throw new PanierVideException();
        }
    }

    //groupe 6
    public double getPrix(){  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans
	int prix=0;
        for(Fruit fruit : this.fruits){
            prix+= fruit.getPrix();
        }
        return prix;
    }
    
    //groupe 7
    public void boycotteOrigine(String origine){  //supprime du panier tous les fruits provenant du pays origine
	for (Fruit f : fruits) {
            if (f.getOrigine().equals(origine)){
                this.fruits.remove(f);
            }
        }
    }  
        
    //groupe 8    
    @Override
    public boolean equals(Object o){  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
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
    
    public void notifyUpdate(){
        setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
        notifyObservers(this.getTaillePanier());   //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed 
    }
    
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
