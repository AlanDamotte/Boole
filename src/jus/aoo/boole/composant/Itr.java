package jus.aoo.boole.composant;

import jus.aoo.boole.port.Port;
import jus.aoo.boole.*;

public class Itr extends $Generateur{
	public Itr(){
		super("Itr",new Port[1]);
	}
	
	//Operer (niveau ne doit etre utilisé que dans circuit, mais le principe est en dessous)
	//if(niveau==Niveau.Haut){sortie.set_etat(true);}
	//else if(niveau==Niveau.Bas){sortie.set_etat(false);}
	//else {throw new Exception("Niveau incorrect");}
	
	// A COMPLETER
	public void operer(){
		if(this.sor_tab[0].get_etat()==Niveau.Haut){
			this.sor_tab[0].set_etat(Niveau.Bas);
		}
		else{
			this.sor_tab[0].set_etat(Niveau.Haut);
		}
	}
}
