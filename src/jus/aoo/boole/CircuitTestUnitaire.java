package jus.aoo.boole;

import java.util.Iterator;

import jus.aoo.boole.Circuit;
import jus.aoo.boole.composant.*;

public class CircuitTestUnitaire {
	
	private Circuit c;
	private int nb_entrees;
	private int nb_sorties;
	
	
	public CircuitTestUnitaire($Composant comp){
		$Composant[] tab=new $Composant[comp.nb_entrees()+comp.nb_sorties()+1];
		int i;
		tab[comp.nb_entrees()+comp.nb_sorties()]=comp;
		this.nb_entrees=comp.nb_entrees();
		this.nb_sorties=comp.nb_sorties();
		for(i=0;i<nb_entrees;i++){
			tab[i]=new Itr();
		}
		for(i=nb_entrees;i<(nb_entrees+nb_sorties);i++){
			tab[i]=new Led();
		}
		c=new Circuit(comp.nom(),tab);
		for(i=0;i<nb_entrees;i++){
			c.connexion(i, 0, nb_entrees+nb_sorties, i);
		}
		for(i=comp.nb_entrees();i<(nb_entrees+nb_sorties);i++){
			c.connexion(nb_entrees+nb_sorties, i-nb_entrees, i, 0);
		}
	}
	
	private void recursion(int prof) throws Exception{
		Iterator<Void> i=((Itr)c.getcomp(prof)).iterator();
		int j;
		if(prof<(nb_entrees-1)){
			while(i.hasNext()){
				this.recursion(prof+1);
				c.modif_itr(prof);
				i.next();
			}
		}
		else{
			while(i.hasNext()){
				c.operer();
				for(j=0;j<nb_entrees;j++){
					if(c.getcomp(nb_entrees+nb_sorties).ent_tab()[j].get_etat()==Niveau.Bas){
						System.out.print(0+"  ");
					}
					else{
						System.out.print(1+"  ");
					}
				}
				
				for(j=0;j<nb_sorties;j++){
					if(c.getcomp(nb_entrees+nb_sorties).sor_tab()[j].get_etat()==Niveau.Bas){
						System.out.print(0+"  ");
					}
					else{
						System.out.print(1+"  ");
					}
				}
				System.out.print("\n");
				
				c.modif_itr(prof);
				i.next();
			}
		}
	}
	
	public void tester() throws Exception{
		int i;
		for(i=0;i<nb_entrees;i++){
			System.out.print("E"+(i+1)+" ");
		}

		for(i=0;i<nb_sorties;i++){
			System.out.print("S"+(i+1)+" ");
		}
		System.out.print("\n");
				
		this.recursion(0);
	}
	
	public static void main(String[] args) throws Exception{
		CircuitTestUnitaire cir = new CircuitTestUnitaire(new Ou());
		cir.tester();
	}
	
}
