package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

import java.util.LinkedList;
import java.util.List;


//Penser à faire binaire et unaire, ensuite operer sera la seule méthode dans et, ou,..


public class Transformateur extends $Composant {
	
	public Transformateur(){
			super();
	}
	
	public Transformateur (String nom, int nb_sorties, int nb_entrees, List<Sortie> sor_list, List<Entree> ent_list){
		super(nom,nb_sorties,nb_entrees, sor_list, ent_list);
	}
	
	public List<Sortie> sor_list(){
		return new LinkedList<Sortie>(sor_list);
	}
	
	public List<Entree> ent_list(){
		return new LinkedList<Entree>(ent_list);
	}
	
	public void operer(){
		super.operer();
	}
}
