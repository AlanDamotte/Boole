package jus.aoo.boole.composant;
import jus.aoo.boole.port.*;

public class Non extends Transformateur{
	boolean boole_non(Entree entree){
		return ( ! entree.get_etat());
	}
}
