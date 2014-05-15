package jus.aoo.boole.composant;
import jus.aoo.boole.Niveau;
import jus.aoo.boole.port.*;

public class Non extends $Transformateur{
	public Non(){
		super("Non",new Port[1],new Port[1]);
	}
	
	//Place l'opposé de l'entrée en sortie
	public void operer(){
		if(this.ent_valide()){
			if(ent_tab[0].get_etat()==Niveau.Haut){
				sor_tab[0].set_etat(Niveau.Bas);
			}
			else{
				sor_tab[0].set_etat(Niveau.Haut);
			}
		}
	}
}
