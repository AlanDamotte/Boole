package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

public class Ou extends Transformateur{
	public Ou(Sortie sortie, Entree ent1, Entree ent2){
		super("Ou",new Sortie[1],new Entree[2]);
	}
	
	//Operer
	//sortie.set_etat(ent1.get_etat() || ent2.get_etat());
}
