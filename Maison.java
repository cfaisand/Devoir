public class Maison extends Habitation{

    private int nbPieces;
    private String typeChauffage;

    public Maison(){
	super();
    }

    public Maison(String uneAdresse, int nombrePieces, String typeChauffage){
	super(uneAdresse);
	this.nbPieces=nombrePieces;
	this.typeChauffage=typeChauffage;
    }

    public void init(){
	this.setAdresse(Lire.jString("Entrez l'adresse de la maison :\n"));
	this.nbPieces=Lire.jint("Entrez le nombre de pièces de la maison :\n");
	this.typeChauffage=Lire.jString("Entrez le type de chauffage de la maison :\n");
    }

    public int getnbPieces(){
	return this.nbPieces;
    }
    
    public String gettypeChauffage(){
	return this.typeChauffage;
    }

    public void setnbPieces(int n){
	this.nbPieces=n;
    }

    public void settypeChauffage(String s){
	this.typeChauffage=s;
    }

    public boolean equals(Object o){
	
	Maison m1=this;
	Maison m2=(Maison)o;

	return (m1.getAdresse()==m2.getAdresse() && m1.getnbPieces()==m2.getnbPieces() && m1.gettypeChauffage()==m2.gettypeChauffage());

    }

}