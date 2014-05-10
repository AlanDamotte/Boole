package jus.aoo.boole;

import jus.aoo.boole.Circuit;
import jus.aoo.boole.Niveau;
import jus.aoo.boole.composant.*;

public class TestOux{
	
	private Circuit cir;
	
	public TestOux(){
		Oux xor = new Oux();
		Itr int1=new Itr();
		Itr int2=new Itr();
		Led l= new Led();
	
		
		$Composant tabcomp[]={int1,int2,xor,l};
		cir= new Circuit("TestOux",tabcomp);
		
		cir.connexion(0, 0, 2, 0);
		cir.connexion(1, 0, 2, 1);
		cir.connexion(2, 0, 3, 0);
	}
	
	public void tester() throws Exception{
        cir.modif_itr(0, Niveau.Bas);
		cir.modif_itr(1, Niveau.Bas);
		cir.operer();
		System.out.println(cir.toString()+"\n");
		/*
        cir.modif_itr(0, Niveau.Bas);
		cir.modif_itr(1, Niveau.Haut);
		cir.operer();
		System.out.println(cir.toString()+"\n");
		
        cir.modif_itr(0, Niveau.Haut);
		cir.modif_itr(1, Niveau.Bas);
		cir.operer();
		System.out.println(cir.toString()+"\n");
		
        cir.modif_itr(0, Niveau.Haut);
		cir.modif_itr(1, Niveau.Haut);
		cir.operer();
		System.out.println(cir.toString());
		*/
	}
    
	public static void main(String[] args) throws Exception{
		TestOux t = new TestOux();
		t.tester();
	}
	
}
