package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;
import java.util.*;

public abstract class $Composant {
	protected int num_composant;
	protected List<$Port> portlist = new LinkedList<$Port>();
	protected String nom;
	//Cas des composants composites
	protected List<$Composant> comp_liste = new LinkedList<$Composant>();
	
	public $Composant (int num_composant, $Port liste_ports){
		
	}
	
	public int num_composant(){
		//num_composant est un integer, ainsi num_composant ne sera pas modifiable en donnant sa valeur telle quelle
		return num_composant;
	}
}