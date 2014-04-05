package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

import java.util.LinkedList;
import java.util.List;


public class Recepteur extends $Composant {
	protected List<Entree> ent_list = new LinkedList<Entree>();	
	
	public Recepteur (String nom, int num_composant, int nb_entrees, List<Entree> ent_list){
		super(nom,num_composant,0,nb_entrees);
		this.ent_list=ent_list;
	}
	
	public List<Entree> ent_list(){
		return new LinkedList<Entree>(ent_list);
	}
}