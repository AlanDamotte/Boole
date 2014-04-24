package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

import java.util.LinkedList;
import java.util.List;


public class Generateur extends $Composant {
	
	public Generateur(){
		super();
	}
	
	public Generateur (String nom, int nb_sorties, List<Sortie> sor_list){
		super(nom,nb_sorties,0,sor_list,new LinkedList<Entree>());
		this.sor_list=sor_list;
	}
	
	public List<Sortie> sor_list(){
		return new LinkedList<Sortie>(sor_list);
	}
}
