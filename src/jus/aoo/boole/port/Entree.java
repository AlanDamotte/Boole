package jus.aoo.boole.port;

public class Entree extends $Port{
	
	public Entree get(){
		Entree res=new Entree();
		res.set_id(this.get_id());
		res.set_etat(this.get_etat());
		return res;
	}
}