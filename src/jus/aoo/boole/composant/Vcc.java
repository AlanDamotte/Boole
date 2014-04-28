package jus.aoo.boole.composant;


import jus.aoo.boole.port.Sortie;

public class Vcc extends Generateur{
	public Vcc(){
		//La liste de sorties doit etre l'allocation du tableau
		super("Vcc",new Sortie[1]);
	}

	//Operer
	//sortie.set_etat(true);
}
