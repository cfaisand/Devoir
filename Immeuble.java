public class Immeuble extends Habitation{

    private int nbApps;
    private int nbEtages;

    public Immeuble(){
	super();
    }

    public Immeuble(String uneAdresse, int nombreAppts, int nombreEtages){
	super(uneAdresse);
	this.nbApps=nombreAppts;
	this.nbEtages=nombreEtages;
    }

    public void init(){
	this.setAdresse(Lire.jString("Entrez l'adresse de l'immeuble :\n"));
	this.nbApps=Lire.jint("Entrez le nombre d'appartements de l'immeuble :\n");
	this.nbEtages=Lire.jint("Entrez le nombre d'étages de l'immeuble :\n");
    }

    public int getnbApps(){
	return this.nbApps;
    }

    public int getnbEtages(){
	return this.nbEtages;
    }

    public void setnbApps(int n){
	this.nbApps=n;
    }

    public void setnbEtages(int n){
	this.nbEtages=n;
    }

    public boolean equals(Object o){
	
	Immeuble i1=this;
	Immeuble i2=(Immeuble)o;
	
	return (i1.getAdresse()==i2.getAdresse() && i1.getnbApps()==i2.getnbApps() && i1.getnbEtages()==i2.getnbEtages());

    }

}