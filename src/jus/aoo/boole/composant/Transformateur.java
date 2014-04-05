package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

import java.util.LinkedList;
import java.util.List;


public class Transformateur extends $Composant {
	protected List<Sortie> sor_list = new LinkedList<Sortie>();
	protected List<Entree> ent_list = new LinkedList<Entree>();	
	
	public Transformateur (String nom, int num_composant, int nb_sorties, int nb_entrees, List<Sortie> sor_list, List<Entree> ent_list){
		super(nom,num_composant,nb_sorties,nb_entrees);
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
