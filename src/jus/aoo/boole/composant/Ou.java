package jus.aoo.boole.composant;
import java.util.LinkedList;

import jus.aoo.boole.port.*;

public class Ou extends Transformateur{
	public Ou(Sortie sortie, Entree ent1, Entree ent2){
		super("Ou",1,2,new LinkedList<Sortie>(),new LinkedList<Entree>());
	}
	
	//Operer
	//sortie.set_etat(ent1.get_etat() || ent2.get_etat());
}
