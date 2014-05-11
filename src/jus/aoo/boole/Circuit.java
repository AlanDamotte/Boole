package jus.aoo.boole;

import jus.aoo.boole.composant.*;
import jus.aoo.boole.port.*;

//extends connexion?
public class Circuit extends Connexion implements _Operer{
	
	private class comp_circuit{ // les composants du circuit
		
		private int num_composant;
		private boolean op;
		private $Composant comp;
		private Connexion connexions[];// tableau de connexions sortantes
		
		public comp_circuit($Composant comp){
			this.comp=comp;
			this.connexions=new Connexion[comp.nb_sorties()];
			int i;
			for(i=0;i<connexions.length;i++){
				connexions[i]=new Connexion();
			}
			this.op=true;
			this.num_composant=-1;
		}
		
		//Ajoute a la sortie designee une connexion entre comp et l'entree definie par num_composant et num_entree
		public void add(int sortie,int num_composant, int num_entree){
			this.connexions[sortie].add(num_composant, num_entree);
		}
		
		public boolean get_op(){
			return op;
		}
		
		public void set_op(boolean b){
			this.op=b;
		}
		
		public void operer(){
			this.comp.operer();
		}
		
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
		
		public void set_niveau(int num_entree, Niveau n){
			this.comp.set_port(true,num_entree, n);
		}
		
		public void set_num_comp(int num_comp){
			this.num_composant=num_comp;
		}
		
		public int get_num_comp(){
			return this.num_composant;
		}
	}
	
	//Tableau de composants et connexions
	private comp_circuit tab_composants[];
	private String nom;
	
	//Circuit doit definir les différents niveaux et les connexions entre les composants. C'est lui qui utilise les cases
	//allouées dans le tableau créé par le constructeur dans les composants.
	

	public void modif_itr(int num_composant, Niveau n) throws Exception{
		if(this.tab_composants[num_composant].getcomp() instanceof Itr){
			((Itr)this.tab_composants[num_composant].comp).modifier_etat(n);
		}
		else{
			throw new Exception("Le composant spécifié n'est pas un interrupteur");
		}
	}
	
	public Circuit(){
		this.nom="";
	}
	
	public Circuit(String nom, $Composant composants[]){
		this.nom = nom;
		this.tab_composants=new comp_circuit[composants.length];
		int i;
		for(i=0;i<composants.length;i++){
			this.tab_composants[i]=new comp_circuit(composants[i]);
		}
	}
	
	public void connexion(int comp_sortie, int num_sortie, int comp_entree, int num_entree){
		this.tab_composants[comp_sortie].add(num_sortie, comp_entree, num_entree);
	}
	
	//A tester
	public boolean est_ouvert(){
		int i=0;
		boolean b=false;
		while(!b && i<this.tab_composants.length){
			b=(this.tab_composants[i].get_num_comp()==-1);
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
			if(this.tab_composants[i].get_op()){
				j=0;
				b=false;
				Port[] tab_ent = this.tab_composants[i].getcomp().ent_tab();
				while(!b && j<tab_ent.length){
					if(tab_ent[j].get_etat()== Niveau.Aucun){
						b = true;
					}
					j++;
				}
				
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
		this.tab_composants[x].operer();
		co=this.tab_composants[x].getconnexions();
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
			for(i=0;i<this.tab_composants.length;i++){
				if(this.tab_composants[i].get_num_comp()>l){l=this.tab_composants[i].get_num_comp();}
			}
			i=0;
			while(i<=l){
				j=0;
				while(j<this.tab_composants.length && this.tab_composants[j].get_num_comp()!=i){
					j++;
				}
				if (j<this.tab_composants.length){operer_comp(j);}
				i++;
			}
			i=trouve_comp();
			int cpt=l+1;
			//Lorsque i est égal à tab_composants.length, on ne peut plus effectuer l'opération operer
			while(i!=this.tab_composants.length){
				this.tab_composants[i].set_op(false);
				this.tab_composants[i].set_num_comp(cpt);
				this.operer_comp(i);
				i=trouve_comp();
				cpt++;
			}
	}
	
	@Override
	public String toString(){
		Connexion[] co;
		String s=new String(this.nom+"[\n");
		int i,j,comp,ent;
		for(i=0;i<this.tab_composants.length;i++){
			s=s+"<"+tab_composants[i].get_num_comp()+"|"+this.tab_composants[i].getcomp().toString();
			if(this.tab_composants[i].getcomp().nb_sorties()!=0){
				s=s+"->";
				co=this.tab_composants[i].getconnexions();
				for(j=0;j<this.tab_composants[i].getcomp().sor_tab().length;j++){
					if(!co[j].connexions.isEmpty()){
						s=s+"#"+j+"(";
						for (Connexion_simple c : co[j].connexions){
							comp=c.getComp();
							ent=c.getEntree();
							s=s+comp+"#"+ent+",";
						}
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
