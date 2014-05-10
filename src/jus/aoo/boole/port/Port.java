package jus.aoo.boole.port;

import jus.aoo.boole.*;

public class Port {
	protected Niveau etat;
	//Identifiant correspond au numero associe au port et est défini par l'indice du tableau dans lequel il se trouve
	
	public Port(){
		this.etat=Niveau.Aucun;
	}
	
	public Niveau get_etat(){
		return this.etat;
	}
	
	public void set_etat(Niveau b){
		this.etat=b;
	}
	
	public Port get(){
		Port res=new Port();
		res.set_etat(this.get_etat());
		return res;
	}
}
