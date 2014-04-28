package jus.aoo.boole.composant;

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
	protected Sortie sor_tab[];
	protected Entree ent_tab[];	
	//Infos complémentaires: quel attribut mettre ?
	
	protected $Composant (){
		
	}

	public $Composant (String nom, Sortie sor_tab[], Entree ent_tab[]){
		//this.num_composant=num_composant;
		this.nom=nom;
		this.nb_sorties=sor_tab.length;
		this.nb_entrees=ent_tab.length;
		this.sor_tab=sor_tab;
		this.ent_tab=ent_tab;
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
	
	//La méthode operer ne sera implémentée réellement que dans les niveaux plus bas
	public void operer(){
		
	}
}