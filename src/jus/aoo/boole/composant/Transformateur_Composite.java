package jus.aoo.boole.composant;

import jus.aoo.boole.port.Port;
import jus.aoo.boole.*;

public class Transformateur_Composite extends $Composite {

	protected Port sor_tab[];
	protected Port ent_tab[];	

	
	public Transformateur_Composite(){
			super();
	}
	
	public Transformateur_Composite(String nom){
		super(nom);
	}
	

	public Transformateur_Composite (String nom, int s, int e, Circuit cir){
		super(nom,s,e, cir);
	}


}
