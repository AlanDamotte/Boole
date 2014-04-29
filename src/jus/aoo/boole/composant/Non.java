package jus.aoo.boole.composant;
import jus.aoo.boole.Niveau;
import jus.aoo.boole.port.*;

public class Non extends $Transformateur{
	public Non(){
		super("Ou",new Sortie[1],new Entree[1]);
	}
	
	//Operer
	//sortie.set_etat(!entree.get_etat());
	
	public void operer(){
		if(ent_tab[0].get_etat()==Niveau.Haut){
			sor_tab[0].set_etat(Niveau.Bas);
		}
		else{
			sor_tab[0].set_etat(Niveau.Haut);
		}
	}
}
