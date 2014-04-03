package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;

import java.util.*;

public abstract class $Composant implements _Composant{
	protected int num_composant;
	protected List<$Port> portlist = new LinkedList<$Port>();
	protected String nom;
	
	public $Composant (){
		this.num_composant=-1;
		this.nom="";
	}
	
	public $Composant (String nom, int num_composant, List<$Port> liste_ports){
		this.num_composant=num_composant;
		this.portlist=new  LinkedList<$Port>(liste_ports);
		this.nom=nom;
	}
	
	public int num_composant(){
		//num_composant est un integer, ainsi num_composant ne sera pas modifiable en donnant sa valeur telle quelle
		return num_composant;
	}
}