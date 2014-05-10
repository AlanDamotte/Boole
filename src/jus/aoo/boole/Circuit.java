package jus.aoo.boole;

import jus.aoo.annuaire.Personne;
import jus.aoo.boole.composant.*;
import jus.aoo.boole.port.*;

import java.lang.Throwable;

//extends connexion?
public class Circuit implements _Operer{
	
	private class comp_circuit extends Connexion{ // les composants du circuit
		
		private boolean op;
		private $Composant comp;
		private Connexion connexions[];// tableau de connexions sortantes
		
		public comp_circuit($Composant comp){
			this.comp=comp;
			this.connexions=new Connexion[comp.nb_sorties()];
			this.op=true;
		}
		
		public comp_circuit(comp_circuit compc){
			this.comp=compc.getcomp();
			this.connexions=compc.getconnexions();
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
		
		public void modif_connexions(int x){
			int comp,ent;
			for (Connexion_simple c : this.connexions[x].connexions){
				comp=c.getComp();
				ent=c.getEntree();
				tab_composants[x].
			}
		}
	}
	
	//Tableau de composants et connexions
	private comp_circuit tab_composants[];
	private String nom;
	
	//Circuit doit définir les différents niveaux et les connexions entre les composants. C'est lui qui utilise les cases
	//allouées dans le tableau créé par le constructeur dans les composants.
	

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
		boolean b = false;
		comp_circuit[] tab_comp = this.tab_composants.clone();
		int i=0;
		int j;
		while ((!b )&& (i< tab_comp.length)) {
			comp_circuit comp = new comp_circuit( tab_comp[i] );
			Port[] tab_ent = comp.getcomp().ent_tab();
			Port[] tab_sor = comp.getcomp().sor_tab();
			j=0;
			while((!b) && (j< tab_ent.length)){
				Port ent = tab_ent[j];
				if((ent.get_etat()!= Niveau.Haut)||(ent.get_etat()!= Niveau.Bas)){
					b = true;
					j++;
				}
			}
			j=0;
			while((!b) && (j< tab_sor.length)){
				Port sor = tab_sor[j];
				if((sor.get_etat()!= Niveau.Haut)||(sor.get_etat()!= Niveau.Bas)){
					b = true;
					j++;
				}
			}
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
					if((tab_ent[j].get_etat()!= Niveau.Haut)||(tab_ent[j].get_etat()!= Niveau.Bas)){
						b = true;
						j++;
					}
				}
				if(b){
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
		this.tab_composants[x].operer();
		co=this.tab_composants[x].getconnexions();
		for(i=0;i<co.length;i++){
			this.tab_composants[x].modif_connexions(i);
		}
	}
	
	public void operer(){
		int i=trouve_comp();
		//Lorsque i est égal à tab_composants.length, on ne peut plus effectuer l'opération operer
		while(i!=this.tab_composants.length){
			this.tab_composants[i].set_op(false);
			this.operer_comp(i);
			i=trouve_comp();
		}
	}
	
	/**@overide
	 */
	public String toString(){
		//COMPLETER
		return "";
	}
}
