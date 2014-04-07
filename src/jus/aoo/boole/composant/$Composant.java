package jus.aoo.boole.composant;


public abstract class $Composant implements _Composant{
	
	/**
	 * @invariant num_composant_OK: num_composant>0
	 */
	protected int num_composant;
	//Les listes d'entrées/sorties sont à définir dans les classes en dessous, générateurs & co
	//protected List<Entree> ent_list = new LinkedList<Entree>();
	//protected List<Sortie> sor_list = new LinkedList<Sortie>();	
	protected String nom;
	protected int nb_sorties;
	protected int nb_entrees;
	//Infos complémentaires: quel attribut mettre ?
	
	protected $Composant (){
		
	}

	public $Composant (String nom, int num_composant, int nb_sorties, int nb_entrees){
		this.num_composant=num_composant;
		this.nom=nom;
		this.nb_sorties=nb_sorties;
		this.nb_entrees=nb_entrees;
	}
	
	public int num_composant(){
		//num_composant est un integer, ainsi num_composant ne sera pas modifiable en donnant sa valeur telle quelle
		return num_composant;
	}
	
	public int nb_entrees(){
		return nb_entrees;
	}
	
	public int nb_sorties(){
		return nb_sorties;
	}
	
	public String nom(){
		return new String(nom);
	}
}