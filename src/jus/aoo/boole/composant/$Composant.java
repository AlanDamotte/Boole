package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;
import jus.aoo.boole.Niveau;


public abstract class $Composant implements _Composant{
	
	//Num composant est initialisé dans circuit
	
	//protected int num_composant;
	//Les listes d'entrées/sorties sont à définir dans les classes en dessous, générateurs & co
	//protected List<Entree> ent_list = new LinkedList<Entree>();
	//protected List<Sortie> sor_list = new LinkedList<Sortie>();	
	protected String nom;
	//La liste des sorties et des entrées est utile pour accéder aux états de chacun d'entre eux
	//Faire des tableaux pour les entrées et sorties
	//Les constructeurs définiront ces tableaux en allouant les tableaux en fonction du nombre de cases
	protected Port sor_tab[];
	protected Port ent_tab[];	
	//Infos complémentaires: quel attribut mettre ?
	
	protected $Composant (){
		
	}

	public $Composant (String nom, Port sor_tab[], Port ent_tab[]){
		//this.num_composant=num_composant;
		this.nom=nom;
		this.sor_tab=sor_tab;
		this.ent_tab=ent_tab;
		int i;
		for(i=0;i<ent_tab.length;i++){
			ent_tab[i]=new Port();
		}
		for(i=0;i<sor_tab.length;i++){
			sor_tab[i]=new Port();
		}
	}
	
	//ATTENTION: Ce clone n'est pas une copie mais l'original, étant donné qu'il était difficile de l'implémenter autrement
	@Override
	public $Composant clone() {
		return this;
	}
	/*public int num_composant(){
		//num_composant est un integer, ainsi num_composant ne sera pas modifiable en donnant sa valeur telle quelle
		return num_composant;
	}*/
	
	//Renvoie le nombre d'entrées du composant
	public int nb_entrees(){
		return ent_tab.length;
	}
	
	//Renvoie le nombre de sorties du composant
	public int nb_sorties(){
		return sor_tab.length;
	}
	
	//Renvoie le nom du composant
	public String nom(){
		return new String(nom);
	}
	
	//La méthode operer ne sera implémentée réellement que dans les niveaux plus bas
	
	//Accesseur à une copie du tableau des ports de sortie
	public Port[] sor_tab(){
		Port[] res; 
		res=sor_tab.clone(); 
		return res;
	}

	//Accesseur à une copie du tableau des ports d'entrée
	public Port[] ent_tab(){
		Port[] res; 
		res=ent_tab.clone(); 
		return res;
	}
	
	//Place le niveau du port d'entrée spécifié à n
	public void set_port(boolean entsor, int num_port, Niveau n){
		if(entsor){
			this.ent_tab[num_port].set_etat(n);
		}
		else{
			this.sor_tab[num_port].set_etat(n);
		}
	}
	
	//Place tous les ports d'entrée au niveau Aucun
	public void raz(){
		int i;
		for(i=0;i<this.nb_entrees();i++){
			set_port(true,i,Niveau.Aucun);
		}
	}
	
	//Renvoie le nom du composant et son nombre d'entrées et de sorties
	@Override
	public String toString(){
		return this.nom+"("+this.ent_tab().length+","+this.sor_tab().length+")";
	}
	
}