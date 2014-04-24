package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

import java.util.LinkedList;

public class Et extends Transformateur {
	public Et(int numcomposant,Sortie sortie, Entree ent1, Entree ent2){
		super("Et",numcomposant,1,2,new LinkedList<Sortie>(),new LinkedList<Entree>());
		sortie.set_etat(ent1.get_etat() && ent2.get_etat());
		super.sor_list.add(sortie);
		super.ent_list.add(ent1);
		super.ent_list.add(ent2);
	}
}
