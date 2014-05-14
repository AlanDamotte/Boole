package jus.aoo.boole.composant;

import jus.aoo.boole.Circuit;

public class Oux_composite extends $Composite{
	public Oux_composite(){

		super("Oux",1, 2);
		$Composant[] composants = new $Composant[5];
		composants[0]= new Non();
		composants[1]= new Non();
		composants[2]= new Et();
		composants[3]= new Et();
		composants[4]= new Ou();
		Circuit cir = new Circuit("Oux", composants);
		cir.connexion(0, 0, 2, 0);
		cir.connexion(1, 0,3, 0);
		cir.connexion(2, 0, 4, 0);
		cir.connexion(3, 0, 4, 1);
		super.tab_composants=cir.get_tab_comp();
		this.connexion_entree_interface(0, 2, 1);
		this.connexion_entree_interface(0, 1, 0);
		this.connexion_entree_interface(1, 0, 1);
		this.connexion_entree_interface(1, 3, 0);
		this.connexion_sortie_interface(0, 4, 0);
	}

}
