package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;


public class Recepteur extends $Composant {
	
	public Recepteur(){
		super();
	}
	
	public Recepteur (String nom, Entree ent_tab[]){
		super(nom,new Sortie[0],ent_tab);
		this.ent_tab=ent_tab;
	}
	
	public Entree[] ent_tab(){
		Entree[] res; 
		res=ent_tab.clone(); 
		return res;
	}
}