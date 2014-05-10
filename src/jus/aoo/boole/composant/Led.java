package jus.aoo.boole.composant;

import jus.aoo.boole.NiveauVisuel;
import jus.aoo.boole.Niveau;
import jus.aoo.boole.port.Port;

public class Led extends $Recepteur{
	
	private NiveauVisuel ampoule;
	
	public Led(){
		super("Led",new Port[1]);
		this.ampoule=NiveauVisuel.Eteint;
	}
	
	public NiveauVisuel get(){
		return this.ampoule;
	}
	
	@Override
	public String toString(){
		return super.toString()+"{"+ampoule.toString()+"}";
	}
	
	public void operer(){
		if(ent_tab[0].get_etat()==Niveau.Haut){
			this.ampoule=NiveauVisuel.Allume;
		}
		else{
			if(ent_tab[0].get_etat()==Niveau.Bas){
				this.ampoule=NiveauVisuel.Eteint;
			}
		}
	}
	
}