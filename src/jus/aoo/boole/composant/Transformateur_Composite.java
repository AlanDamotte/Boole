package jus.aoo.boole.composant;

import java.util.LinkedList;
import java.util.List;

import jus.aoo.boole.port.Port;

public class Transformateur_Composite extends $Composite {
	protected List<Port> sor_list = new LinkedList<Port>();
	protected List<Port> ent_list = new LinkedList<Port>();	
	
	public Transformateur_Composite(){
			super();
	}
	
	public Transformateur_Composite(String nom){
		super(nom);
	}
	
	public Transformateur_Composite (String nom, Port sor_tab[], Port ent_tab[], List<Port> sor_list, List<Port> ent_list){
		super(nom,sor_tab, ent_tab);
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
