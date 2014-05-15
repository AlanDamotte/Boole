package jus.aoo.boole;

import java.util.List;
import java.util.LinkedList;

public class Connexion {
	
	//Connexion simple representant la connexion entre la sortie et une
	//entree definie par son numero de composant et son numero d'entree
	public class Connexion_simple{
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
		
		public Connexion_simple(Connexion_simple c){
			this.composant=c.composant;
			this.entree=c.entree;
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
		
		@Override
		public String toString(){
			return composant+"#"+entree;
		}
	}
	
	//Connexion_simple particulière utilisée comme interface en sortie dans le cas des $Composite
	public class Interface extends Connexion_simple{
		
		
		public Interface(int num_interface){
			super(-1,num_interface);
		}
		
		public int getInterface(){
			return super.entree;
		}
		
		//Redefinition de equals afin de simplifier les operations sur les listes par la suite
		@Override
		public boolean equals(Object in){
			if (in instanceof Interface){
				return ((Interface)in).getEntree()==this.getEntree();
			}
			else{
				return false;
			}
		}
		
		@Override
		public String toString(){
			return "#"+super.entree;
		}
	}
	
	//Attribut definissant la liste des connexions associees a une sortie
	public List<Connexion_simple> connexions;
	
	//Constructeur de base
	public Connexion(){
		connexions= new LinkedList<Connexion_simple>();
	}
	
	//Renvoie une copie de la liste de connexions
	public List<Connexion_simple> connexions(){
		List<Connexion_simple> l=new LinkedList<Connexion_simple>();
		for (Connexion_simple c : this.connexions){
			if(c instanceof Interface){
				l.add(new Interface(((Interface)c).getInterface()));
			}
			else{
				l.add(new Connexion_simple(c));
			}
		}
		return l;
	}
	
	//Ajout d'une connexion sur la sortie
	public void add(int composant, int entree){
		Connexion_simple co=new Connexion_simple(composant,entree);
		if(!this.connexions.contains(co)){
			this.connexions.add(co);
		}
	}
	
	//Ajoute une interface à la liste de connexions
	public void add_interface(int num_interface){
		Interface in=new Interface(num_interface);
		if(!this.connexions.contains(in)){
			this.connexions.add(in);
		}
	}
	
	//Retrait d'une connexion sur la sortie
	public void remove(int composant, int entree){
		Connexion_simple co=new Connexion_simple(composant,entree);
		this.connexions.remove(co);
	}
	
	//Affiche la liste des connexions
	@Override
	public String toString(){
		String s="(";
		//On récupère pour chacune des connexions le numéro de composant et d'entrée à laquelle la sortie est connectée
		for (Connexion_simple c : this.connexions){
			s=s+c.toString()+",";
		}
		s=s.substring(0, s.length()-1)+")";
		return s;		
	}
	
	public boolean isEmpty(){
		return this.connexions.isEmpty();
	}
	
	public boolean contains_interface(int in){
		return this.connexions().contains(new Interface(in));
	}
}
