package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;
import jus.aoo.boole.*;


//PAS ENCORE FONCTIONNEL

public abstract class $Composite extends Circuit implements _Operer {
	
	/**Operer sera décidé lors de circuit, et il sera appelé lors de composite
	*/
	
	//La liste des composants est apportée par circuit
	protected Comp comp;
	private Connexion connexions_entree_interface[];
	//Ci dessous: voir si Comp doit etre une abstract class ou si operer est defini a l'interieur
	private class Comp extends $Composant{

		public Comp (String nom){
			super.nom=nom;
		}
		public Comp (String nom,int s, int e){
			super(nom,new Port[s],new Port[e]);
		}
		
		//Cette méthode ne contient rien puisqu'operer n'est pas à utiliser ici. Operer sera réalisé tout de même, mais pas dans cette classe.
		public void operer(){}
	}
	
	//HERITAGE CONNEXION

	public $Composite(){
		
	}
	
	public int nb_sorties(){
		return comp.nb_sorties();
	}

	public int nb_entrees(){
		return comp.nb_entrees();
	}
	
	public $Composite(String nom){
		this.comp=new Comp(nom);
	}

	public $Composite(String nom,int sorties, int entree){
		this.comp=new Comp(nom,sorties,entree);
		super.nom=nom;
		this.connexions_entree_interface = new Connexion[entree];
	}
	
	public void connexion_entree_interface(int entree_interface, int comp_entree, int num_entree){
		this.connexions_entree_interface[entree_interface].add(comp_entree, num_entree);
	}
	public void connexion_sortie_interface(  int sortie_interface, int comp_sortie,int num_sortie){
		if(super.tab_composants[comp_sortie] instanceof composite_circuit){
			((composite_circuit)super.tab_composants[comp_sortie]).add_interface(num_sortie, sortie_interface);
		}
	}
	//Infos complémentaires: quel attribut mettre ?
	
}