package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;



//Penser à faire binaire et unaire, ensuite operer sera la seule méthode dans et, ou,..


public abstract class $Transformateur extends $Composant {
	
	public $Transformateur(){
			super();
	}
	
	public $Transformateur (String nom, Port sor_tab[], Port ent_tab[]){
		super(nom, sor_tab, ent_tab);
	}
	
}
