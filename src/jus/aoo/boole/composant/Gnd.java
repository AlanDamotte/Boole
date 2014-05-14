package jus.aoo.boole.composant;


import jus.aoo.boole.port.*;
import jus.aoo.boole.*;

public class Gnd extends $Generateur{
	public Gnd(){
		super("Gnd",new Port[1]);
	}
	
	////Place le niveau de sortie à haut
	public void operer(){
		sor_tab[0].set_etat(Niveau.Bas);
	}
}
