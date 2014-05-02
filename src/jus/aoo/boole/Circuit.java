package jus.aoo.boole;

import jus.aoo.boole.composant.*;
import jus.aoo.boole.port.*;

public class Circuit implements _Operer{
	
	private class comp_circuit extends Connexion{ // les composants du circuit
		
		private $Composant comp;
		private Connexion connexions[];// tableau de connexions sortantes
		
		public comp_circuit($Composant comp){
			this.comp=comp;
			this.connexions=new Connexion[comp.nb_sorties()];
		}
		
		public comp_circuit(comp_circuit compc){
			this.comp=compc.getcomp();
			this.connexions=compc.getconnexions();
		}
		
		//Ajoute a la sortie designee une connexion entre comp et l'entree definie par num_composant et num_entree
		public void add(int sortie,int num_composant, int num_entree){
			this.connexions[sortie-1].add(num_composant, num_entree);
		}
		
		
		public $Composant getcomp(){
			return this.comp;
		}
		
		//récupère les connexions sortante de ce composant
		public Connexion[] getconnexions(){
			Connexion[] connexion = new Connexion[this.connexions.length];
			return connexion;
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
		this.nom=nom;
		this.tab_composants=new comp_circuit[composants.length];
		int i;
		for(i=0;i<composants.length;i++){
			this.tab_composants[i]=new comp_circuit(composants[i]);
		}
	}
	
	public void connexion(int comp_sortie, int num_sortie, int comp_entree, int num_entree){
		this.tab_composants[comp_sortie-1].add(num_sortie, comp_entree, num_entree);
	}
	
	//A modifier
	public boolean est_ouvert(){		
		boolean b = false;
		comp_circuit[] tab_comp = this.tab_composants;
		int i=0;
		int j;
		while ((!b )&& (i< tab_comp.length)) {
			comp_circuit comp = new comp_circuit( tab_comp[i] );
			Port[] tab_ent = comp.comp.ent_tab();
			Port[] tab_sor = comp.comp.sor_tab();
			j=0;
			while((!b) && (j< tab_ent.length)){
				Port ent = tab_ent[j];
				if((ent.get_etat()!= Niveau.Haut)||(ent.get_etat()!= Niveau.Bas)){
					b = true;
					j++;
				}
			}
			j=0;
			while((!b) && (j< tab_ent.length)){
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
	
	// V�rifier dans le sujet si cette m�thode est n�cessaire
//	public void ajoute_composant($Composant composant){
//	
//	}
	
	public void supprime(int num_composant){
		/*for ($Composant comp : this.tab_composants) {
			if (comp.==num_composant){
				liste_composants.remove(comp);
			}
		}*/
	}
	
	
	//Completer quand ce sera possible
	public void operer(){
	}
	
	public void operer_circuit(){
		$Composant[] tab_comp = this.tab_composants;
		for (int i = 0; i < tab_comp.length; i++) {
			$Composant comp = tab_comp[i];
			comp.operer();
		}
	}
	
	/**@overide
	 */
	public String toString(){
		//COMPLETER
		return "";
	}
}
