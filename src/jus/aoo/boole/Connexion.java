package jus.aoo.boole;

import java.util.List;
import java.util.LinkedList;

public class Connexion {
	
	//Connexion simple representant la connexion entre la sortie et une
	//entree definie par son numero de composant et son numero d'entree
	protected class Connexion_simple{
		private int composant;
		private int entree; 
		
		public int getEntree(){
			return entree;
		}
		
		public int getComp(){
			return composant;
		}
		
		public void set(int composant, int entree){
			this.composant=composant;
			this.entree=entree;
		}
		
		public Connexion_simple(int composant, int entree){
			this.composant=composant;
			this.entree=entree;
		}
		
		//Redefinition de equals afin de simplifier les operations sur les listes par la suite
		@Override
		public boolean equals(Object co){
			if (co instanceof Connexion_simple){
				return ( ((Connexion_simple)co).getComp()==this.getComp() && ((Connexion_simple)co).getEntree()==this.getEntree() );
			}
			else{
				return false;
			}
		}
	}
	
	//Attribut definissant la liste des connexions associees a une sortie
	protected List<Connexion_simple> connexions;
	
	//Constructeur de base
	public Connexion(){
		connexions= new LinkedList<Connexion_simple>();
	}
	
	//Ajout d'une connexion sur la sortie
	public void add(int composant, int entree){
		Connexion_simple co=new Connexion_simple(composant,entree);
		if(!this.connexions.contains(co)){
			this.connexions.add(co);
		}
	}
	
	//Retrait d'une connexion sur la sortie
	public void remove(int composant, int entree){
		Connexion_simple co=new Connexion_simple(composant,entree);
		this.connexions.remove(co);
	}
	
}
