package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;
import jus.aoo.boole.*;


//PAS ENCORE FONCTIONNEL

public abstract class $Composite extends Circuit implements _Operer {
	
	/**Operer sera décidé lors de circuit, et il sera appelé lors de composite
	*/
	
	//La liste des composants est apportée par circuit
	protected Comp comp;
	
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
	
	public $Composite(String nom){
		this.comp=new Comp(nom);
	}
	public $Composite(String nom, int s, int e,Circuit cir){
		this.comp=new Comp(nom,s,e);
		super.nom=cir.nom();
		super.tab_composants=cir.get_tab_comp();
	}
	//Infos complémentaires: quel attribut mettre ?
	
}