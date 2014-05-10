package jus.aoo.boole.composant;

import jus.aoo.boole.port.Port;

public class Transformateur_Composite extends $Composite {

	protected Port sor_tab[];
	protected Port ent_tab[];	

	
	public Transformateur_Composite(){
			super();
	}
	
	public Transformateur_Composite(String nom){
		super(nom);
	}
	

	public Transformateur_Composite (String nom, Port sor_tab[], Port ent_tab[]){
		super(nom,sor_tab,ent_tab);
		this.sor_tab=sor_tab;
		this.ent_tab=ent_tab;
	}


}
