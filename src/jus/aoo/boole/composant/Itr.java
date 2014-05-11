package jus.aoo.boole.composant;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import jus.aoo.boole.port.Port;
import jus.aoo.boole.*;

public class Itr extends $Generateur{
	
	private Niveau etat;
	
	public Itr(){
		super("Itr",new Port[1]);
		this.etat=Niveau.Bas;
	}
	
	//Dans le cas des interrupteurs, on a 2 éléments dans l'Itereable
	@Override
	public Iterator<Void> iterator(){
	    List<Void> l = new LinkedList<Void>();
	    l.add(null);
	    l.add(null);
		return l.iterator();
	}
	
	@Override
	public String toString(){
		return super.toString()+"{"+this.sor_tab[0].get_etat().toString()+"}";
	}
	
	public void modifier_etat(Niveau n){
		this.etat=n;
	}
	
	public void modifier_etat(){
		if (this.etat==Niveau.Haut){
			this.etat=Niveau.Bas;
		}
		else{this.etat=Niveau.Haut;}
	}
	
	//Operer (niveau ne doit etre utilisé que dans circuit, mais le principe est en dessous)
	//if(niveau==Niveau.Haut){sortie.set_etat(true);}
	//else if(niveau==Niveau.Bas){sortie.set_etat(false);}
	//else {throw new Exception("Niveau incorrect");}
	
	// A COMPLETER
	public void operer(){
		this.sor_tab[0].set_etat(etat);
	}
}
