import java.util.ArrayList;
import java.io.*;
import java.util.StringTokenizer;


/**
 * Création d'un terrain constructible et des différents méthodes qui lui sont applicables
 * @version 1.0
 * @authors C. Faisandier, T. Caridi
 */

public class TerrainConstructible extends Terrain{
    
    private ArrayList<Habitation> listeHabitations = new ArrayList<Habitation> ();
    private final int MAXHABITATION = 5;
    private int nbHabitations;
    
    /**
     * Constructeur vide appelant le constructeur de la classe Terrain
     */
    public TerrainConstructible(){
	super();
    }// fin constructeur
    
    /**
     * Initialise un nouvel objet de type TerrainConstructible de nom "nom", de superficie s et contenant les habitations de la liste listeHab.
     */
    public TerrainConstructible(String nom, float s, ArrayList<Habitation> listHab){
	super(nom, s);
	if(listHab.size() > this.MAXHABITATION){
	    System.out.println("Trop d'habitations pour ce terrain, aucune habitation n'a été créée");
	    this.nbHabitations = 0;
	}else{
	    this.listeHabitations = listHab;
	    this.nbHabitations = listeHabitations.size();
	}
	
    }// fin constructeur
    
    /**
     * Initialise interactivement le TerrainConstructible courant
     */
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
 		
    }// fin methode init
    
    /**
     * Définit le nombre d'habitations du terrain courant à la valeur passée en paramètre
     */
    public void setNbHabitation(int nb){
	if (nb <= 5 ){
	    this.nbHabitations = nb;
	}else{
	    System.out.println("le nombre d'habitation est trop grand pour sa superficie...");
	}
    }// fin methode setNbHabitation
    
    /**
     * Construit une Habitation sur le TerrainConstructible courant
     */
     public void construireHabitation(Habitation h) throws Exception{
	if (this.nbHabitations == 5) throw new Exception("Nombre maximum d'habitation atteint ! On ne peut plus en rajouter !");
	
	this.listeHabitations.add(h);
	this.nbHabitations++;
     }// fin methode construireHabitation

    /**
     * Détruit une habitation du TerrainConstructible courant puis la retourne
     */
     public Habitation detruireHabitation(Habitation h) throws Exception{
	
	for(int i=0; i<nbHabitations; i++){
	    
	    if(listeHabitations.get(i).equals(h)){
		this.listeHabitations.remove(i);
		return h;
	    }
	    i++;
	}
	throw new Exception("L'habitation n'est pas sur le terrain !");
	
     }// fin methode detruirehabitation
    
	public String toString(){
	    
	    String s = new String();
		for(int i=0; i<nbHabitations; i++){
		    s+= listeHabitations.get(i).toString() +"\n";
		}
		return super.toString() + s;
	}
    
    public void chargerTerrain(String nomFichier){
	Reader fln;
	BufferedReader bln;

	try{
	    fln = new FileReader(nomFichier);
	    bln = new BufferedReader(fln);
	    String ligne = bln.readLine();
	    int a=0;
	    
	    while(ligne != null)
		{
		    
		    StringTokenizer st = new StringTokenizer(ligne,";:");
				if(a==0 ){
				    this.setNomTerrain(ligne);
				    a++;
				}
				if(a==1 ){
				    this.setSuperficieTerrain(Integer.parseInt(ligne));
				}
				
				if(st.countTokens()==4){
				    String type = st.nextToken();
				    if(type.equals("Maison")){
					String adresse = st.nextToken();
					String nb = st.nextToken();
					int nbpiece = Integer.parseInt(nb);
					String typechauffage = st.nextToken();
					try {
					    this.construireHabitation(new Maison(adresse, nbpiece, typechauffage));
					}
					catch(Exception e){
					    System.out.println(e);
					}
					
				    }
					if(type.equals("Immeuble")){
					    String adresse = st.nextToken();
					    String nba = st.nextToken();
					    int nbApps = Integer.parseInt(nba);
					    String nbe = st.nextToken();
					    int nbEtages = Integer.parseInt(nbe);
					    try {
						this.construireHabitation(new Immeuble(adresse, nbApps, nbEtages));
					    }
					    catch(Exception e){
							System.out.println(e);
					    }
					}
					
					
				}
				if(st.countTokens() == 2){
				    String adresse = st.nextToken();
				    
				    try {
					this.construireHabitation(new Habitation(adresse));
				    }
					catch(Exception e){
					    System.out.println(e);
					}
				    
				}
				
				bln.readLine();
				
		}
<<<<<<< HEAD
	    
	    bln.close();
	    fln.close();
	}
		catch(Exception e){
		    System.out.println(e);
=======
		catch(IOException e){
			System.out.println(e);
			bln = null;
			fln = null;
>>>>>>> 9ca0e1b310679639234e1fe4aa9e81db1ca2d055
		}
    }
    
    public void sauvegarderTerrain(String nomFichier) throws IOException{
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