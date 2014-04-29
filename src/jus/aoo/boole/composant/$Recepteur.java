package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;


public abstract class $Recepteur extends $Composant {
	
	public $Recepteur(){
		super();
	}
	
	public $Recepteur (String nom, Port ent_tab[]){
		super(nom,new Port[0],ent_tab);
		this.ent_tab=ent_tab;
	}
}