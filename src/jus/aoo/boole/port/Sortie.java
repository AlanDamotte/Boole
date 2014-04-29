package jus.aoo.boole.port;


public class Sortie extends $Port{
	protected Connexion sorties[];
	
	private void set_connexion(Connexion sorties[]){
		this.sorties=sorties;
	}

	private Connexion[] get_connexion(){
		Connexion res[]=new Connexion[this.sorties.length];
		res=this.sorties.clone();
		return res;
	}
	
	public Sortie get(){
		Sortie res=new Sortie();
		res.set_etat(this.get_etat());
		res.set_id(this.get_id());
		res.set_connexion(this.get_connexion());
		return res;
	}

}