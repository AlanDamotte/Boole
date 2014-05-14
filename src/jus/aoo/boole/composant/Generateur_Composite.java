package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

//Code non fonctionnel

public class Generateur_Composite extends $Composite {

	protected Port sor_tab[];
	protected Port ent_tab[];	

	
	public Generateur_Composite(){
			super();
	}
	
	public Generateur_Composite(String nom){
		super(nom);
	}
	
	public Generateur_Composite (String nom, int sortie){
		super(nom,sortie,0);
	}

	
	
}
