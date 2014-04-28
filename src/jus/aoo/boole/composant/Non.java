package jus.aoo.boole.composant;
import jus.aoo.boole.port.*;

public class Non extends Transformateur{
	public Non(){
		super("Ou",new Sortie[1],new Entree[2]);
	}
	
	//Operer
	//sortie.set_etat(!entree.get_etat());
}
