package jus.aoo.boole.composant;
import java.util.LinkedList;

import jus.aoo.boole.port.*;

public class Non extends Transformateur{
	public Non(int numcomposant,Sortie sortie, Entree entree){
		super("Ou",numcomposant,1,2,new LinkedList<Sortie>(),new LinkedList<Entree>());
		sortie.set_etat(!entree.get_etat());
		super.sor_list.add(sortie);
		super.ent_list.add(entree);
	}
}
