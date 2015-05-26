import java.util.ArrayList;
public class TerrainConstructible extends Terrain{

	private ArrayList<Habitation> listeHabitations = new ArrayList<Habitation> ();
	private final int MAXHABITATION = 5;
	private int nbHabitations;


	public TerrainConstructible(){
		super();
	}

	public TerrainConstructible(String nom, float s, ArrayList<Habitation> listHab){
		super(nom, s);
		if(listHab.size() > this.MAXHABITATION){
			System.out.println("Trop d'habitations pour ce terrain, aucune habitation n'a été créée");
			this.nbHabitations = 0;
		}else{
			this.listeHabitations = listHab;
			this.nbHabitations = listeHabitations.size();
		}

	}

	public void init(){
		this.setNomTerrain(Lire.jString("Donnez le nom du Terrain :"));
		this.setSuperficieTerrain(Lire.jfloat("Donnez la superficie :"));
		int j = Lire.jint("1 = Habitation, 2= Maison, 3= Immeuble et 4 = Sortir !");

		while(j > 0 && j != 4 && j < 5 && nbHabitations < MAXHABITATION){
			switch(j){
				case 1 : Habitation h = new Habitation();
					h.init();
					this.listeHabitations.add(h);

				case 2 : Maison m = new Maison();
					m.init();
					this.listeHabitations.add(m);

				case 3 : Immeuble i = new Immeuble();
					i.init();
					this.listeHabitations.add(i);
			}

			this.nbHabitations++;
			j = Lire.jint("1 = Habitation, 2 = Maison, 3 = Immeuble et 4 = Sortir !");

		}
 		
	}

	public void setNbHabitation(int nb){
		if (nb <= 5 ){
			this.nbHabitations = nb;
		}else{
			System.out.println("le nombre d'habitation est trop grand pour sa superficie...");
		}
	}



	public void construitreHabitation(Habitation h) throws Exception{
		if (this.nbHabitations == 5) throw new Exception("Nombre maximum d'habitation atteint ! On ne peut plus en rajouter !");

		this.listeHabitations.add(h);
		this.nbHabitations++;
	}

	

}