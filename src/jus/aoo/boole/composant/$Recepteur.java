package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;


public abstract class $Recepteur extends $Composant {
	
	public $Recepteur(){
		super();
	}
	
	public $Recepteur (String nom, Entree ent_tab[]){
		super(nom,new Sortie[0],ent_tab);
		this.ent_tab=ent_tab;
	}
}