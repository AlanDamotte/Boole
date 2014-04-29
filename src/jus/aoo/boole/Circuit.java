package jus.aoo.boole;

import jus.aoo.boole.composant.*;
import jus.aoo.boole.port.Entree;
import jus.aoo.boole.port.Sortie;

public class Circuit implements _Operer{
	
	private String nom;
	
	public enum NiveauVisuel {
		Eteint, Allume;
	}
	
	//Tableau de composants
	private $Composant tab_composants[];
	
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
			Entree[] tab_ent = comp.ent_tab();
			Sortie[] tab_sor = comp.sor_tab();
			j=0;
			while(!b){
				Entree ent = tab_ent[j];
				if((ent.get_etat()!= Niveau.Haut)||(ent.get_etat()!= Niveau.Bas)){
					b = true;
					j++;
				}
			}
			j=0;
			while(!b){
				Sortie sor = tab_sor[j];
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
