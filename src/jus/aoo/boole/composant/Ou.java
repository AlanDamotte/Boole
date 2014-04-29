package jus.aoo.boole.composant;

import jus.aoo.boole.Niveau;
import jus.aoo.boole.port.*;

public class Ou extends $Transformateur{
	public Ou(){
		super("Ou",new Port[1],new Port[2]);
	}
	
	//Operer
	//sortie.set_etat(ent1.get_etat() || ent2.get_etat());
	
	public void operer(){
		if((ent_tab[0].get_etat()==Niveau.Bas) || (ent_tab[1].get_etat()==Niveau.Bas)){
			sor_tab[0].set_etat(Niveau.Bas);
		}
		else{
			sor_tab[0].set_etat(Niveau.Haut);
		}
	}
}
