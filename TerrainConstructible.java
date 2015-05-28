import java.util.ArrayList;
import java.io.*;
import java.util.StringTokenizer;

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

	//initialise interactivement le TerrainConstructible
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

	//initianlise le nombre d'habitation possible sur le TerrainConstructible (max = 5)
	public void setNbHabitation(int nb){
		if (nb <= 5 ){
			this.nbHabitations = nb;
		}else{
			System.out.println("le nombre d'habitation est trop grand pour sa superficie...");
		}
	}


	//Construit une Habitation sur le TerrainConstructible courant
	public void construireHabitation(Habitation h) throws Exception{
		if (this.nbHabitations == 5) throw new Exception("Nombre maximum d'habitation atteint ! On ne peut plus en rajouter !");

		this.listeHabitations.add(h);
		this.nbHabitations++;
	}

	// détruit et retourne une habitation du TerrainConstructible courant
	public Habitation detruireHabitation(Habitation h) throws Exception{

		for(int i=0; i<nbHabitations; i++){

		    if(listeHabitations.get(i).equals(h)){
				this.listeHabitations.remove(i);
				return h;
			}
			i++;
		}
		throw new Exception("L'habitation n'est pas sur le terrain !");
		
	}

	public String toString(){
		
		String s = new String();
		for(int i=0; i<nbHabitations; i++){
			s+= listeHabitations.get(i).toString() +"\n";
		}
		return super.toString() + s;
	}
	
        public void sauvegarder(String nomFichier) throws IOException{
	Writer fOut;
	PrintWriter pOut;
	try
	    {
		fOut = new FileWriter(nomFichier);
		pOut = new PrintWriter(fOut);
		pOut.println(this.getNomTerrain());
		pOut.println(this.getSuperficie());
		if(this.nbHabitations!=0){
		    for(int i=0; i<nbHabitations; i++){
			if(this.listeHabitations.get(i) instanceof Maison){
			    Maison m=(Maison)this.listeHabitations.get(i);
			    pOut.println("Maison;"+m.getAdresse()+";"+m.getnbPieces()+";"+m.gettypeChauffage());
			}else{
			    if(this.listeHabitations.get(i) instanceof Immeuble){
				Immeuble imm=(Immeuble)this.listeHabitations.get(i);
				pOut.println("Immeuble;"+imm.getAdresse()+";"+imm.getnbApps()+";"+imm.getnbEtages());
			    }else{
				Habitation h=this.listeHabitations.get(i);
				pOut.print("Habitation;"+ h.getAdresse());
			    }
			}
		    }
		}
		
		pOut.close();
		
	    }
	catch(IOException e){
	    System.out.println(e);
	    fOut = null;
	    pOut = null;
	}
    }



}