package jus.aoo.boole.composant;

import java.util.LinkedList;
import java.util.List;

import jus.aoo.boole.port.Entree;
import jus.aoo.boole.port.Sortie;


public abstract class $Composant implements _Composant{
	
	//Num composant est initialisé dans circuit
	
	//protected int num_composant;
	//Les listes d'entrées/sorties sont à définir dans les classes en dessous, générateurs & co
	//protected List<Entree> ent_list = new LinkedList<Entree>();
	//protected List<Sortie> sor_list = new LinkedList<Sortie>();	
	protected String nom;
	protected int nb_sorties;
	protected int nb_entrees;
	//La liste des sorties et des entrées est utile pour accéder aux états de chacun d'entre eux
	//Faire des tableaux pour les entrées et sorties
	//Les constructeurs définiront ces tableaux en allouant les tableaux en fonction du nombre de cases
	protected List<Sortie> sor_list = new LinkedList<Sortie>();
	protected List<Entree> ent_list = new LinkedList<Entree>();	
	//Infos complémentaires: quel attribut mettre ?
	
	protected $Composant (){
		
	}

	public $Composant (String nom, int nb_sorties, int nb_entrees, List<Sortie> sor_list, List<Entree> ent_list){
		//this.num_composant=num_composant;
		this.nom=nom;
		this.nb_sorties=nb_sorties;
		this.nb_entrees=nb_entrees;
		this.sor_list=sor_list;
		this.ent_list=ent_list;
	}
	
	/*public int num_composant(){
		//num_composant est un integer, ainsi num_composant ne sera pas modifiable en donnant sa valeur telle quelle
		return num_composant;
	}*/
	
	public int nb_entrees(){
		return nb_entrees;
	}
	
	public int nb_sorties(){
		return nb_sorties;
	}
	
	public String nom(){
		return new String(nom);
	}
	
	//Comment l'implémenter?
	public void operer(){
		
	}
}