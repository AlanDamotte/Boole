package jus.aoo.boole.composant;

import java.util.LinkedList;
import java.util.List;

import jus.aoo.boole.port.*;

public class Generateur_Composite extends $Composite {
	protected List<Port> sor_list = new LinkedList<Port>();
	protected List<Port> ent_list = new LinkedList<Port>();	
	
	public Generateur_Composite(){
			super();
	}
	
	public Generateur_Composite(String nom){
		super(nom);
	}
	
	public Generateur_Composite (String nom, int nb_sorties, int nb_entrees, List<Port> sor_list, List<Port> ent_list){
		super(nom,nb_sorties,nb_entrees);
		this.sor_list=sor_list;
		this.ent_list=ent_list;
	}
	
	public List<Port> sor_list(){
		return new LinkedList<Port>(sor_list);
	}
	
	public List<Port> ent_list(){
		return new LinkedList<Port>(ent_list);
	}
	
	
}
