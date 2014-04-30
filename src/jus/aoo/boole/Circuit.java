package jus.aoo.boole;

import jus.aoo.boole.composant.*;
import jus.aoo.boole.port.*;

public class Circuit implements _Operer{
	
	private String nom;
	
	private class comp_circuit extends Connexion{
		private $Composant comp;
		private Connexion connexions[];
		
		public comp_circuit($Composant comp){
			this.comp=comp;
			this.connexions=new Connexion[comp.nb_sorties()];
		}
		
		//Ajoute a la sortie designee une connexion entre comp et l'entree definie par num_composant et num_entree
		public void add(int sortie,int num_composant, int num_entree){
			this.connexions[sortie-1].add(num_composant, num_entree);
		}
	}
	
	//Tableau de composants et connexions
	private comp_circuit tab_composants[];
	
	//Circuit doit définir les différents niveaux et les connexions entre les composants. C'est lui qui utilise les cases
	//allouées dans le tableau créé par le constructeur dans les composants.
	

	public Circuit(){
		this.nom="";
	}
	
	public Circuit(String nom){
		this.nom=nom;
	}
	
	public boolean est_ouvert(){		
		boolean b = false;
		$Composant[] tab_comp = this.tab_composants;
		int i=0;
		int j;
		while (!b) {
			$Composant comp = tab_comp[i];
			Port[] tab_ent = comp.ent_tab();
			Port[] tab_sor = comp.sor_tab();
			j=0;
			while(!b){
				Port ent = tab_ent[j];
				if((ent.get_etat()!= Niveau.Haut)||(ent.get_etat()!= Niveau.Bas)){
					b = true;
					j++;
				}
			}
			j=0;
			while(!b){
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
	
	public void affiche_circuit(){
		//COMPLETER
	}
}
