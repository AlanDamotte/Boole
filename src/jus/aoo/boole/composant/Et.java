package jus.aoo.boole.composant;
import jus.aoo.boole.port.*;

public class Et extends Transformateur {
//	public Et(int numcomposant,){
//		super("Et",numcomposant,1,2,);
//	}
	 boolean boole_et(Entree entree1, Entree entree2){
		return (entree1.get_etat() && entree2.get_etat());
	}
}
