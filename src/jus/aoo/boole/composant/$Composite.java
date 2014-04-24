package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;
import jus.aoo.boole.*;

import java.util.*;



//Classe inutilisable: besoin de comprendre le principe des "connexions d'interface en entrée", etc.. de la figure 5 avant d'entamer cette classe
public abstract class $Composite extends Circuit implements _Composant {
	protected int num_composant;
	protected String nom;
	
	/**Operer sera décidé lors de circuit, et il sera appelé lors de composite
	 */
	
	//La liste des composants est apportée par circuit
	//protected List<$Composant> comp_liste = new LinkedList<$Composant>();
	
	private class Comp extends $Composant{

		public Comp (String nom){
			//num_composant décidé dans circuit
			//super.num_composant=num_composant;
			super.nom=nom;
		}
	}
	
	public int num_composant(){
		//num_composant est un integern ainsi num_composant ne sera pas modifiable en donnant sa valeur telle quelle
		return num_composant;
	}
}