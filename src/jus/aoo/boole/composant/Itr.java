package jus.aoo.boole.composant;

import jus.aoo.boole.port.Sortie;
import jus.aoo.boole.*;

public class Itr extends Generateur{
	public Itr(){
		super("Itr",new Sortie[1]);
	}
	
	//Operer (niveau ne doit etre utilisé que dans circuit, mais le principe est en dessous)
	//if(niveau==Niveau.Haut){sortie.set_etat(true);}
	//else if(niveau==Niveau.Bas){sortie.set_etat(false);}
	//else {throw new Exception("Niveau incorrect");}
}
