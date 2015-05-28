public class Test{

    public static void main(String[] args){

	TerrainConstructible t=new TerrainConstructible();

	t.init();

	try{
	t.construireHabitation(new Maison());
	}catch(Exception e){
	    System.out.println(e);
	}

	try{
	t.construireHabitation(new Maison());
	}catch(Exception e){
	    System.out.println(e);
	}

	try{
	t.construireHabitation(new Immeuble());
	}catch(Exception e){
	    System.out.println(e);
	}

	System.out.println(t.toString());


    }

}