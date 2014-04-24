package jus.aoo.boole.port;

import jus.aoo.boole.*;

public abstract class $Port {
	protected Niveau etat;
	//Intéret identifiant?
	//protected int identifiant;
	
	public Niveau get_etat(){
		return this.etat;
	}
	
	public void set_etat(Niveau b){
		this.etat=b;
	}
}
