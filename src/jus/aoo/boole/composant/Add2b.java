package jus.aoo.boole.composant;


public class Add2b extends $Composite{
	public Add2b(){
		super("Add2b",2,2);
		$Composant[] composants = new $Composant[2];
		composants[0]= new Oux();
		composants[1]= new Et();
		super.cir=new Cir("Add2b",composants);
		this.connexion_entree_interface(0, 0, 0);
		this.connexion_entree_interface(0, 1, 0);
		this.connexion_entree_interface(1, 0, 1);
		this.connexion_entree_interface(1, 1, 1);
		//La sortie 1 correspond à la somme des 2 entiers
		this.connexion_sortie_interface(1, 0, 0);
		//La sortie 0 correspond à la retenue engendrée
		this.connexion_sortie_interface(0, 1, 0);
	}
}