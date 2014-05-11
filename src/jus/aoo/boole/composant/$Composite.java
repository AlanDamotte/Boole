package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;
import jus.aoo.boole.*;


//Num composant n'a pas sa place dans $Composant, dans $Composite non plus

//Classe inutilisable: besoin de comprendre le principe des "connexions d'interface en entrée", etc.. de la figure 5 avant d'entamer cette classe
public abstract class $Composite extends Circuit implements _Operer {
	
	/**Operer sera décidé lors de circuit, et il sera appelé lors de composite
	*/
	
	//La liste des composants est apportée par circuit
	protected Circuit cir;
	protected Comp comp;
	
	//Ci dessous: voir si Comp doit etre une abstract class ou si operer est defini a l'interieur
	private class Comp extends $Composant{

		public Comp (String nom){
			super.nom=nom;
		}
		public Comp (String nom,int s, int e){
			super(nom,new Port[s],new Port[e]);
		}
		
		public void operer(){}
		
	}
	

	public $Composite(){
		
	}
	
	public $Composite(String nom){
		this.comp=new Comp(nom);
	}
	public $Composite(String nom, int s, int e,Circuit cir){
		this.comp=new Comp(nom,s,e);
		this.cir=cir;
	}
	//Infos complémentaires: quel attribut mettre ?
	
}