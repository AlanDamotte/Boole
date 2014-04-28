package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;


public class Et extends Transformateur {
	public Et(){
		super("Et",new Sortie[1],new Entree[2]);
	}
	
	//Ceci est associé à l'opération opérer
	//sortie.set_etat(ent1.get_etat() && ent2.get_etat());
}
