package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

import java.util.LinkedList;

public class Et extends Transformateur {
	public Et(){
		super("Et",1,2,new LinkedList<Sortie>(),new LinkedList<Entree>());
	}
	
	//Ceci est associé à l'opération opérer
	//sortie.set_etat(ent1.get_etat() && ent2.get_etat());
}
