package jus.aoo.boole.port;

import jus.aoo.boole.*;

public class Port implements _Port{
	protected Niveau etat;
	//Identifiant correspond au numero associe au port et est défini par l'indice du tableau dans lequel il se trouve
	
	public Port(){
		this.etat=Niveau.Aucun;
	}
	
	//Renvoie l'état du port
	public Niveau get_etat(){
		return this.etat;
	}
	
	//Modifie l'état du port
	public void set_etat(Niveau b){
		this.etat=b;
	}
	
	//Renvoie une copie du port
	public Port get(){
		Port res=new Port();
		res.set_etat(this.get_etat());
		return res;
	}
}
