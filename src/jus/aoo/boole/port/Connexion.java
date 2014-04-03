package jus.aoo.boole.port;

public class Connexion {
	private int entree;
	private int sortie;
	
	public int entree(){
		return entree;
	}
	
	public int sortie(){
		return sortie;
	}
	
	public Connexion(int entree, int sortie){
		this.entree=entree;
		this.sortie=sortie;
	}
}
