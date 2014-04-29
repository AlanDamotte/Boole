package jus.aoo.boole.port;

import jus.aoo.boole.*;

public class Port {
	protected Niveau etat;
	//Identifiant correspond au numero associe au port
	protected int identifiant;
	
	public Niveau get_etat(){
		return this.etat;
	}
	
	public void set_etat(Niveau b){
		this.etat=b;
	}
	
	public int get_id(){
		return this.identifiant;
	}
	
	public void set_id(int b){
		this.identifiant=b;
	}
	
	public Port get(){
		Port res=new Port();
		res.set_id(this.get_id());
		res.set_etat(this.get_etat());
		return res;
	}
}
