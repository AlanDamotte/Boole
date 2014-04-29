package jus.aoo.boole.composant;

import jus.aoo.boole.NiveauVisuel;
import jus.aoo.boole.Niveau;
import jus.aoo.boole.port.Port;

public class Led extends $Recepteur{
	
	//Niveau n'a pas sa place ici
	private NiveauVisuel ampoule;
	
	public Led(){
		super("Led",new Port[1]);
	}
	
	/*public Niveau get_niveau(){
		return new Niveau(niveau);
	}*/
	
	//Operer
	//if(entree.get_etat()){this.niveau=Niveau.Allume;}
	//else{this.niveau=Niveau.Eteint;}
	//super.ent_list.add(entree);
	
	// A MODIFIER
	public void operer(){
		if(ent_tab[0].get_etat()==Niveau.Haut){
			this.ampoule=NiveauVisuel.Allume;
		}
		else{
			this.ampoule=NiveauVisuel.Eteint;
		}
	}
	
}