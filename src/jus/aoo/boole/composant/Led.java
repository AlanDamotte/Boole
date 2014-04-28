package jus.aoo.boole.composant;

import jus.aoo.boole.Niveau;
import jus.aoo.boole.port.Entree;
import jus.aoo.boole.port.Sortie;

public class Led extends Recepteur{
	
	//Niveau n'a pas sa place ici
	//private Niveau niveau;
	
	public Led(){
		super("Led",new Entree[1]);
	}
	
	/*public Niveau get_niveau(){
		return new Niveau(niveau);
	}*/
	
	//Operer
	//if(entree.get_etat()){this.niveau=Niveau.Allume;}
	//else{this.niveau=Niveau.Eteint;}
	//super.ent_list.add(entree);
	
}