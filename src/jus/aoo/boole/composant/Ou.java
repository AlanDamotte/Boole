package jus.aoo.boole.composant;
import jus.aoo.boole.port.*;

public class Ou extends Transformateur{
	boolean boole_ou(Entree entree1, Entree entree2){
		return (entree1.get_etat() || entree2.get_etat());
	}
}
