package jus.aoo.boole.port;

public abstract class $Port {
	protected boolean etat;
	protected int identifiant;
	
	public boolean get_etat(){
		return this.etat;
	}
	
	public void set_etat(boolean b){
		this.etat=b;
	}
}
