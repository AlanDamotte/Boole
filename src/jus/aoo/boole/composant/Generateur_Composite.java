package jus.aoo.boole.composant;

import java.util.LinkedList;
import java.util.List;

import jus.aoo.boole.port.Entree;
import jus.aoo.boole.port.Sortie;
//PLOP !22
public class Generateur_Composite extends $Composite {
	protected List<Sortie> sor_list = new LinkedList<Sortie>();
	protected List<Entree> ent_list = new LinkedList<Entree>();	
	
	public Generateur_Composite(){
			super();
	}
	
	public Generateur_Composite(String nom){
		super(nom);
	}
	
	public Generateur_Composite (String nom, int nb_sorties, int nb_entrees, List<Sortie> sor_list, List<Entree> ent_list){
		super(nom,nb_sorties,nb_entrees);
		this.sor_list=sor_list;
		this.ent_list=ent_list;
	}
	
	public List<Sortie> sor_list(){
		return new LinkedList<Sortie>(sor_list);
	}
	
	public List<Entree> ent_list(){
		return new LinkedList<Entree>(ent_list);
	}
	
	
}
