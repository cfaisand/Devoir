public class Test{

    public static void main(String[] args){

	TerrainConstructible t=new TerrainConstructible();

	t.init();

	t.construireHabitation(new Maison());
	t.construireHabitation(new Maison());
	t.construireHabitation(new Immeuble());

    }

}