package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//Cette classe représente les composants sans entrée
//Elle implémente Iterable<Void> afin de réaliser de manière plus générique le test de CircuitTestUnitaire
public abstract class $Generateur extends $Composant implements Iterable<Void>{
	
	public Iterator<Void> iterator(){
	    List<Void> l = new LinkedList<Void>();
	    l.add(null);
		return l.iterator();
	}
	
	public $Generateur(){
		super();
	}
	
	public $Generateur (String nom, Port sor_tab[]){
		super(nom,sor_tab,new Port[0]);
		this.sor_tab=sor_tab;
	}
}