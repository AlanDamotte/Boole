package jus.aoo.boole;

import jus.aoo.boole.Circuit;
import jus.aoo.boole.Niveau;
import jus.aoo.boole.composant.*;

public class TestOux{
	
	private Circuit cir;
	
	public TestOux(){
		//Initialisation des composants à insérer dans le circuit
		Oux xor = new Oux();
		Itr int1=new Itr();
		Itr int2=new Itr();
		Led l= new Led();
	
		//Création du tableau contenant les composants, puis du circuit
		$Composant tabcomp[]={int1,int2,l,xor};
		cir= new Circuit("TestOux",tabcomp);
		
		//Ajout des connexions du circuit
		cir.connexion(0, 0, 3, 0);
		cir.connexion(1, 0, 3, 1);
		cir.connexion(3, 0, 2, 0);
	}
	
	public void tester() throws Exception{
		//On affiche le circuit pour chacune des positions possibles de l'interrupteur
        cir.modif_itr(0, Niveau.Haut);
		cir.modif_itr(1, Niveau.Haut);
		cir.operer();
		System.out.println(cir.toString()+"\n");
		
        cir.modif_itr(0, Niveau.Bas);
		cir.modif_itr(1, Niveau.Haut);
		cir.operer();
		System.out.println(cir.toString()+"\n");
		
        cir.modif_itr(0, Niveau.Haut);
		cir.modif_itr(1, Niveau.Bas);
		cir.operer();
		System.out.println(cir.toString()+"\n");
		
        cir.modif_itr(0, Niveau.Bas);
		cir.modif_itr(1, Niveau.Bas);
		cir.operer();
		System.out.println(cir.toString());
		
	}

	//Méthode affichant le test
	public static void main(String[] args) throws Exception{
		TestOux t = new TestOux();
		t.tester();
	}
	
}
