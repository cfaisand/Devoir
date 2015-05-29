public class Terrain {

	private String nomTerrain;
	private float superficie;


	public Terrain(){}

	//Constructeur qui initialise le Terrain courrant
	public Terrain(String nom, float s){
		this.nomTerrain = nom;
		this.superficie = s;
	}

	//méthode qui initialise le Terrain courrant
	public void init(){
		this.nomTerrain = Lire.jString("Indiquez le nom du Terrain courrant :");
		this.superficie = Lire.jfloat("Indiquez la superficie du Terrain courrant :");
	}


	public String getNomTerrain(){
		return this.nomTerrain;
	}

	public float getSuperficie(){
		return this.superficie;
	}

	public void setNomTerrain(String nom){
		this.nomTerrain = nom;
	}

	public void setSuperficieTerrain(float s){
		this.superficie = s;
	}

	public String toString(){
		return "Nom du Terrain : " + nomTerrain + " de superficie : " + superficie;
	}
}