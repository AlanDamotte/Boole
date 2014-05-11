package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;
import jus.aoo.boole.*;

public class Generateur_Composite extends $Composite {

	protected Port sor_tab[];
	protected Port ent_tab[];	

	
	public Generateur_Composite(){
			super();
	}
	
	public Generateur_Composite(String nom){
		super(nom);
	}
	
	public Generateur_Composite (String nom, int s, Circuit cir){
		super(nom,s,0, cir);
	}

	
	
}
