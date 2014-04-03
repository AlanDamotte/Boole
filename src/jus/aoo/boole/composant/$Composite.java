package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;
import jus.aoo.boole.*;

import java.util.*;

public abstract class $Composite extends Circuit implements _Composant {
	protected int num_composant;
	protected List<$Port> portlist = new LinkedList<$Port>();
	protected String nom;
	//Cas des composants compoosites
	protected List<$Composant> comp_liste = new LinkedList<$Composant>();
	
	private class Comp extends $Composant{

		public Comp (String nom, int num_composant, List<$Port> liste_ports){
			super.num_composant=num_composant;
			super.portlist=new  LinkedList<$Port>(liste_ports);
			super.nom=nom;
		}
	}
	
	public int num_composant(){
		//num_composant est un integer, ainsi num_composant ne sera pas modifiable en donnant sa valeur telle quelle
		return num_composant;
	}
}