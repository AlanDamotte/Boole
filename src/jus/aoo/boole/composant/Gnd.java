package jus.aoo.boole.composant;

import java.util.LinkedList;

import jus.aoo.boole.port.Sortie;

public class Gnd extends Generateur{
	public Gnd(){
		super("Gnd",1,new LinkedList<Sortie>());
	}
	
	//Operer
	//sortie.set_etat(false);
}
