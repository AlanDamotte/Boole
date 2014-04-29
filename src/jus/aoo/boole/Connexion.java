package jus.aoo.boole;

import jus.aoo.boole.port.*;

public class Connexion {
	private int num_composant;
	private Port entree;
	
	public Connexion get(){
		Connexion res=new Connexion(this.num_composant, this.entree.get());
		return res;
	}
	
	public void set(int num_composant, Port entree){
		this.num_composant=num_composant;
		this.entree=entree;
	}
	
	public Connexion(int num_composant, Port entree){
		this.num_composant=num_composant;
		this.entree=entree;
	}
}
