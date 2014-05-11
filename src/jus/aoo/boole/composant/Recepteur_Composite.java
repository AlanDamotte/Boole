package jus.aoo.boole.composant;


import jus.aoo.boole.*;
import jus.aoo.boole.port.Port;

public class Recepteur_Composite extends $Composite{
	
	protected Port sor_tab[];
	protected Port ent_tab[];	

	
	public Recepteur_Composite(){
			super();
	}
	
	public Recepteur_Composite(String nom){
		super(nom);
	}
	

	public Recepteur_Composite(String nom, int e, Circuit cir){
		super(nom,0,e,cir);
	}
	
	
}
