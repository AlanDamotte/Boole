package jus.aoo.boole;

import jus.aoo.boole.Circuit;
import jus.aoo.boole.Niveau;
import jus.aoo.boole.composant.*;

public class CircuitTestUnitaire {
	
	Circuit c;
	
	public CircuitTestUnitaire($Composant comp){
		$Composant[] tab=new $Composant[comp.nb_entrees()+comp.nb_sorties()+1];
		int i;
		tab[comp.nb_entrees()+comp.nb_sorties()]=comp;
		for(i=0;i<comp.nb_entrees();i++){
			tab[i]=new Itr();
			c.connexion(i, 0, comp.nb_entrees()+comp.nb_sorties(), i);
		}
		for(i=comp.nb_entrees();i<(comp.nb_entrees()+comp.nb_sorties());i++){
			tab[i]=new Led();
			c.connexion(comp.nb_entrees()+comp.nb_sorties(), i, comp.nb_entrees()+i, 0);
		}
	}
	
}
