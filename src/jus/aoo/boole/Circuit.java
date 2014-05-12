package jus.aoo.boole;

import jus.aoo.boole.composant.*;
import jus.aoo.boole.port.*;

//extends connexion?
public class Circuit extends Connexion implements _Operer{
	
	// Classe implémentant les composants du circuit
	private class comp_circuit{
		
		//Définit l'ordre de passage des composants
		private int ordre;
		private $Composant comp;
		//Tableau des entrées reliées aux sorties du composant traité
		private Connexion connexions[];// tableau de connexions sortantes
		
		private comp_circuit($Composant comp){
			this.comp=comp;
			this.connexions=new Connexion[comp.nb_sorties()];
			int i;
			//Initialisation des listes de connexions simple dans les tables du tableau
			for(i=0;i<connexions.length;i++){
				connexions[i]=new Connexion();
			}
			//Initialisation de l'ordre de passage à -1
			this.ordre=-1;
		}
		
		//Ajoute a la sortie designee une connexion entre comp et l'entree definie par num_composant et num_entree
		public void add(int sortie,int num_composant, int num_entree){
			this.connexions[sortie].add(num_composant, num_entree);
		}
		
		public void remove(int sortie,int num_composant, int num_entree){
			this.connexions[sortie].remove(num_composant, num_entree);
		}
		
		//Appel de l'operer du composant
		public void operer(){
			this.comp.operer();
		}
		
		//ATTENTION: La méthode suivante ne renvoie pas une copie du composant, mais le composant en lui-même. Nous n'avons pas réussi à implémenter le clonage simplement.
		public $Composant getcomp(){
			return this.comp.clone();
		}
		
		//récupère les connexions sortante de ce composant
		public Connexion[] getconnexions(){
			Connexion[] connexion = new Connexion[this.connexions.length];
			int i;
			for(i=0;i<connexion.length;i++){
				connexion[i]= this.connexions[i];
			}
			return connexion;
		}
		
		//Modifie le niveau du port spécifié. C'est à dire, le courant "circule" dans ce port.
		public void set_niveau(int num_entree, Niveau n){
			this.comp.set_port(true,num_entree, n);
		}
		
		public void set_ordre(int num_comp){
			this.ordre=num_comp;
		}
		
		public int get_ordre(){
			return this.ordre;
		}
		
		public void raz(){
			this.ordre=-1;
			this.comp.raz();
		}
	}
	
	//Tableau de composants et connexions
	private comp_circuit tab_composants[];
	private String nom;
	
	//Circuit doit definir les différents niveaux et les connexions entre les composants. C'est lui qui utilise les cases
	//allouées dans le tableau créé par le constructeur dans les composants.
	
	//Place l'interrupteur spécifié au niveau voulu si c'en est un
	public void modif_itr(int num_composant, Niveau n) throws Exception{
		if(this.tab_composants[num_composant].getcomp() instanceof Itr){
			((Itr)this.tab_composants[num_composant].comp).modifier_etat(n);
		}
		else{
			throw new Exception("Le composant spécifié n'est pas un interrupteur");
		}
	}
	
	//Place l'interrupteur spécifié au niveau opposé si c'en est un
	public void modif_itr(int num_composant) throws Exception{
		if(this.tab_composants[num_composant].getcomp() instanceof Itr){
			((Itr)this.tab_composants[num_composant].comp).modifier_etat();
		}
		else{
			throw new Exception("Le composant spécifié n'est pas un interrupteur");
		}
	}
	
	//Renvoie le composant (l'original) spécifié
	public $Composant getcomp(int i){
		return this.tab_composants[i].getcomp();
	}
	
	//Renvoie la taille du tableau de composants du circuit
	public int length(){
		return this.tab_composants.length;
	}
	
	//Renvoie le nom du circuit
	public String nom(){
		return new String(nom);
	}
	
	//Constructeur de base
	public Circuit(){
		this.nom="";
	}
	
	//Constructeur utilisé dans le code, à partir d'un tableau de composants que l'utilisateur initialise et d'un nom de circuit
	public Circuit(String nom, $Composant composants[]){
		this.nom = nom;
		this.tab_composants=new comp_circuit[composants.length];
		int i;
		for(i=0;i<composants.length;i++){
			this.tab_composants[i]=new comp_circuit(composants[i]);
		}
	}
	
	//Ajoute une connexion entre la sortie num_sortie du composant comp_sortie et l'entrée num_entree du composant comp_entree
	public void connexion(int comp_sortie, int num_sortie, int comp_entree, int num_entree){
		this.tab_composants[comp_sortie].add(num_sortie, comp_entree, num_entree);
	}
	
	//Pareil que ci-dessus, à l'exception près que l'ordre de passage du composant dont l'entrée est remis à -1 et ses ports au niveau Aucun
	public void enleve_connexion(int comp_sortie, int num_sortie, int comp_entree, int num_entree){
		this.tab_composants[comp_sortie].remove(num_sortie, comp_entree, num_entree);
		this.tab_composants[comp_entree].raz();
	}
	
	//Indique si il y a un port en entrée ouvert après Operer.
	public boolean est_ouvert(){
		int i=0;
		boolean b=false;
		//Si l'odre de passage d'un composant est à -1 après operer(), c'est que l'une de ses entrées est ouverte
		while(!b && i<this.tab_composants.length){
			b=(this.tab_composants[i].get_ordre()==-1);
			i++;
		}
		return b;
	}
	
	//Permet de trouver le prochain composant où il est possible d'effectuer operer
	private int trouve_comp(){
		int i,j;
		boolean b;
		i=0;
		while(i< this.tab_composants.length){
			//Si l'élément du tableau a son ordre à -1 (non spécifié donc) on vérifie si ses entrées sont pleines ou non
			if(this.tab_composants[i].get_ordre()==-1){
				j=0;
				b=false;
				Port[] tab_ent = this.tab_composants[i].getcomp().ent_tab();
				while(!b && j<tab_ent.length){
					if(tab_ent[j].get_etat()== Niveau.Aucun){
						b = true;
					}
					j++;
				}
				
				//Si l'ordre de l'élément n'est pas déjà spécifié et que ses entrées sont pleines, on renvoie son numéro
				if(!b){
					break;
				}
			}
			i++;
		}
		return i;
	}
	
	private void operer_comp(int x){
		Connexion[] co;
		int i;
		int comp,ent;
		Niveau n;
		//On met à jour les niveaux des sorties en fonction de ceux des entrées (operer)
		this.tab_composants[x].operer();
		co=this.tab_composants[x].getconnexions();
		//Pour chaque sortie du composant, on place son niveau aux entrées auxquelles in est connecté
		for(i=0;i<co.length;i++){
			n=tab_composants[x].getcomp().sor_tab()[i].get_etat();
			for (Connexion_simple c : co[i].connexions){
				comp=c.getComp();
				ent=c.getEntree();
				this.tab_composants[comp].set_niveau(ent, n);
			}
		}
	}
	
	public void operer(){
			int i,l,j;
			l=-1;
			//On commence par réaliser les opérations sur les composants dont l'ordre de passage est déjà spécifié
			for(i=0;i<this.tab_composants.length;i++){
				if(this.tab_composants[i].get_ordre()>l){l=this.tab_composants[i].get_ordre();}
			}
			i=0;
			while(i<=l){
				j=0;
				while(j<this.tab_composants.length && this.tab_composants[j].get_ordre()!=i){
					j++;
				}
				if (j<this.tab_composants.length){operer_comp(j);}
				i++;
			}
			i=trouve_comp();
			int cpt=l+1;
			//Lorsque i est égal à tab_composants.length, on ne peut plus effectuer l'opération operer sur les composants du circuit
			while(i!=this.tab_composants.length){
				//On modifie l'ordre de passage du composant sur lequel on se trouve
				this.tab_composants[i].set_ordre(cpt);
				this.operer_comp(i);
				//On cherche le prochain composant dont les entrées sont pleines
				i=trouve_comp();
				cpt++;
			}
	}
	
	@Override
	public String toString(){
		Connexion[] co;
		//On place le nom du circuit
		String s=new String(this.nom+"[\n");
		int i,j,comp,ent;
		for(i=0;i<this.tab_composants.length;i++){
			//Ajout du nom du composant et son nombre d'entrées et  de sorties
			s=s+"	<"+tab_composants[i].get_ordre()+"|"+this.tab_composants[i].getcomp().toString();
			//Si il y a des sorties, ajouter une flèche
			if(this.tab_composants[i].getcomp().nb_sorties()!=0){
				s=s+"->";
				co=this.tab_composants[i].getconnexions();
				//Pour chaque sortie, on affiche la liste des connnexions associées
				for(j=0;j<this.tab_composants[i].getcomp().sor_tab().length;j++){
					if(!co[j].connexions.isEmpty()){
						s=s+"#"+j+"(";
						//On récupère pour chacune des connexions le numéro de composant et d'entrée à laquelle la sortie est connectée
						for (Connexion_simple c : co[j].connexions){
							comp=c.getComp();
							ent=c.getEntree();
							s=s+comp+"#"+ent+",";
						}
						//Substring enlève les virgules en trop
						s=s.substring(0, s.length()-1)+")"+",";
					}
				}
				s=s.substring(0, s.length()-1);
			}
			s=s+">\n";
		}
		return s+"]";
	}
}
