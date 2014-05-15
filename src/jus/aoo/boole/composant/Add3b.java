package jus.aoo.boole.composant;

public class Add3b extends $Composite{
	
	public Add3b(){
		super("Add3b",2, 3);
		$Composant[] composants = new $Composant[3];
		composants[0]=new Add2b();
		composants[1]=new Add2b();
		composants[2]=new Ou();
		super.cir=new Cir("Add3b",composants);
		//On connecte les 2 derniers bits au premier additionneur
		this.connexion_entree_interface(1, 0, 0);
		this.connexion_entree_interface(2, 0, 1);
		//On connecte la retenue au ou et le résultat à l'autre additionneur
		cir.connexion(0, 1, 1, 0);
		cir.connexion(0, 0, 2, 0);
		//Le premier bit est connecté au second additionneur
		this.connexion_entree_interface(0, 1, 1);
		//Le résultat du second additionneur est placé dans la sortie 1, et la retenue dans le ou
		this.connexion_sortie_interface(1, 1, 1);
		cir.connexion(1, 0, 2, 1);
		//La retenue de l'additionneur est renvoyée dans la sortie 0
		this.connexion_sortie_interface(0, 2, 0);
	}
}
