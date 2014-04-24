package jus.aoo.boole.composant;
import java.util.LinkedList;

import jus.aoo.boole.port.*;

public class Non extends Transformateur{
	public Non(){
		super("Ou",1,2,new LinkedList<Sortie>(),new LinkedList<Entree>());
	}
	
	//Operer
	//sortie.set_etat(!entree.get_etat());
}
