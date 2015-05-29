public class Habitation{

    private String adresse;

    public Habitation(){}

    public Habitation(String uneAdresse){
	this.adresse=uneAdresse;
    }

    public void init(){
	this.adresse=Lire.jString("Entrez l'adresse de l'habitation :\n");
    }

    public String getAdresse(){
	return this.adresse;
    }

    public void setAdresse(String a){
	this.adresse=a;
    }

    public boolean equals(Object o){
	
	Habitation h1=this;
	Habitation h2=(Habitation)o;

	return (h1.getAdresse()==h2.getAdresse());

    }

    public String toString(){
        return "Adresse : " + this.adresse;
    }

}