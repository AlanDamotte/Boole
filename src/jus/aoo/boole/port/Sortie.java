package jus.aoo.boole.port;

import java.util.LinkedList;
import java.util.List;

public class Sortie extends $Port{
	protected List<Connexion> sorties = new LinkedList<Connexion>();
	
	public List<Connexion> getSortie(){
		return this.sorties;
	}

}