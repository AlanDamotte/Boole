package jus.aoo.boole.composant;



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
	

	public Recepteur_Composite(String nom, Port ent_tab[]){
		super(nom,new Port[0],ent_tab);
		this.ent_tab=ent_tab;
	}
	
	
}
