package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

//Cette classe représente les composants possédant des entrées et des sorties
public abstract class $Transformateur extends $Composant {
	
	public $Transformateur(){
			super();
	}
	
	public $Transformateur (String nom, Port sor_tab[], Port ent_tab[]){
		super(nom, sor_tab, ent_tab);
	}
	
}
