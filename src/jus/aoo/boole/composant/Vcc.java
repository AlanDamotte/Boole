package jus.aoo.boole.composant;


import jus.aoo.boole.Niveau;
import jus.aoo.boole.port.Port;

public class Vcc extends $Generateur{
	public Vcc(){
		//La liste de sorties doit etre l'allocation du tableau
		super("Vcc",new Port[1]);
	}

	//Place le niveau de sortie à haut
	public void operer(){
			sor_tab[0].set_etat(Niveau.Haut);
	}
}
