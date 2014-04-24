package jus.aoo.boole.composant;

import java.util.LinkedList;

import jus.aoo.boole.port.Sortie;

public class Vcc extends Generateur{
	public Vcc(){
		//La liste de sorties doit etre l'allocation du tableau
		super("Vcc",1,new LinkedList<Sortie>());
	}

	//Operer
	//sortie.set_etat(true);
}
