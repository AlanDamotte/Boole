package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;
import jus.aoo.boole.*;

import java.util.*;

//Num composant n'a pas sa place dans $Composant, dans $Composite non plus

//Classe inutilisable: besoin de comprendre le principe des "connexions d'interface en entrée", etc.. de la figure 5 avant d'entamer cette classe
public abstract class $Composite extends Circuit implements _Composant {
	
	/**Operer sera décidé lors de circuit, et il sera appelé lors de composite
	*/
	
	//La liste des composants est apportée par circuit
	protected List<$Composant> comp_liste = new LinkedList<$Composant>();
	private Comp comp;
	//Les listes d'entrées/sorties sont à définir dans les classes en dessous, générateurs & co
	//protected List<Entree> ent_list = new LinkedList<Entree>();
	//protected List<Sortie> sor_list = new LinkedList<Sortie>();	
	
	//Ci dessous: voir si Comp doit etre une abstract class ou si operer est defini a l'interieur
	private class Comp extends $Composant{

		public Comp (String nom){
			super.nom=nom;
		}
		public Comp (String nom, int nb_entrees, int nb_sorties){
			super.nom=nom;
			super.nb_entrees=nb_entrees;
			super.nb_sorties=nb_sorties;
		}
		
	}
	

	public $Composite(){
		
	}
	
	public $Composite(String nom){
		this.comp=new Comp(nom);
	}
	public $Composite(String nom, int nb_entrees, int nb_sorties){
		this.comp=new Comp(nom,nb_entrees, nb_sorties);
	}
	//Infos complémentaires: quel attribut mettre ?
	
}