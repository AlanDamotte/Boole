package jus.aoo.boole.composant;

import jus.aoo.boole.port.*;
import jus.aoo.boole.*;
import jus.aoo.boole.Connexion.*;


//PAS ENCORE FONCTIONNEL

public abstract class $Composite extends $Composant implements _Operer {
	
	/**Operer sera décidé lors de circuit, et il sera appelé lors de composite
	*/
	
	//La liste des composants est apportée par circuit
	protected Cir cir;
	protected Connexion connexions_entree_interface[];
	
	//Classe interne utilisée pour renvoyer un doublon d'entiers
	private class Comp_sortie{
		public int num_comp;
		public int num_sortie;
		public Comp_sortie(int num_comp, int num_sortie){
			this.num_comp=num_comp;
			this.num_sortie=num_sortie;
		}
	}
	
	//Classe imbriquée à $Composite afin d'avoir un pseudo-héritage multiple avec $Composant et Circuit
	protected class Cir extends Circuit{

		private Cir (String nom){
			super.nom=nom;
		}
		
		//Constructeur utilisé dans le code, à partir d'un tableau de composants que l'utilisateur initialise et d'un nom de circuit
		public Cir(String nom, $Composant composants[]){
			super(nom,composants);
		}
		
		//Méthode permettant de modifier le niveau de l'entrée indiquée
		public void set_entree(int comp_entree, int num_entree, Niveau n){
			super.tab_composants[comp_entree].set_niveau(num_entree, n);
		}
		
		//Enlève le nom du circuit dans le string renvoyé
		@Override
		public String toString(){
			String s=super.toString();
			return s.substring(super.nom().length(), s.length()-2)+"]";
		}

		//Permet d'ajouter la sortie en interface à la sortie num_sortie du composant comp_sortie
		public void add_interface(int sortie_interface,int num_comp,int sortie){
			super.tab_composants[num_comp].add_interface(sortie, sortie_interface);
		}
		
		//Renvoie l'état de la sortie num_sortie du composant num_comp
		public Niveau get_etat(int num_comp,int num_sortie){
			return super.tab_composants[num_comp].getcomp().sor_tab[num_sortie].get_etat();
		}
		
		public Comp_sortie trouve_interface(int in){
			int i,j;
			j=0;
			boolean b=true;
			for(i=0;i<super.tab_composants.length;i++){
				for(j=0;j<super.tab_composants[i].getconnexions().length;j++){
					if( super.tab_composants[i].getconnexions()[j].contains_interface(in) ){
						b=false;
						break;
					}
				}
				if(!b){break;}
			}
			return new Comp_sortie(i,j);
		}
	}
	

	public $Composite(){
		super();
	}
	
	public $Composite(String nom){
		this.cir=new Cir(nom);
	}

	//Construit la classe sur le modèle de $Composant, et initialise les attributs cir et connexions_entree_interface
	public $Composite(String nom,int sorties, int entree){
		super(nom,new Port[sorties],new Port[entree]);
		this.cir=new Cir(nom);
		super.nom=nom;
		this.connexions_entree_interface = new Connexion[entree];
		int i;
		for(i=0;i<entree;i++){
			this.connexions_entree_interface[i]=new Connexion();
		}
	}
	
	//Méthode connectant une entrée du composite vers une entrée du circuit intégré à cir
	public void connexion_entree_interface(int entree_interface, int comp_entree, int num_entree){
		this.connexions_entree_interface[entree_interface].add(comp_entree, num_entree);
	}
	
	//Méthode connectant une sortie du circuit intégré à cir vers une sortie du composite
	public void connexion_sortie_interface(int sortie_interface, int comp_sortie, int num_sortie){
		this.cir.add_interface(sortie_interface, comp_sortie, num_sortie);
	}
	
	@Override
	public String toString(){
		String s=new String(super.toString()+"[");
		int i;
		for(i=0;i<super.nb_entrees();i++){
			if(!this.connexions_entree_interface[i].isEmpty()){
				s=s+"#"+i+this.connexions_entree_interface[i].toString()+",";
			}
		}
		s=s.substring(0, s.length()-1)+")"+cir.toString();
		return s.substring(0, s.length());
	}
	
	public void operer(){
		Niveau n;
		Comp_sortie c;
		if(super.ent_valide()){
			int i;
			for(i=0;i<super.nb_entrees();i++){
				n=super.ent_tab()[i].get_etat();
				for (Connexion_simple co : this.connexions_entree_interface[i].connexions()){
					cir.set_entree(co.getComp(), co.getEntree(), n);
				}
			}
			cir.operer();
			for(i=0;i<super.nb_sorties();i++){
				c=cir.trouve_interface(i);
				super.sor_tab[i].set_etat(cir.get_etat(c.num_comp,c.num_sortie));
			}
		}
	}
	
	
}