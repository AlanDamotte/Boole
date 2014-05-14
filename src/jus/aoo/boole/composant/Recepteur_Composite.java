package jus.aoo.boole.composant;


import jus.aoo.boole.port.Port;

//Code non fonctionnel

public class Recepteur_Composite extends $Composite{
	
	protected Port sor_tab[];
	protected Port ent_tab[];	

	
	public Recepteur_Composite(){
			super();
	}
	
	public Recepteur_Composite(String nom){
		super(nom);
	}
	

	public Recepteur_Composite(String nom, int entree){
		super(nom,0,entree);
	}
	
	
}
