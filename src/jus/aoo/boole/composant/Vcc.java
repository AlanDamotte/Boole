package jus.aoo.boole.composant;


import jus.aoo.boole.Niveau;
import jus.aoo.boole.port.Sortie;

public class Vcc extends $Generateur{
	public Vcc(){
		//La liste de sorties doit etre l'allocation du tableau
		super("Vcc",new Sortie[1]);
	}

	//Operer
	//sortie.set_etat(true);
	
	public void operer(){
			sor_tab[0].set_etat(Niveau.Haut);
	}
}
