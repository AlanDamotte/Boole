package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

public class Generateur_Composite extends $Composite {

	protected Port sor_tab[];
	protected Port ent_tab[];	

	
	public Generateur_Composite(){
			super();
	}
	
	public Generateur_Composite(String nom){
		super(nom);
	}
	
	public Generateur_Composite (String nom, Port sor_tab[]){
		super(nom,sor_tab,new Port[0]);
		this.sor_tab=sor_tab;
	}

	
	
}
