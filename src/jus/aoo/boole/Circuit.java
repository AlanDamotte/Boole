package jus.aoo.boole;

import jus.aoo.boole.composant.*;

public class Circuit implements _Operer{
	
	private String nom;
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
		boolean b;
		// MEILLEUR IMPLEMENTATION => WHILE : ON S'ARRETE LORSQU'UN PORT N'EST PAS CONNECTE
		for ($Composant comp : this.tab_composants) {
			// FOR EACH A COMPLETER EN REGARDANT CHACUN DES PORTS
			if(comp instanceof $Generateur){
			
			}
			if(comp instanceof $Recepteur){
				
			}
			if(comp instanceof $Transformateur){
				
			}
			}
		b = false;
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
	
	public void affiche_circuit(){
		//COMPLETER
	}
}
