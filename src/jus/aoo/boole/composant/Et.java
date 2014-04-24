package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;
import java.util.LinkedList;
import java.util.List;

public class Et extends Transformateur {
	public Et(int numcomposant,List<Sortie> list_sort, List<Entree> list_ent){
		super("Et",numcomposant,1,2,list_sort,list_ent);
	}
	 boolean boole_et(Entree entree1, Entree entree2){
		return (entree1.get_etat() && entree2.get_etat());
	}
}
