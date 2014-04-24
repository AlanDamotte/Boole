package jus.aoo.boole.composant;

import java.util.LinkedList;



import jus.aoo.boole.port.Sortie;
import jus.aoo.boole.*;

public class Itr extends Generateur{
	public Itr(){
		super("Itr",1,new LinkedList<Sortie>());
	}
	
	//Operer (niveau ne doit etre utilisé que dans circuit, mais le principe est en dessous)
	//if(niveau==Niveau.Haut){sortie.set_etat(true);}
	//else if(niveau==Niveau.Bas){sortie.set_etat(false);}
	//else {throw new Exception("Niveau incorrect");}
}
