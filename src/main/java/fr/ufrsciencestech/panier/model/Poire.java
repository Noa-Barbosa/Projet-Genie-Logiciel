package fr.ufrsciencestech.panier.model;


import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.Fruit;

/**
 *
 * @author roudet
 */
public class Poire extends FruitSimple implements Fruit{
    private double prix;
    private String origine;
	
    public Poire() 
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }
    
    public Poire(double prix, String origine) 
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "Espagne";  //Espagne par défaut
	else
            this.origine = origine;   
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
	this.prix=prix;
    }

    public String getOrigine(){
	return origine;
    }
 
    public void setOrigine(String origine){
	this.origine=origine;
    }

    @Override
    public String toString(){
        return "Poire de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Poires sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Poire or = (Poire) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une Poire a des pepins
        return false;
    }
}
