package jus.aoo.boole.composant;


import jus.aoo.boole.port.*;
import jus.aoo.boole.*;

public class Gnd extends $Generateur{
	public Gnd(){
		super("Gnd",new Sortie[1]);
	}
	
	//sortie.set_etat(false);
	public void operer(){
		sor_tab[0].set_etat(Niveau.Bas);
	}
}
