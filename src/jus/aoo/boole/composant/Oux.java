package jus.aoo.boole.composant;


import jus.aoo.boole.Niveau;
import jus.aoo.boole.port.*;

public class Oux extends $Transformateur{
	public Oux(){
		super("Oux",new Port[1],new Port[2]);
	}
	
	//Applique l'opération Oux sur les entrées et la place sur la sortie
	public void operer(){
		if(this.ent_valide()){
			if((ent_tab[0].get_etat()==Niveau.Haut) ^ (ent_tab[1].get_etat()==Niveau.Haut)){
				sor_tab[0].set_etat(Niveau.Haut);
			}
			else{
				sor_tab[0].set_etat(Niveau.Bas);
			}
		}
	}
}
