package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;



public abstract class $Generateur extends $Composant {

	public $Generateur(){
		super();
	}
	
	public $Generateur (String nom, Sortie sor_tab[]){
		super(nom,sor_tab,new Entree[0]);
		this.sor_tab=sor_tab;
	}
}
