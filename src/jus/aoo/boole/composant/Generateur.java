package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

import java.util.LinkedList;
import java.util.List;


public class Generateur extends $Composant {
	protected List<Sortie> sor_list = new LinkedList<Sortie>();	
	
	public Generateur (String nom, int num_composant, int nb_sorties, List<Sortie> sor_list){
		super(nom,num_composant,nb_sorties,0);
		this.sor_list=sor_list;
	}
	
	public List<Sortie> sor_list(){
		return new LinkedList<Sortie>(sor_list);
	}
}
