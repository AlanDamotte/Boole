package jus.aoo.boole.composant;

import jus.aoo.boole.*;
import jus.aoo.boole.port.*;


public class Et extends $Transformateur {
	public Et(){
		super("Et",new Port[1],new Port[2]);
	}
	
	//Renvoie le résultat de l'opération Et sur les entrées à la sortie
	public void operer(){
		if(this.ent_valide()){
			if((ent_tab[0].get_etat()==Niveau.Haut) && (ent_tab[1].get_etat()==Niveau.Haut)){
				sor_tab[0].set_etat(Niveau.Haut);
			}
			else{
				sor_tab[0].set_etat(Niveau.Bas);
			}
		}
	}
}
