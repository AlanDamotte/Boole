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
		this.sor_tab[0].set_etat(Niveau.Aucun);
	}
	public $Composant ($Composant comp){
		this.nom = comp.nom();
		this.sor_tab = comp.sor_tab();
		this.ent_tab = comp.ent_tab();
	}
	
	public $Composant clone(){
		return ($Composant)clone();
	}
	/*public int num_composant(){
		//num_composant est un integer, ainsi num_composant ne sera pas modifiable en donnant sa valeur telle quelle
		return num_composant;
	}*/
	
	public int nb_entrees(){
		return ent_tab.length;
	}
	
	public int nb_sorties(){
		return sor_tab.length;
	}
	
	public String nom(){
		return new String(nom);
	}
	
	//La méthode operer ne sera implémentée réellement que dans les niveaux plus bas
	
	public Port[] sor_tab(){
		Port[] res; 
		res=sor_tab.clone(); 
		return res;
	}

	public Port[] ent_tab(){
		Port[] res; 
		res=ent_tab.clone(); 
		return res;
	}
	
	public boolean ports_entree_actifs(){
		int i=0;
		boolean b =true;
		while((i<this.ent_tab.length) && b){
			if(this.ent_tab[i].get_etat() == Niveau.Aucun){
				b =false;
			}
			i++;
		}
		/*
		 //Pourquoi vérifier les sorties?
		i=0;
		while((i<this.sor_tab.length) && b){
			if(this.sor_tab[i].get_etat() == Niveau.Aucun){
				b =false;
			}
			i++;
		}
		*/
		return b;
	}
	
	public void set_port(boolean entsor, int num_port, Niveau n){
		if(entsor){
			this.sor_tab[num_port].set_etat(n);
		}
		else{
			this.ent_tab[num_port].set_etat(n);
		}
	}
	
}