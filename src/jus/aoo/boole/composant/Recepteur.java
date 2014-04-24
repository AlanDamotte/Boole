package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

import java.util.LinkedList;
import java.util.List;


public class Recepteur extends $Composant {
	
	public Recepteur(){
		super();
	}
	
	public Recepteur (String nom, int nb_entrees, List<Entree> ent_list){
		super(nom,0,nb_entrees,new LinkedList<Sortie>(),ent_list);
		this.ent_list=ent_list;
	}
	
	public List<Entree> ent_list(){
		return new LinkedList<Entree>(ent_list);
	}
}